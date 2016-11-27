package com.lousylynx.summum.multiplex;

import com.lousylynx.summum.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemMultiplexBase extends ItemBase {

    public ItemMultiplexBase() {
        super("multiplex");

        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack){
        return MultiplexRegistry.getMultiplexName(stack.getMetadata());
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        for(int i = 0; i < MultiplexRegistry.id; i++) {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
}
