package com.lousylynx.summum.multiplex;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class MultiplexColors implements IItemColor {

    private final Map<Integer, Integer> colors = new HashMap<>();

    public void addColor(Multiplex multiplex) {
        colors.put(multiplex.getId(), multiplex.getColor());
    }

    public void addColor(int id, int color) {
        colors.put(id, color);
    }

    public int getColor(Multiplex multiplex) {
        return colors.get(multiplex.getId());
    }

    public int getColor(int id) {
        return colors.get(id);
    }

    @Override
    public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        int returnValue = 0;
        if (stack.getItem() instanceof ItemMultiplexBase) {
            ItemMultiplexBase i = (ItemMultiplexBase) stack.getItem();
            returnValue = getColor(i.getMetadata(stack));
        }
        return tintIndex > 0 ? returnValue : 0;
    }
}
