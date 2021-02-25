package com.impactarchitecture.loader;

import com.impactarchitecture.common.blocks.ConcreteBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MainLoader {

    public static Block Concrete;

    public static void registerBlocks() {
        Concrete = ConcreteBlock.registerBlock();
    }

    public static void registerOreDict() {
        for (int i = 0; i < 16; i++) {
            OreDictionary.registerOre("CompressedCoal", new ItemStack(Concrete, i));
        }
    }
}
