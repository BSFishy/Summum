package com.lousylynx.summum.proxy;

import com.lousylynx.summum.SummumItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ProxyCommon {

    public void preInit(FMLPreInitializationEvent e){
        registerItem(SummumItems.ULTIMUS_DUST);
        registerItem(SummumItems.ULTIMUS_CRYSTAL);
        registerItem(SummumItems.ULTIMUS_INGOT);

        GameRegistry.addRecipe(new ItemStack(SummumItems.ULTIMUS_DUST),
                "igi",
                "gdg",
                "igi",
                'd', new ItemStack(Items.DIAMOND),
                'g', new ItemStack(Items.GOLD_INGOT),
                'i', new ItemStack(Items.IRON_INGOT)
        );

        GameRegistry.addRecipe(new ItemStack(SummumItems.ULTIMUS_CRYSTAL),
                "ddd",
                "ded",
                "ddd",
                'e', new ItemStack(Blocks.DRAGON_EGG),
                'd', new ItemStack(SummumItems.ULTIMUS_DUST)
        );

        GameRegistry.addRecipe(new ItemStack(SummumItems.ULTIMUS_INGOT),
                "ded",
                "ece",
                "ded",
                'c', new ItemStack(SummumItems.ULTIMUS_CRYSTAL.setContainerItem(SummumItems.ULTIMUS_CRYSTAL)),
                'e', new ItemStack(Items.EMERALD),
                'd', new ItemStack(SummumItems.ULTIMUS_DUST)
        );
    }

    public void init(FMLInitializationEvent e){

    }

    public void postInit(FMLPostInitializationEvent e){

    }

/*    private void registerBlock(BlockBase block) {
        GameRegistry.<Block>register(block);
        GameRegistry.register(block.createItem());
    }

    private void registerTile(Class<? extends TileBase> tile, String id) {
        GameRegistry.registerTileEntity(tile, RS.ID + ":" + id);

        try {
            TileBase tileInstance = tile.newInstance();

            tileInstance.getDataManager().getParameters().forEach(TileDataManager::registerParameter);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/

    private void registerItem(Item item) {
        GameRegistry.register(item);
    }
}
