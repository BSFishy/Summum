package com.lousylynx.summum.tile;

import com.lousylynx.summum.container.ContainerCompressor;
import com.lousylynx.summum.multiplex.ItemMultiplexBase;
import com.lousylynx.summum.multiplex.Multiplex;
import com.lousylynx.summum.multiplex.MultiplexRegistryBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;

public class TileCompressor extends TileEntityLockable implements ISidedInventory, ITickable, IHasDirection {
    private static final String NBT_DIRECTION = "Direction";

    private EnumFacing direction = EnumFacing.EAST;
    protected int ticks = 0;

    private static final int[] SLOTS = new int[2];
    private static ItemStack[] compressorItemStacks = new ItemStack[2];

    private int numberOfItems = 0;
    private Multiplex multiplex;

    public TileCompressor(){

    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return SLOTS;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return index != 1 && (multiplex != null && multiplex.getRequiredItem().isItemEqual(itemStackIn));
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return index == 1 && stack.getItem() instanceof ItemMultiplexBase;
    }

    @Override
    public int getSizeInventory() {
        return compressorItemStacks.length;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index) {
        return compressorItemStacks[index];
    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(compressorItemStacks, index, count);
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(compressorItemStacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        compressorItemStacks[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();

            if(stack.getItem() instanceof ItemMultiplexBase)
                multiplex = MultiplexRegistryBase.getMultiplex(stack.getMetadata());
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return index != 1;
    }

    @Override
    public int getField(int id) {
        switch (id){
            case 0:
                return numberOfItems;
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        switch (id){
            case 0:
                numberOfItems = value;
                break;
        }
    }

    @Override
    public int getFieldCount() {
        return 1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < compressorItemStacks.length; ++i)
        {
            compressorItemStacks[i] = null;
        }
    }

    @Override
    public String getName() {
        return "Compressor";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerCompressor(this, playerIn);
    }

    @Override
    public String getGuiID() {
        return "summum:compressor";
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        compressorItemStacks = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < compressorItemStacks.length)
            {
                compressorItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        write(super.writeToNBT(tag));
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < compressorItemStacks.length; ++i)
        {
            if (compressorItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                compressorItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        tag.setTag("Items", nbttaglist);
        return tag;
    }

    IItemHandler handler = new InvWrapper(this);

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing){
        if (capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (T) handler;
        return super.getCapability(capability, facing);
    }

    @Override
    public void update() {
        if (!getWorld().isRemote) {
            ticks++;

            //dataManager.detectAndSendChanges();
        }
    }

    public void setDirection(EnumFacing direction) {
        this.direction = direction;

        markDirty();
    }

    public EnumFacing getDirection() {
        return direction;
    }

    public TileEntity getFacingTile() {
        return getWorld().getTileEntity(pos.offset(direction));
    }

    public NBTTagCompound write(NBTTagCompound tag) {
        tag.setInteger(NBT_DIRECTION, direction.ordinal());

        return tag;
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return write(super.getUpdateTag());
    }

    public void updateBlock() {
        if (getWorld() != null) {
            getWorld().notifyBlockUpdate(pos, getWorld().getBlockState(pos), getWorld().getBlockState(pos), 1 | 2);
        }
    }
}
