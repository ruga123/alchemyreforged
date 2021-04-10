package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModVariables;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;

@AlchemyConstructRugsModElements.ModElement.Tag
public class AlchemistsConcoctionRightClickedOnBlockProcedure extends AlchemyConstructRugsModElements.ModElement {
	public AlchemistsConcoctionRightClickedOnBlockProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure AlchemistsConcoctionRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency itemstack for procedure AlchemistsConcoctionRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			ItemStack _setval = (itemstack);
			entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LastHeldConcoction = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
