package com.lousylynx.summum.util;

import com.lousylynx.summum.SummumItems;
import com.lousylynx.summum.items.armor.ItemUltimusArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ArmorEventHandler {

    @SubscribeEvent
    public void onLivingUpdateEvent(LivingUpdateEvent event) {
        if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer) {
            if (((EntityPlayer) event.getEntity()).inventory.armorItemInSlot(2) != null) {
                ((EntityPlayer) event.getEntity()).capabilities.allowFlying = ((EntityPlayer) event.getEntity()).inventory.armorItemInSlot(2).getItem().equals(SummumItems.ULTIMUS_CHESTPLATE) || ((EntityPlayer) event.getEntity()).capabilities.isCreativeMode;
            } else if (((EntityPlayer) event.getEntity()).isCreative()) {
                ((EntityPlayer) event.getEntity()).capabilities.allowFlying = false;
            } else {
                ((EntityPlayer) event.getEntity()).capabilities.allowFlying = false;
                ((EntityPlayer) event.getEntity()).capabilities.isFlying = false;
            }
        }
    }
}
