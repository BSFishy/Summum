package com.lousylynx.summum.items.tools.pickaxe;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class ItemUltimusPickaxe extends ItemPickaxeBase {
    public ItemUltimusPickaxe() {
        super("ultimus_pickaxe");
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn){
        return true;
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack){
        return ImmutableSet.of("pickaxe", "shovel", "axe", "shear");
    }
}
