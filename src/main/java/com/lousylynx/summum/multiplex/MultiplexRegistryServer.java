package com.lousylynx.summum.multiplex;

public class MultiplexRegistryServer extends MultiplexRegistryBase {
    @Override
    public String getMultiplexNameSided(int id) {
        return "Multiplex";
    }

    @Override
    public void registerMultiplexes() {
        if (!createdItems)
            registerMultiplexes();
    }
}
