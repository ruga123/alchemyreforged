package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;
import java.util.HashMap;

@AlchemyConstructRugsModElements.ModElement.Tag
public class NbtMoveToEntityProcedure extends AlchemyConstructRugsModElements.ModElement {
	public NbtMoveToEntityProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 102);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure NbtMoveToEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double modify = 0;
		ItemStack returnval = ItemStack.EMPTY;
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.ARROW, (int) (1))) : false)
				|| (((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.SPECTRAL_ARROW, (int) (1)))
						: false)
						|| (((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.TIPPED_ARROW, (int) (1)))
								: false) || ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.BOW, (int) (1)).getItem())) {
				returnval = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				entity.getPersistentData().putDouble("strength", ((returnval).getOrCreateTag().getDouble("strength")));
				entity.getPersistentData().putDouble("haste", ((returnval).getOrCreateTag().getDouble("haste")));
				entity.getPersistentData().putDouble("nightvision", ((returnval).getOrCreateTag().getDouble("nightvision")));
				entity.getPersistentData().putDouble("speed", ((returnval).getOrCreateTag().getDouble("speed")));
				entity.getPersistentData().putDouble("regeneration", ((returnval).getOrCreateTag().getDouble("regeneration")));
				entity.getPersistentData().putDouble("resistance", ((returnval).getOrCreateTag().getDouble("resistance")));
				entity.getPersistentData().putDouble("poison", ((returnval).getOrCreateTag().getDouble("poison")));
				entity.getPersistentData().putDouble("wither", ((returnval).getOrCreateTag().getDouble("wither")));
				entity.getPersistentData().putDouble("resistance", ((returnval).getOrCreateTag().getDouble("resistance")));
				entity.getPersistentData().putDouble("luck", ((returnval).getOrCreateTag().getDouble("luck")));
				entity.getPersistentData().putDouble("waterbreathing", ((returnval).getOrCreateTag().getDouble("waterbreathing")));
				entity.getPersistentData().putDouble("health", ((returnval).getOrCreateTag().getDouble("health")));
				entity.getPersistentData().putDouble("fireresistance", ((returnval).getOrCreateTag().getDouble("fireresistance")));
				entity.getPersistentData().putDouble("glow", ((returnval).getOrCreateTag().getDouble("glow")));
				entity.getPersistentData().putDouble("levitation", ((returnval).getOrCreateTag().getDouble("levitation")));
				entity.getPersistentData().putDouble("slowfall", ((returnval).getOrCreateTag().getDouble("slowfall")));
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.BOW, (int) (1)).getItem())) {
				returnval = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
				entity.getPersistentData().putDouble("strength", ((returnval).getOrCreateTag().getDouble("strength")));
				entity.getPersistentData().putDouble("haste", ((returnval).getOrCreateTag().getDouble("haste")));
				entity.getPersistentData().putDouble("nightvision", ((returnval).getOrCreateTag().getDouble("nightvision")));
				entity.getPersistentData().putDouble("speed", ((returnval).getOrCreateTag().getDouble("speed")));
				entity.getPersistentData().putDouble("regeneration", ((returnval).getOrCreateTag().getDouble("regeneration")));
				entity.getPersistentData().putDouble("resistance", ((returnval).getOrCreateTag().getDouble("resistance")));
				entity.getPersistentData().putDouble("poison", ((returnval).getOrCreateTag().getDouble("poison")));
				entity.getPersistentData().putDouble("wither", ((returnval).getOrCreateTag().getDouble("wither")));
				entity.getPersistentData().putDouble("resistance", ((returnval).getOrCreateTag().getDouble("resistance")));
				entity.getPersistentData().putDouble("luck", ((returnval).getOrCreateTag().getDouble("luck")));
				entity.getPersistentData().putDouble("waterbreathing", ((returnval).getOrCreateTag().getDouble("waterbreathing")));
				entity.getPersistentData().putDouble("health", ((returnval).getOrCreateTag().getDouble("health")));
				entity.getPersistentData().putDouble("fireresistance", ((returnval).getOrCreateTag().getDouble("fireresistance")));
				entity.getPersistentData().putDouble("glow", ((returnval).getOrCreateTag().getDouble("glow")));
				entity.getPersistentData().putDouble("levitation", ((returnval).getOrCreateTag().getDouble("levitation")));
				entity.getPersistentData().putDouble("slowfall", ((returnval).getOrCreateTag().getDouble("slowfall")));
			}
		}
	}

	@SubscribeEvent
	public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand()) {
			return;
		}
		double i = event.getPos().getX();
		double j = event.getPos().getY();
		double k = event.getPos().getZ();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
