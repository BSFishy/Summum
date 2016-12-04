package com.lousylynx.summum.container;

import com.lousylynx.summum.tile.TileCompressor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerCompressor extends ContainerBase {
    protected TileCompressor tile;

    public ContainerCompressor(IInventory oldTile, EntityPlayer player) {
        super((TileCompressor) oldTile, player);

        tile = (TileCompressor) oldTile;

        addSlotToContainer(new Slot(tile, 0, 152, 13));
        addSlotToContainer(new SlotCompressorOutput(player, tile, 1, 152, 59));

        addPlayerInventory(8, 84);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
        ItemStack itemstack = null;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(index == 1){
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if(index != 0){
                if (index >= 2 && index < 29)
                {
                    if (!this.mergeItemStack(itemstack1, 29, 38, false))
                    {
                        return null;
                    }
                }
                else if (index >= 29 && index < 38 && !this.mergeItemStack(itemstack1, 3, 29, false))
                {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 2, 38, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }
        return itemstack;
    }
}
