package com.lousylynx.summum;

import com.lousylynx.summum.proxy.ProxyCommon;
import com.lousylynx.summum.util.ArmorEventHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SummumMod.MODID, name = SummumMod.NAME, version = SummumMod.VERSION, /*guiFactory = SummumMod.GUI_FACTORY,*/ dependencies = SummumMod.DEPENDENCIES)
public final class SummumMod {

    public static final String MODID = "summum";
    public static final String NAME = "Summum";
    public static final String VERSION = "0.3";
    public static final String DEPENDENCIES = "required-after:Forge@[12.18.2.2116,);";
    /*public static final String GUI_FACTORY = "";*/

    @SidedProxy(clientSide = "com.lousylynx.summum.proxy.ClientProxy", serverSide = "com.lousylynx.summum.proxy.ProxyCommon")
    public static ProxyCommon PROXY;

    @Instance
    public static SummumMod INSTANCE;

    public static CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack getIconItemStack() {
            return new ItemStack(SummumItems.ULTIMUS_DUST);
        }

        @Override
        public Item getTabIconItem() {
            return null;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        PROXY.preInit(e);

        ArmorEventHandler handler = new ArmorEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        PROXY.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        PROXY.postInit(e);
    }
}
