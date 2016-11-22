package com.lousylynx.summum.proxy;

import com.lousylynx.summum.SummumItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ProxyCommon {

    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_DUST, 0, new ModelResourceLocation("summum:ultimus_dust"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_CRYSTAL, 0, new ModelResourceLocation("summum:ultimus_crystal"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_INGOT, 0, new ModelResourceLocation("summum:ultimus_ingot"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_SWORD, 0, new ModelResourceLocation("summum:ultimus_sword"));
    }

    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
