package com.lousylynx.summum.multiplex;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class MultiplexRegistryClient extends MultiplexRegistryBase {
    MultiplexColors colors = new MultiplexColors();

    @Override
    public String getMultiplexNameSided(int id) {
        Multiplex m = getMultiplex(id);
        ItemStack i = m.getRequiredItem();
        return /*i.getDisplayName()*/m.getName() + " " + I18n.format("item.summum:multiplex.name");
    }

    @Override
    public void registerMultiplexes() {
        if (!createdItems)
            registerItems();

        multiplexes.forEach(m -> {
            ItemMultiplexBase i = getItemFromMultiplex(m);
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, m.getId(), new ModelResourceLocation("summum:multiplex", "inventory"));

            colors.addColor(m);
            Minecraft.getMinecraft().getItemColors().registerItemColorHandler(colors, i);
        });
    }
}
