package com.impactarchitecture.common.blocks;

import com.impactarchitecture.common.itemblocks.IBIGlass;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

import static com.impactarchitecture.ImpactArchitectureModule.TEXTURE_PATH;

public class IGlassBlock extends BaseBlock {

    public static final IGlassBlock instance = new IGlassBlock();

    private final IIcon[] glass = new IIcon[16];

    private IGlassBlock() {
        super(Material.glass);
    }

    public static Block registerBlock() {
        final String blockName = "i_glass";
        instance.setBlockName(blockName);
        instance.setHardness(1f);
        instance.setResistance(1f);
        instance.setHarvestLevel("wrench", 0);
        instance.setStepSound(Block.soundTypeGlass);
        GameRegistry.registerBlock(instance, IBIGlass.class, blockName);
        return instance;
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        for (int i = 0; i < glass.length; i++) {
            glass[i] = ir.registerIcon(TEXTURE_PATH + ":" + "glass/" + "blockGB" + i);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int i = 0; i < glass.length; i++) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return glass[meta];
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldClient, int xCoord, int yCoord, int zCoord,
                                        int aSide) {
        if (worldClient.getBlock(xCoord, yCoord, zCoord).equals(this)) {
            return false;
        }
        return super.shouldSideBeRendered(worldClient, xCoord, yCoord, zCoord, aSide);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    protected boolean canSilkHarvest() {
        return false;
    }
}