package com.lousylynx.summum.items.armor;

import com.lousylynx.summum.SummumMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemUltimusArmor extends ItemArmor {
    private String name;
    public static ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ARMOR_MATERIAL", "summum:ultimus_armor", -1, new int[]{25, 25, 25, 25}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Float.MAX_VALUE);

    public ItemUltimusArmor(String name, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(ARMOR_MATERIAL, renderIndexIn, equipmentSlotIn);

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
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.capabilities.allowFlying) {
            player.capabilities.allowFlying = false;
        }
        //System.out.println(player.capabilities.allowFlying);
    }
}
