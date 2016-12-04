package com.lousylynx.summum.gui;

import com.lousylynx.summum.container.ContainerCompressor;
import com.lousylynx.summum.tile.TileCompressor;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCompressor extends GuiBase{

    private TileCompressor tile;
    private ContainerCompressor cont;

    public GuiCompressor(ContainerCompressor cont, IInventory inventory){
        super(new ContainerCompressor(inventory, cont.getPlayer()), 175, 165);

        tile = (TileCompressor) inventory;
        this.cont = cont;
    }

    @Override
    public void init(int x, int y) {
    }

    @Override
    public void update(int x, int y) {
    }

    @Override
    public void drawBackground(int x, int y, int mouseX, int mouseY) {
        bindTexture("gui/compressor.png");

        drawTexture(x, y, 0, 0, width, height);
    }

    @Override
    public void drawForeground(int mouseX, int mouseY) {
        drawString(7, 7, t("gui.summum:compressor"));
    }
}
