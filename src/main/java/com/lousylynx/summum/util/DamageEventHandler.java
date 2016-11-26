package com.lousylynx.summum.util;

import com.lousylynx.summum.items.armor.ItemUltimusArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DamageEventHandler {
    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent event) {
        if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            for (ItemStack stack : player.getArmorInventoryList()) {
                if (stack != null && stack.getItem() instanceof ItemUltimusArmor) {
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onHurtPlayer(LivingAttackEvent event) {
        if (event.getEntity() != null && event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            for (ItemStack stack : player.getArmorInventoryList()) {
                if (stack != null && stack.getItem() instanceof ItemUltimusArmor) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
