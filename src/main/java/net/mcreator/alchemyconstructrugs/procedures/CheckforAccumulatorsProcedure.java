package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.alchemyconstructrugs.block.HeatAccumulatorBlock;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;

@AlchemyConstructRugsModElements.ModElement.Tag
public class CheckforAccumulatorsProcedure extends AlchemyConstructRugsModElements.ModElement {
	public CheckforAccumulatorsProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 19);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency x for procedure CheckforAccumulators!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency y for procedure CheckforAccumulators!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency z for procedure CheckforAccumulators!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency world for procedure CheckforAccumulators!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == HeatAccumulatorBlock.block.getDefaultState()
				.getBlock())
				|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == HeatAccumulatorBlock.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == HeatAccumulatorBlock.block
								.getDefaultState().getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == HeatAccumulatorBlock.block
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
												.getBlock() == HeatAccumulatorBlock.block.getDefaultState().getBlock())
												|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
														.getBlock() == HeatAccumulatorBlock.block.getDefaultState().getBlock()))))))) {
			return (true);
		}
		return (false);
	}
}
