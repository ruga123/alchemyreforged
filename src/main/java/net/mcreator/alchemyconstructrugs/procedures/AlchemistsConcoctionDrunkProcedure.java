package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModVariables;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;

@AlchemyConstructRugsModElements.ModElement.Tag
public class AlchemistsConcoctionDrunkProcedure extends AlchemyConstructRugsModElements.ModElement {
	public AlchemistsConcoctionDrunkProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure AlchemistsConcoctionDrunk!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Length = 0;
		Length = (double) 900;
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("strength")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("strength"))
								- 1)),
						(true), (false)));
		} else if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
						.getDouble("strength")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) (Length),
						(int) (Math.abs((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("strength")))
								- 1),
						(true), (false)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("health")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 2,
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("health"))
								- 1)),
						(false), (true)));
		} else if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("health")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) 2,
						(int) (Math.abs((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("health")))
								- 1),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("luck")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("luck"))
								- 1)),
						(false), (true)));
		} else if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("luck")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.UNLUCK, (int) (Length),
						(int) (Math.abs((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("luck")))
								- 1),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
						.getDouble("nightvision")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("nightvision"))
								- 1)),
						(false), (true)));
		} else if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
						.getDouble("nightvision")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) (Length),
						(int) (Math.abs((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("nightvision")))
								- 1),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("speed")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("speed"))
								- 1)),
						(false), (true)));
		} else if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("speed")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) (Length),
						(int) (Math.abs((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("speed")))
								- 1),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("haste")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("haste"))
								- 1)),
						(false), (true)));
		} else if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("haste")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) (Length),
						(int) (Math.abs((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("haste")))
								- 1),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
						.getDouble("fireresistance")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("fireresistance"))
								- 1)),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
						.getDouble("regeneration")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("regeneration"))
								- 1)),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("poison")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("poison"))
								- 1)),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("wither")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("wither"))
								- 1)),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
						.getDouble("resistance")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("resistance"))
								- 1)),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("jumpboost")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("jumpboost"))
								- 1)),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
						.getDouble("waterbreathing")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("waterbreathing"))
								- 1)),
						(false), (true)));
		}
		if (((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag().getDouble("glow")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) (Length),
						(int) Math.abs(((((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).LastHeldConcoction).getOrCreateTag()
										.getDouble("glow"))
								- 1)),
						(false), (true)));
		}
	}
}
