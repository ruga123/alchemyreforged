
package net.mcreator.alchemyconstructrugs.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress9Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress8Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress7Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress6Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress5Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress4Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress3Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress2Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress20Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress1Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress19Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress18Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress17Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress16Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress15Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress14Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress13Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress12Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress11Procedure;
import net.mcreator.alchemyconstructrugs.procedures.CheckMixingProgress10Procedure;

import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class AlchemyStationGuiGuiWindow extends ContainerScreen<AlchemyStationGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public AlchemyStationGuiGuiWindow(AlchemyStationGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("alchemy_construct_rugs:textures/alchemy_station_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/alchemy_station_background_final.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		if (CheckMixingProgress1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl1.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl2.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl3.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl4.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl5.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl6.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl7.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl8.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl9.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl10.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress11Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl11.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress12Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl12.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress13Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl13.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress14Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl14.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress15Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl15.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress16Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl16.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress17Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl17.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress18Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl18.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress19Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl19.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		if (CheckMixingProgress20Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/swirl20.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("alchemy_construct_rugs:textures/alchemistjargui.png"));
		this.blit(ms, this.guiLeft + 25, this.guiTop + 33, 0, 0, 16, 16, 16, 16);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "heatvalue")) + "\u00B0", 119, 5, -6711040);
		this.font.drawString(ms, "Alchemy Station", 6, 7, -13421773);
		this.font.drawString(ms, "" + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "mixingprogress")) + "", 4, 64, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
