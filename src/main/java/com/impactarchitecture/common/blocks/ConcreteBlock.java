package com.impactarchitecture.common.blocks;

import com.impactarchitecture.common.itemblocks.IBConcrete;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ConcreteBlock extends BaseBlock {

    private static final ConcreteBlock instance = new ConcreteBlock();
    private IIcon[] icons = new IIcon[16];

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
        for (int i = 0; i < icons.length; i++) {
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

    @Override
    public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity e) {
        e.motionX *= 1.4D;
        e.motionZ *= 1.4D;
    }
}
