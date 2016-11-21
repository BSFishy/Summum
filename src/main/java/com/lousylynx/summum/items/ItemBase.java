package com.lousylynx.summum.items;

import com.lousylynx.summum.SummumMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class ItemBase extends Item {
    private String name;

    public ItemBase(String name) {
        this.name = name;

        setRegistryName(SummumMod.MODID, name);
        setCreativeTab(SummumMod.INSTANCE.TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return "item." + SummumMod.MODID + ":" + name;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (getHasSubtypes()) {
            return getUnlocalizedName() + "." + stack.getItemDamage();
        }

        return getUnlocalizedName();
    }
}