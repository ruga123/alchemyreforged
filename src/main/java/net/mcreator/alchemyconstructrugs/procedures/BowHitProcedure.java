package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemyconstructrugs.item.ThrowableConcoctionItem;
import net.mcreator.alchemyconstructrugs.item.AlchemistsConcoctionItem;
import net.mcreator.alchemyconstructrugs.block.ConcoctionTntBlock;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;
import java.util.HashMap;

@AlchemyConstructRugsModElements.ModElement.Tag
public class BowHitProcedure extends AlchemyConstructRugsModElements.ModElement {
	public BowHitProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 101);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure BowHit!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BowHit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double Length = 0;
		ItemStack HeldItem = ItemStack.EMPTY;
		Length = (double) 100;
		HeldItem = ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY);
		if ((!((new ItemStack(AlchemistsConcoctionItem.block, (int) (1)).getItem() == (HeldItem).getItem())
				|| ((new ItemStack(ThrowableConcoctionItem.block, (int) (1)).getItem() == (HeldItem).getItem())
						|| (new ItemStack(ConcoctionTntBlock.block, (int) (1)).getItem() == (HeldItem).getItem()))))) {
			if ((((HeldItem).getOrCreateTag().getDouble("strength")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("strength")) - 1)), (true), (false)));
			} else if ((((HeldItem).getOrCreateTag().getDouble("strength")) <= (-1))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) (Length),
							(int) (Math.abs(((HeldItem).getOrCreateTag().getDouble("strength"))) - 1), (true), (false)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("health")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 2,
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("health")) - 1)), (false), (true)));
			} else if ((((HeldItem).getOrCreateTag().getDouble("health")) <= (-1))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) 2,
							(int) (Math.abs(((HeldItem).getOrCreateTag().getDouble("health"))) - 1), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("luck")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("luck")) - 1)), (false), (true)));
			} else if ((((HeldItem).getOrCreateTag().getDouble("luck")) <= (-1))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.UNLUCK, (int) (Length),
							(int) (Math.abs(((HeldItem).getOrCreateTag().getDouble("luck"))) - 1), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("nightvision")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("nightvision")) - 1)), (false), (true)));
			} else if ((((HeldItem).getOrCreateTag().getDouble("nightvision")) <= (-1))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) (Length),
							(int) (Math.abs(((HeldItem).getOrCreateTag().getDouble("nightvision"))) - 1), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("speed")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("speed")) - 1)), (false), (true)));
			} else if ((((HeldItem).getOrCreateTag().getDouble("speed")) <= (-1))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) (Length),
							(int) (Math.abs(((HeldItem).getOrCreateTag().getDouble("speed"))) - 1), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("haste")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("haste")) - 1)), (false), (true)));
			} else if ((((HeldItem).getOrCreateTag().getDouble("haste")) <= (-1))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) (Length),
							(int) (Math.abs(((HeldItem).getOrCreateTag().getDouble("haste"))) - 1), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("fireresistance")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("fireresistance")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("regeneration")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("regeneration")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("poison")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("poison")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("wither")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("wither")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("resistance")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("resistance")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("jumpboost")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("jumpboost")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("waterbreathing")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("waterbreathing")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("glow")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("glow")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("levitation")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("levitation")) - 1)), (false), (true)));
			}
			if ((((HeldItem).getOrCreateTag().getDouble("slowfall")) >= 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) (Length),
							(int) Math.abs((((HeldItem).getOrCreateTag().getDouble("slowfall")) - 1)), (false), (true)));
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
