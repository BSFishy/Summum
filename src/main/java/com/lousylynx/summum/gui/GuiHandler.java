package com.lousylynx.summum.gui;

import com.lousylynx.summum.container.ContainerCompressor;
import com.lousylynx.summum.tile.TileCompressor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    private Container getContainer(int ID, EntityPlayer player, TileEntity tile){
        switch (ID){
            case 0:
                return new ContainerCompressor((TileCompressor) tile, player);
            default:
                return null;
        }
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return getContainer(ID, player, world.getTileEntity(new BlockPos(x, y, z)));
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        switch (ID){
            case 0:
                return new GuiCompressor((ContainerCompressor) getContainer(ID, player, tile), (TileCompressor) tile);
            default:
                return null;
        }
    }
}
