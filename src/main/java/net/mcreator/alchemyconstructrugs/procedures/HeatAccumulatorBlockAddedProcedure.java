package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

@AlchemyConstructRugsModElements.ModElement.Tag
public class HeatAccumulatorBlockAddedProcedure extends AlchemyConstructRugsModElements.ModElement {
	public HeatAccumulatorBlockAddedProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure HeatAccumulatorBlockAdded!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency itemstack for procedure HeatAccumulatorBlockAdded!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency x for procedure HeatAccumulatorBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency y for procedure HeatAccumulatorBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency z for procedure HeatAccumulatorBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency world for procedure HeatAccumulatorBlockAdded!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
			((itemstack)).grow((int) 1);
		}
		if ((BlockTags.getCollection()
				.getTagByID(new ResourceLocation(("alchemy_construct_rugs:heat_producer").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))) {
			if (CheckforAccumulatorsProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			} else {
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, (new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) (y - 1), (int) z)))), 3);
					} else {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
								_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), (new Object() {
									public Direction getDirection(BlockPos pos) {
										try {
											BlockState _bs = world.getBlockState(pos);
											DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
											if (property != null)
												return _bs.get(property);
											return Direction.getFacingFromAxisDirection(
													_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
													Direction.AxisDirection.POSITIVE);
										} catch (Exception e) {
											return Direction.NORTH;
										}
									}
								}.getDirection(new BlockPos((int) x, (int) (y - 1), (int) z))).getAxis()), 3);
					}
				} catch (Exception e) {
				}
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)),
							((World) world).getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1))).getBlock());
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)),
							((World) world).getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1))).getBlock());
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) (x - 1), (int) (y - 1), (int) z),
							((World) world).getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z)).getBlock());
				if (world instanceof World)
					((World) world).notifyNeighborsOfStateChange(new BlockPos((int) (x + 1), (int) (y - 1), (int) z),
							((World) world).getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z)).getBlock());
				if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
					((itemstack)).shrink((int) 1);
				}
			}
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
