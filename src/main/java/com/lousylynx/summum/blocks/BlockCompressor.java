package com.lousylynx.summum.blocks;

import com.lousylynx.summum.SummumGui;
import com.lousylynx.summum.SummumMod;
import com.lousylynx.summum.tile.TileCompressor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCompressor extends BlockBase {
    public BlockCompressor() {
        super("compressor");
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileCompressor();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(SummumMod.INSTANCE, SummumGui.COMPRESSOR, world, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }
}
