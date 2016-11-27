package com.lousylynx.summum.multiplex.yaml;

import com.lousylynx.summum.multiplex.Multiplex;
import com.lousylynx.summum.multiplex.MultiplexRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiplexLoader {

    private List<Multiplex> multiplexes = new ArrayList<>();
    private Yaml yaml;

    @SuppressWarnings("unchecked")
    public void initialize(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        yaml = new Yaml();
        Map<String, Map<String, Object>> multiplexes = (Map<String, Map<String, Object>>) yaml.load(fileToString(file));
        loadMultiplexes(multiplexes);
    }

    private void loadMultiplexes(Map<String, Map<String, Object>> multiplexes) {
        for (String name : multiplexes.keySet()) {
            Map<String, Object> data = multiplexes.get(name);
            MultiplexChecker checker = new MultiplexChecker(name, data);
            if (checker.check()) {
                Multiplex m = new Multiplex(name, ((int) data.get("red") << 16 | (int) data.get("green") << 8 | (int) data.get("blue")), (checker.HAS_METADATA ? getItem((String) data.get("requiredItem"), (int) data.get("metadata")) : getItem((String) data.get("requiredItem"))), (int) data.get("requiredItemAmount"));
                MultiplexRegistry.addMultiplex(m);
            }
        }
    }

    protected static ItemStack getItem(String name) // fqrn = fully qualified resource name
    {
        Item i = Item.getByNameOrId(name);
        if(i == null){
            return null;
        }

        return new ItemStack(i);
    }

    protected static ItemStack getItem(String name, int metadata) {
        Item i = Item.getByNameOrId(name);
        if(i == null){
            return null;
        }
        ItemStack stack = new ItemStack(i, 1, metadata);
        return stack;
    }

    private String fileToString(File f) {
        try {
            return new String(Files.readAllBytes(f.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
