package com.lousylynx.summum.proxy;

import com.lousylynx.summum.SummumItems;
import com.lousylynx.summum.util.ArmorEventHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ProxyCommon {

    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        // MISC
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_DUST, 0, new ModelResourceLocation("summum:ultimus_dust"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_CRYSTAL, 0, new ModelResourceLocation("summum:ultimus_crystal"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_INGOT, 0, new ModelResourceLocation("summum:ultimus_ingot"));

        // TOOLS
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_SWORD, 0, new ModelResourceLocation("summum:ultimus_sword"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_PICKAXE, 0, new ModelResourceLocation("summum:ultimus_pickaxe"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_AXE, 0, new ModelResourceLocation("summum:ultimus_axe"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_SHOVEL, 0, new ModelResourceLocation("summum:ultimus_shovel"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_HOE, 0, new ModelResourceLocation("summum:ultimus_hoe"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_WAND, 0, new ModelResourceLocation("summum:ultimus_wand"));

        // ARMOR
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_HELMET, 0, new ModelResourceLocation("summum:ultimus_helmet"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_CHESTPLATE, 0, new ModelResourceLocation("summum:ultimus_chestplate"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_LEGGINGS, 0, new ModelResourceLocation("summum:ultimus_leggings"));
        ModelLoader.setCustomModelResourceLocation(SummumItems.ULTIMUS_BOOTS, 0, new ModelResourceLocation("summum:ultimus_boots"));

        registerHandlers();
    }

    private void registerHandlers() {
        ArmorEventHandler handler = new ArmorEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
    }

    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
