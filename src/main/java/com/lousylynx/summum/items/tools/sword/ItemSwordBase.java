package com.lousylynx.summum.items.tools.sword;

import com.lousylynx.summum.SummumMod;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSwordBase extends ItemSword {
    private String name;
    public static ToolMaterial SWORD_MATERIAL = EnumHelper.addToolMaterial("SWORD_MATERIAL", 3, -1, 0.0f, Float.MAX_VALUE, 22);

    public ItemSwordBase(String name) {
        super(SWORD_MATERIAL);

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
