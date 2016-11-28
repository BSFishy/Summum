package com.lousylynx.summum.multiplex.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiplexDefaultConfigGenerator {

    private final File file;

    public MultiplexDefaultConfigGenerator(File file){
        this.file = file;
    }

/*    public Map<String, Map<String, Object>> getDefaultConfigAsMap(){
        Yaml yaml = new Yaml();

        Map<String, Map<String, Object>> returnValue = (Map<String, Map<String, Object>>) yaml.load("Diamond: {\nred: 3,\ngreen: 169,\nblue: 244,\nrequiredItem: \"minecraft:diamond\",\nrequiredItemAmount: 500\n}\n\nIron: {\nred: 189,\ngreen: 195,\nblue: 199,\nrequiredItem: \"minecraft:iron_ingot\",\nrequiredItemAmount: 5000\n}\n\nLapis Lazuli: {\nred: 63,\ngreen: 81,\nblue: 181,\nrequiredItem: \"minecraft:dye\",\nmetadata: 4,\nrequiredItemAmount: 7000\n}\n\nGold: {\nred: 241,\ngreen: 196,\nblue: 15,\nrequiredItem: \"minecraft:gold_ingot\",\nrequiredItemAmount: 1000\n}\n\nRedstone: {\nred: 231,\ngreen: 76,\nblue: 60,\nrequiredItem: \"minecraft:redstone\",\nrequiredItemAmount: 10000\n}");
        return returnValue;
    }*/

    public void generateDefaultConfig(){
        //Yaml yaml = new Yaml();
        //String fileData = yaml.dump(getDefaultConfigAsMap());
        try {
            file.createNewFile();
            Files.write(file.toPath(), getDefaultConfig(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> getDefaultConfig(){
        List<String> lines = Arrays.asList("Diamond: {\nred: 3,\ngreen: 169,\nblue: 244,\nrequiredItem: \"minecraft:diamond\",\nrequiredItemAmount: 500\n}\n\nIron: {\nred: 189,\ngreen: 195,\nblue: 199,\nrequiredItem: \"minecraft:iron_ingot\",\nrequiredItemAmount: 5000\n}\n\nLapis Lazuli: {\nred: 63,\ngreen: 81,\nblue: 181,\nrequiredItem: \"minecraft:dye\",\nmetadata: 4,\nrequiredItemAmount: 7000\n}\n\nGold: {\nred: 241,\ngreen: 196,\nblue: 15,\nrequiredItem: \"minecraft:gold_ingot\",\nrequiredItemAmount: 1000\n}\n\nRedstone: {\nred: 231,\ngreen: 76,\nblue: 60,\nrequiredItem: \"minecraft:redstone\",\nrequiredItemAmount: 10000\n}".split("\n"));
        return lines;
    }
}
