package com.lousylynx.summum.items.tools.wand;

import com.google.common.collect.ImmutableSet;
import com.lousylynx.summum.SummumMod;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ItemWandBase extends ItemPickaxe {
    private String name;
    public static ToolMaterial WAND_MATERIAL = EnumHelper.addToolMaterial("WAND_MATERIAL", 3, -1, Float.MAX_VALUE, Float.MAX_VALUE, 22);

    public ItemWandBase(String name) {
        super(WAND_MATERIAL);

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

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        return true;
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return ImmutableSet.of("pickaxe", "shovel", "axe", "shear");
    }
}
