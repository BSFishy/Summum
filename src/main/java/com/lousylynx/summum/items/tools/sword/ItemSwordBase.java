package com.lousylynx.summum.items.tools.sword;

import com.lousylynx.summum.SummumMod;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword {
    private String name;

    public ItemSwordBase(String name) {
        super(SummumMod.INSTANCE.MATERIAL);

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
