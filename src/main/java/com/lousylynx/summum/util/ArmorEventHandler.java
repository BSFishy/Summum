package com.lousylynx.summum.util;

import com.lousylynx.summum.SummumItems;
import com.lousylynx.summum.items.armor.ItemUltimusArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ArmorEventHandler {

    @SubscribeEvent
    public void onLivingUpdateEvent(LivingUpdateEvent event) {
        if (event.getEntity() != null) {
            if (event.getEntity() instanceof EntityPlayer) {
                //System.out.print("A");
                if(((EntityPlayer) event.getEntity()).inventory.armorItemInSlot(1) != null) {
                    ((EntityPlayer) event.getEntity()).capabilities.allowFlying = !((EntityPlayer) event.getEntity()).inventory.armorItemInSlot(1).getItem().equals(SummumItems.ULTIMUS_CHESTPLATE) || ((EntityPlayer) event.getEntity()).capabilities.isCreativeMode;
                }else if(((EntityPlayer) event.getEntity()).isCreative()){
                    ((EntityPlayer) event.getEntity()).capabilities.isCreativeMode = false;
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent event) {
        if(event.getEntity() != null && event.getEntity() instanceof  EntityPlayer){
            EntityPlayer player = (EntityPlayer) event.getEntity();
            for(ItemStack stack : player.getArmorInventoryList()) {
                if(stack != null && stack.getItem() instanceof ItemUltimusArmor){
                    event.setCanceled(true);
                }
            }
        }
    }
}
