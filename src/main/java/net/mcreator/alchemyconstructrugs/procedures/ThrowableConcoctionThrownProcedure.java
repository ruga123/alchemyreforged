package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;

@AlchemyConstructRugsModElements.ModElement.Tag
public class ThrowableConcoctionThrownProcedure extends AlchemyConstructRugsModElements.ModElement {
	public ThrowableConcoctionThrownProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 80);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure ThrowableConcoctionThrown!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency itemstack for procedure ThrowableConcoctionThrown!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double modify = 0;
		ItemStack returnval = ItemStack.EMPTY;
		entity.getPersistentData().putDouble("strength", ((itemstack).getOrCreateTag().getDouble("strength")));
		entity.getPersistentData().putDouble("haste", ((itemstack).getOrCreateTag().getDouble("haste")));
		entity.getPersistentData().putDouble("nightvision", ((itemstack).getOrCreateTag().getDouble("nightvision")));
		entity.getPersistentData().putDouble("speed", ((itemstack).getOrCreateTag().getDouble("speed")));
		entity.getPersistentData().putDouble("regeneration", ((itemstack).getOrCreateTag().getDouble("regeneration")));
		entity.getPersistentData().putDouble("resistance", ((itemstack).getOrCreateTag().getDouble("resistance")));
		entity.getPersistentData().putDouble("poison", ((itemstack).getOrCreateTag().getDouble("poison")));
		entity.getPersistentData().putDouble("wither", ((itemstack).getOrCreateTag().getDouble("wither")));
		entity.getPersistentData().putDouble("resistance", ((itemstack).getOrCreateTag().getDouble("resistance")));
		entity.getPersistentData().putDouble("luck", ((itemstack).getOrCreateTag().getDouble("luck")));
		entity.getPersistentData().putDouble("waterbreathing", ((itemstack).getOrCreateTag().getDouble("waterbreathing")));
		entity.getPersistentData().putDouble("health", ((itemstack).getOrCreateTag().getDouble("health")));
		entity.getPersistentData().putDouble("fireresistance", ((itemstack).getOrCreateTag().getDouble("fireresistance")));
		entity.getPersistentData().putDouble("glow", ((itemstack).getOrCreateTag().getDouble("glow")));
		if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
			((itemstack)).shrink((int) 1);
		}
	}
}
