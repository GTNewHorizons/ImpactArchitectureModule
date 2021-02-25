package com.impactarchitecture.common.blocks;

import com.impactarchitecture.common.itemblocks.IBConcrete;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ConcreteBlock extends BaseBlock {

    private IIcon[] icons = new IIcon[16];
    private static final ConcreteBlock instance = new ConcreteBlock();

    private ConcreteBlock() {
        super();
    }

    public static Block registerBlock() {
        final String blockName = "i_concrete_block";
        instance.setBlockName(blockName);
        instance.setHardness(1f);
        instance.setResistance(1f);
        GameRegistry.registerBlock(instance, IBConcrete.class, blockName);
        return instance;
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        for(int i = 0; i < icons.length; i++) {
            icons[i] = ir.registerIcon("impact:concrete/ConcreteBlock" + i);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i < icons.length; i++) {
            list.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return icons[meta];
    }
}
