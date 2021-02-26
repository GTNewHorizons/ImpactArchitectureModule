package com.impactarchitecture.loader;

import com.impactarchitecture.common.blocks.ConcreteBlock;
import net.minecraft.block.Block;

public class MainLoader {

    public static Block Concrete;

    public static void registerBlocks() {
        Concrete = ConcreteBlock.registerBlock();
    }
}
