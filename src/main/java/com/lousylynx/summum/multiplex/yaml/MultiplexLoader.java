package com.lousylynx.summum.multiplex.yaml;

import com.lousylynx.summum.multiplex.Multiplex;
import com.lousylynx.summum.multiplex.MultiplexRegistry;
import net.minecraft.item.Item;
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
            Multiplex m = new Multiplex(name, ((int) data.get("red") << 16 | (int) data.get("green") << 8 | (int) data.get("blue")), getItem((String) data.get("requiredItem")), (int) data.get("requiredItemAmount"));
            MultiplexRegistry.addMultiplex(m);
        }
    }

    private Item getItem(String name) // fqrn = fully qualified resource name
    {
        return Item.getByNameOrId(name);
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
