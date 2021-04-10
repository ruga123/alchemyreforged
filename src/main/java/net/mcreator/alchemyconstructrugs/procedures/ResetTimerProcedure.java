package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModVariables;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;

@AlchemyConstructRugsModElements.ModElement.Tag
public class ResetTimerProcedure extends AlchemyConstructRugsModElements.ModElement {
	public ResetTimerProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 72);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure ResetTimer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency world for procedure ResetTimer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).AlchemyStationOpenedX),
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).AlchemyStationOpenedY),
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).AlchemyStationOpenedZ));
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("timer", 0);
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).AlchemyStationOpenedX),
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).AlchemyStationOpenedY),
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).AlchemyStationOpenedZ));
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("mixingprogress", 0);
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
