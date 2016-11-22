package com.lousylynx.summum.items.tools.axe;

import com.lousylynx.summum.SummumMod;
import com.lousylynx.summum.items.tools.pickaxe.ItemPickaxeBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemAxeBase extends ItemAxe {
    private String name;
    //public static ToolMaterial PICKAXE_MATERIAL = EnumHelper.addToolMaterial("PICKAXE_MATERIAL", 3, -1, Float.MAX_VALUE, 0.0f, 22);

    protected ItemAxeBase(String name) {
        super(ItemPickaxeBase.PICKAXE_MATERIAL, 6.0f, -3.0f);

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
