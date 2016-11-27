package com.lousylynx.summum;

import com.lousylynx.summum.items.ItemUltimusCrystal;
import com.lousylynx.summum.items.ItemUltimusDust;
import com.lousylynx.summum.items.ItemUltimusIngot;
import com.lousylynx.summum.items.armor.ItemUltimusBoots;
import com.lousylynx.summum.items.armor.ItemUltimusChestplate;
import com.lousylynx.summum.items.armor.ItemUltimusHelmet;
import com.lousylynx.summum.items.armor.ItemUltimusLeggings;
import com.lousylynx.summum.items.tools.axe.ItemUltimusAxe;
import com.lousylynx.summum.items.tools.hoe.ItemUltimusHoe;
import com.lousylynx.summum.items.tools.pickaxe.ItemUltimusPickaxe;
import com.lousylynx.summum.items.tools.shove.ItemUltimusShovel;
import com.lousylynx.summum.items.tools.sword.ItemUltimusSword;
import com.lousylynx.summum.items.tools.wand.ItemUltimusWand;

public class SummumItems {

    // MISC
    public static ItemUltimusDust ULTIMUS_DUST = new ItemUltimusDust();
    public static ItemUltimusCrystal ULTIMUS_CRYSTAL = new ItemUltimusCrystal();
    public static ItemUltimusIngot ULTIMUS_INGOT = new ItemUltimusIngot();

    // TOOLS
    public static ItemUltimusSword ULTIMUS_SWORD = new ItemUltimusSword();
    public static ItemUltimusPickaxe ULTIMUS_PICKAXE = new ItemUltimusPickaxe();
    public static ItemUltimusShovel ULTIMUS_SHOVEL = new ItemUltimusShovel();
    public static ItemUltimusAxe ULTIMUS_AXE = new ItemUltimusAxe();
    public static ItemUltimusHoe ULTIMUS_HOE = new ItemUltimusHoe();
    public static ItemUltimusWand ULTIMUS_WAND = new ItemUltimusWand();

    // ARMOR
    public static ItemUltimusHelmet ULTIMUS_HELMET = new ItemUltimusHelmet();
    public static ItemUltimusChestplate ULTIMUS_CHESTPLATE = new ItemUltimusChestplate();
    public static ItemUltimusLeggings ULTIMUS_LEGGINGS = new ItemUltimusLeggings();
    public static ItemUltimusBoots ULTIMUS_BOOTS = new ItemUltimusBoots();
    
    static{
        ULTIMUS_CRYSTAL = (ItemUltimusCrystal) ULTIMUS_CRYSTAL.setContainerItem(ULTIMUS_CRYSTAL);
    }
}
