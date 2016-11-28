package com.lousylynx.summum.multiplex.yaml;

import com.google.common.base.Strings;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

import java.util.Map;

public class MultiplexChecker {

    private final String name;
    private final Map<String, Object> data;
    private boolean logging = false;

    protected boolean HAS_METADATA = false;

    public MultiplexChecker(String name, Map<String, Object> data) {
        this.name = name;
        this.data = data;
    }

    public boolean check() {
        boolean returnValue = true;
        boolean hasItem = false;


        if (!data.containsKey("red")) {
            logError("red");
            returnValue = false;
        }

        if (!data.containsKey("green")) {
            logError("green");
            returnValue = false;
        }

        if (!data.containsKey("blue")) {
            logError("blue");
            returnValue = false;
        }

        if (!data.containsKey("requiredItem")) {
            logError("requiredItem");
            returnValue = false;
        } else {
            hasItem = true;
        }

        if (data.containsKey("metadata")) {
            HAS_METADATA = true;
        }

        if (hasItem && !checkItem()) {
            returnValue = false;
        }

        if (!data.containsKey("requiredItemAmount")) {
            logError("requiredItemAmount");
            returnValue = false;
        }

        endLogging();

        return returnValue;
    }

    private boolean checkItem() {
        ItemStack i;
        if (HAS_METADATA) {
            i = MultiplexLoader.getItem((String) data.get("requiredItem"), (int) data.get("metadata"));
        } else {
            i = MultiplexLoader.getItem((String) data.get("requiredItem"));
        }

        if (i == null) {
            logError("has an item that is not in the game.", false);
            return false;
        }
        return true;
    }

    private void logError(String name, boolean format) {
        if (!logging) {
            logging = true;
            logLine();
        }

        if (format) {
            FMLLog.warning("The Multiplex: \"" + this.name + "\" is missing the value for " + name);
        } else {
            FMLLog.warning("The Multiplex: \"" + this.name + "\" " + name);
        }
    }

    private void logError(String name) {
        logError(name, true);
    }

    private void endLogging() {
        if (logging) {
            FMLLog.warning("The Multiplex: \"" + this.name + "\" will not be loaded");
            logLine();
        }
    }

    private void logLine() {
        FMLLog.warning(Strings.repeat("-+", 30));
    }
}
