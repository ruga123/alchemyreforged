package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;

@AlchemyConstructRugsModElements.ModElement.Tag
public class ThrowableConcoctionHitsProcedure extends AlchemyConstructRugsModElements.ModElement {
	public ThrowableConcoctionHitsProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 79);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure ThrowableConcoctionHits!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ThrowableConcoctionHits!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency x for procedure ThrowableConcoctionHits!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency y for procedure ThrowableConcoctionHits!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency z for procedure ThrowableConcoctionHits!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency world for procedure ThrowableConcoctionHits!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double Length = 0;
		Length = (double) 200;
		if (((sourceentity.getPersistentData().getDouble("strength")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) (Length),
						(int) Math.abs(((sourceentity.getPersistentData().getDouble("strength")) - 1)), (false), (true)));
		} else if (((sourceentity.getPersistentData().getDouble("strength")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("strength"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("health")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 2,
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("health"))) - 1), (false), (true)));
		} else if (((sourceentity.getPersistentData().getDouble("health")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) 2,
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("health"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("luck")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) (Length),
						(int) Math.abs(((sourceentity.getPersistentData().getDouble("luck")) - 1)), (false), (true)));
		} else if (((sourceentity.getPersistentData().getDouble("luck")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.UNLUCK, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("luck"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("nightvision")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) (Length),
						(int) Math.abs(((sourceentity.getPersistentData().getDouble("nightvision")) - 1)), (false), (true)));
		} else if (((sourceentity.getPersistentData().getDouble("nightvision")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("nightvision"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("speed")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) (Length),
						(int) Math.abs(((sourceentity.getPersistentData().getDouble("speed")) - 1)), (false), (true)));
		} else if (((sourceentity.getPersistentData().getDouble("speed")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("speed"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("haste")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) (Length),
						(int) Math.abs(((sourceentity.getPersistentData().getDouble("haste")) - 1)), (false), (true)));
		} else if (((sourceentity.getPersistentData().getDouble("haste")) <= (-1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("haste"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("regeneration")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("regeneration"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("resistance")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("resistance"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("poison")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("poison"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("wither")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("wither"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("wither")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("wither"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("jumpboost")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) (Length),
						(int) Math.abs(((sourceentity.getPersistentData().getDouble("jumpboost")) - 1)), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("fireresistance")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) (Length),
						(int) (Math.abs((sourceentity.getPersistentData().getDouble("fireresistance"))) - 1), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("waterbreathing")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) (Length),
						(int) Math.abs(((sourceentity.getPersistentData().getDouble("waterbreathing")) - 1)), (false), (true)));
		}
		if (((sourceentity.getPersistentData().getDouble("glow")) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) (Length),
						(int) Math.abs(((sourceentity.getPersistentData().getDouble("glow")) - 1)), (false), (true)));
		}
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.splash_potion.break")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.splash_potion.break")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
		world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(Blocks.GLASS.getDefaultState()));
	}
}
