package com.impactarchitecture;

import com.impactarchitecture.loader.MainLoader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.Collections;

@Mod(
        name = "Impact | Architecture Module",
        version = ImpactArchitectureModule.VERSION,
        modid = ImpactArchitectureModule.MODID
)
public class ImpactArchitectureModule {

    public static final String MODID = "Impact|Architecture";
    public static final String VERSION = "0.0.1";
    public static final String ASSET_PREFIX = "Impact|Architecture".toLowerCase();
    public static final String TEXTURE_PATH = "Impact".toLowerCase();

    @Mod.Instance("Impact|Architecture")
    public static ImpactArchitectureModule instance;

    public ImpactArchitectureModule() {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MainLoader.registerBlocks();
        MainLoader.registerOreDict();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    private void initModInfo(ModMetadata info) {
        info.autogenerated = false;
        info.modId = ASSET_PREFIX;
        info.name = "Impact | Architecture Module";
        info.version = VERSION;
        info.description = "Module for Impact";
        info.authorList = Collections.singletonList("Impact Team");
    }
}
