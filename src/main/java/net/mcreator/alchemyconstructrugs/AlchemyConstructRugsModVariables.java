package net.mcreator.alchemyconstructrugs;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class AlchemyConstructRugsModVariables {
	public AlchemyConstructRugsModVariables(AlchemyConstructRugsModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("alchemy_construct_rugs", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.put("LastHeldConcoction", instance.LastHeldConcoction.write(new CompoundNBT()));
			nbt.putDouble("AlchemyStationOpenedX", instance.AlchemyStationOpenedX);
			nbt.putDouble("AlchemyStationOpenedY", instance.AlchemyStationOpenedY);
			nbt.putDouble("AlchemyStationOpenedZ", instance.AlchemyStationOpenedZ);
			nbt.putDouble("HeaterOpenedX", instance.HeaterOpenedX);
			nbt.putDouble("HeaterOpenedY", instance.HeaterOpenedY);
			nbt.putDouble("HeaterOpenedZ", instance.HeaterOpenedZ);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.LastHeldConcoction = ItemStack.read(nbt.getCompound("LastHeldConcoction"));
			instance.AlchemyStationOpenedX = nbt.getDouble("AlchemyStationOpenedX");
			instance.AlchemyStationOpenedY = nbt.getDouble("AlchemyStationOpenedY");
			instance.AlchemyStationOpenedZ = nbt.getDouble("AlchemyStationOpenedZ");
			instance.HeaterOpenedX = nbt.getDouble("HeaterOpenedX");
			instance.HeaterOpenedY = nbt.getDouble("HeaterOpenedY");
			instance.HeaterOpenedZ = nbt.getDouble("HeaterOpenedZ");
		}
	}

	public static class PlayerVariables {
		public ItemStack LastHeldConcoction = ItemStack.EMPTY;
		public double AlchemyStationOpenedX = 0;
		public double AlchemyStationOpenedY = 0;
		public double AlchemyStationOpenedZ = 0;
		public double HeaterOpenedX = 0;
		public double HeaterOpenedY = 0;
		public double HeaterOpenedZ = 0;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				AlchemyConstructRugsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.LastHeldConcoction = original.LastHeldConcoction;
			clone.AlchemyStationOpenedX = original.AlchemyStationOpenedX;
			clone.AlchemyStationOpenedY = original.AlchemyStationOpenedY;
			clone.AlchemyStationOpenedZ = original.AlchemyStationOpenedZ;
			clone.HeaterOpenedX = original.HeaterOpenedX;
			clone.HeaterOpenedY = original.HeaterOpenedY;
			clone.HeaterOpenedZ = original.HeaterOpenedZ;
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.LastHeldConcoction = message.data.LastHeldConcoction;
					variables.AlchemyStationOpenedX = message.data.AlchemyStationOpenedX;
					variables.AlchemyStationOpenedY = message.data.AlchemyStationOpenedY;
					variables.AlchemyStationOpenedZ = message.data.AlchemyStationOpenedZ;
					variables.HeaterOpenedX = message.data.HeaterOpenedX;
					variables.HeaterOpenedY = message.data.HeaterOpenedY;
					variables.HeaterOpenedZ = message.data.HeaterOpenedZ;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
