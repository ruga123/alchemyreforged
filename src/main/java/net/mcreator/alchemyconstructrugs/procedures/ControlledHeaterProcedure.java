package net.mcreator.alchemyconstructrugs.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.BlockState;

import net.mcreator.alchemyconstructrugs.block.ControlledHeaterOnBlock;
import net.mcreator.alchemyconstructrugs.block.ControlledHeaterOffBlock;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModVariables;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsMod;

import java.util.Map;
import java.util.HashMap;

@AlchemyConstructRugsModElements.ModElement.Tag
public class ControlledHeaterProcedure extends AlchemyConstructRugsModElements.ModElement {
	public ControlledHeaterProcedure(AlchemyConstructRugsModElements instance) {
		super(instance, 99);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency entity for procedure ControlledHeater!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency guistate for procedure ControlledHeater!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemyConstructRugsMod.LOGGER.warn("Failed to load dependency world for procedure ControlledHeater!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		IWorld world = (IWorld) dependencies.get("world");
		if ((1 > new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:Degrees");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())))) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(
						(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedX),
						(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedY),
						(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedZ));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("setheat", 100);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(
						(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedX),
						(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedY),
						(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedZ));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("setheat", new Object() {
						int convert(String s) {
							try {
								return Integer.parseInt(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget textField = (TextFieldWidget) guistate.get("text:Degrees");
							if (textField != null) {
								return textField.getText();
							}
							return "";
						}
					}.getText())));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		{
			BlockPos _bp = new BlockPos(
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedX),
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedY),
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedZ));
			BlockState _bs = ControlledHeaterOffBlock.block.getDefaultState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
				if (_property != null && _bs.get(_property) != null)
					try {
						_bs = _bs.with(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			TileEntity _te = world.getTileEntity(_bp);
			CompoundNBT _bnbt = null;
			if (_te != null) {
				_bnbt = _te.write(new CompoundNBT());
				_te.remove();
			}
			world.setBlockState(_bp, _bs, 3);
			if (_bnbt != null) {
				_te = world.getTileEntity(_bp);
				if (_te != null) {
					try {
						_te.read(_bso, _bnbt);
					} catch (Exception ignored) {
					}
				}
			}
		}
		{
			BlockPos _bp = new BlockPos(
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedX),
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedY),
					(int) ((entity.getCapability(AlchemyConstructRugsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new AlchemyConstructRugsModVariables.PlayerVariables())).HeaterOpenedZ));
			BlockState _bs = ControlledHeaterOnBlock.block.getDefaultState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
				if (_property != null && _bs.get(_property) != null)
					try {
						_bs = _bs.with(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			TileEntity _te = world.getTileEntity(_bp);
			CompoundNBT _bnbt = null;
			if (_te != null) {
				_bnbt = _te.write(new CompoundNBT());
				_te.remove();
			}
			world.setBlockState(_bp, _bs, 3);
			if (_bnbt != null) {
				_te = world.getTileEntity(_bp);
				if (_te != null) {
					try {
						_te.read(_bso, _bnbt);
					} catch (Exception ignored) {
					}
				}
			}
		}
	}
}
