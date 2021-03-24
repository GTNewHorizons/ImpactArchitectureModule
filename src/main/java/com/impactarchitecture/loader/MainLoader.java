package com.impactarchitecture.loader;

import com.impactarchitecture.common.blocks.ConcreteBlock;
import com.impactarchitecture.common.blocks.IGlassBlock;
import net.minecraft.block.Block;

public class MainLoader {

    public static Block Concrete;
    public static Block IGlass;

    public static void registerBlocks() {
        Concrete = ConcreteBlock.registerBlock();
        IGlass = IGlassBlock.registerBlock();
    }
}
