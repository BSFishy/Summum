package com.lousylynx.summum.items.tools.shove;

import com.lousylynx.summum.SummumMod;
import com.lousylynx.summum.items.tools.pickaxe.ItemPickaxeBase;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemShovelBase extends ItemSpade {
    private String name;

    public ItemShovelBase(String name) {
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
