package com.lousylynx.summum.util;

import com.lousylynx.summum.SummumItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class ArmorEventHandler {

    @SubscribeEvent
    public void onLivingUpdateEvent(LivingUpdateEvent event) {
        if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            if (player.isCreative()) {
                player.capabilities.allowFlying = true;
                return;
            }

            if (player.inventory.armorItemInSlot(2) != null) {
                player.capabilities.allowFlying = player.inventory.armorItemInSlot(2).getItem().equals(SummumItems.ULTIMUS_CHESTPLATE) || player.capabilities.isCreativeMode;
            } else {
                player.capabilities.allowFlying = false;
                player.capabilities.isFlying = false;
            }
        }
    }
}
