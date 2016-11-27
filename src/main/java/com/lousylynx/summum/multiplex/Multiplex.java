package com.lousylynx.summum.multiplex;

import net.minecraft.item.ItemStack;

import java.util.Objects;

public class Multiplex {

    private final String name;
    private final int color;
    private final ItemStack requiredItem;
    private final int requiredItemAmount;
    private int id;

    public Multiplex(String name, int color, ItemStack requiredItem, int requiredItemAmount) {
        this.name = name;
        this.color = color;
        this.requiredItem = requiredItem;
        this.requiredItemAmount = requiredItemAmount;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public ItemStack getRequiredItem() {
        return requiredItem;
    }

    public int getRequiredItemAmount() {
        return requiredItemAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Multiplex)) {
            return false;
        }

        Multiplex m = (Multiplex) o;
        return Objects.equals(m.getName(), name) && m.getColor() == color && m.getRequiredItem().equals(requiredItem) && m.getRequiredItemAmount() == requiredItemAmount;
    }
}
