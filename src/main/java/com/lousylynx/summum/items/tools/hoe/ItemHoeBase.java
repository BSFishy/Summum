package com.lousylynx.summum.items.tools.hoe;

import com.lousylynx.summum.SummumMod;
import com.lousylynx.summum.items.tools.pickaxe.ItemPickaxeBase;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemHoeBase extends ItemHoe {
    private String name;

    public ItemHoeBase(String name) {
        super(ItemPickaxeBase.PICKAXE_MATERIAL);

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
