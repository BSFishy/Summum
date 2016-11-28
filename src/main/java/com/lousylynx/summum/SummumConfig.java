package com.lousylynx.summum;

import com.lousylynx.summum.multiplex.yaml.MultiplexLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SummumConfig {

    private static Configuration config;

    public static boolean hard_mode;
    public static boolean multiplex_mode;

    public static final String HARD_MODE = "hard_mode";
    public static final String MULTIPLEXES = "multiplexes";

    public static final MultiplexLoader multiplexLoader = new MultiplexLoader();

    public static Configuration getConfig() {
        return config;
    }

    public static void initialize() {
        File configFile = new File(SummumMod.INSTANCE.CONFIGURATION_DIRECTORY + "/main.cfg");
        config = new Configuration(configFile);

        MinecraftForge.EVENT_BUS.register(new Object() {
            @SubscribeEvent
            public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
                if (event.getModID().equals(SummumMod.MODID)) {
                    reloadConfig();
                }
            }
        });

        loadConfig();
    }

    public static void loadMultiplexes() {
        File multiplexFile = new File(SummumMod.INSTANCE.CONFIGURATION_DIRECTORY + "/multiplexes.yaml");
        multiplexLoader.initialize(multiplexFile);
    }

    public static void reloadConfig() {
        saveConfig();
        loadConfig();
    }

    public static void loadConfig() {
        hard_mode = config.getBoolean("hard_mode", HARD_MODE, false, "If the recipes should be harder than the regular recipes");
        multiplex_mode = config.getBoolean("multiplex_mode", HARD_MODE, false, "If the recipes should use Multiplexes. REQUIRES RESTART");

        saveConfig();
    }

    public static void saveConfig() {
        if (config.hasChanged())
            config.save();
    }

    public List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<>();

        list.add(new ConfigElement(config.getCategory(HARD_MODE)));
        list.add(new ConfigElement(config.getCategory(MULTIPLEXES)));

        return list;
    }
}
