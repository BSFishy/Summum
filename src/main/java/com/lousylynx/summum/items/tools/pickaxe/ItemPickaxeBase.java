package com.lousylynx.summum.items.tools.pickaxe;

import com.lousylynx.summum.SummumMod;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemPickaxeBase extends ItemPickaxe {
    private String name;
    public static ToolMaterial PICKAXE_MATERIAL = EnumHelper.addToolMaterial("PICKAXE_MATERIAL", 3, -1, Float.MAX_VALUE, 0.0f, 22);

    public ItemPickaxeBase(String name) {
        super(PICKAXE_MATERIAL);

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
