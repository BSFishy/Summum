package com.lousylynx.summum.multiplex;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class MultiplexRegistry {

    private static List<Multiplex> multiplexes = new ArrayList<>();
    private static boolean createdItems = false;
    private static List<ItemStack> items = new ArrayList<>();

    protected static int id = 0;
    protected static final MultiplexColors colors = new MultiplexColors();

    private MultiplexRegistry() {
    }

    public static List<Multiplex> getMultiplexes() {
        return multiplexes;
    }

    public static void addMultiplex(Multiplex multiplex) {
        multiplex.setId(id++);
        multiplexes.add(multiplex);
    }

    public static void addMultiplexes(Collection<Multiplex> multiplexes) {
        multiplexes.forEach(MultiplexRegistry::addMultiplex);
    }

    public static Multiplex getMultiplex(String name) {
        final Multiplex[] returnValue = {null};
        multiplexes.forEach((Multiplex m) -> {
            if (m.getName().equals(name)) returnValue[0] = m;
        });
        return returnValue[0];
    }

    public static Multiplex getMultiplex(int id) {
        final Multiplex[] returnValue = {null};
        multiplexes.forEach((Multiplex m) -> {
            if (m.getId() == id) returnValue[0] = m;
        });
        return returnValue[0];
    }

    public static String getMultiplexName(int id) {
        return getMultiplex(id).getName() + " " + I18n.format("item.summum:multiplex.name");
    }

    /*****************************************************************************************
     *                                                                                       *
     *                                       Items                                           *
     *                                                                                       *
     *****************************************************************************************/

    public static Multiplex getMultiplexFromItem(ItemMultiplexBase i) {
        final Multiplex[] returnValue = {null};
        multiplexes.forEach((Multiplex m) -> {
            if (Objects.equals(m.getName(), getMultiplexFromItem(i).getName())) returnValue[0] = m;
        });
        return returnValue[0];
    }

    private static void addItem(ItemStack i) {
        items.add(i);
    }

    public static void registerItems() {
        if (createdItems)
            return;

        ItemMultiplexBase i = new ItemMultiplexBase();
        GameRegistry.register(i);
        List<ItemStack> subItems = new ArrayList<>();
        i.getSubItems(i, null, subItems);
        subItems.forEach(MultiplexRegistry::addItem);
        createdItems = true;
    }

    public static ItemMultiplexBase getItemFromMultiplex(Multiplex m) {
        if (!createdItems)
            registerItems();

        ItemMultiplexBase[] returnValue = {null};
        items.forEach((ItemStack i) -> {
            if (i.getItem() instanceof ItemMultiplexBase && i.getItem().getMetadata(i) == m.getId()) {
                returnValue[0] = (ItemMultiplexBase) i.getItem();
            }
        });
        return returnValue[0];
    }

    @SideOnly(Side.CLIENT)
    public static void registerMultiplexes() {
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
