package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;
import java.util.HashMap;

@AlchemyConstructRugsModElements.ModElement.Tag
public class ConcoctionTntNeighbourBlockChangesProcedure extends AlchemyConstructRugsModElements.ModElement {
	public ConcoctionTntNeighbourBlockChangesProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 85);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency x for procedure ConcoctionTntNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency y for procedure ConcoctionTntNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency z for procedure ConcoctionTntNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency world for procedure ConcoctionTntNeighbourBlockChanges!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.FIRE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.SOUL_FIRE.getDefaultState()
						.getBlock()))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				ConcoctionTntBlowupProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
