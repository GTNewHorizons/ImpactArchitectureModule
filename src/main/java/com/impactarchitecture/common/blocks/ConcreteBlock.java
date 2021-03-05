package com.impactarchitecture.common.blocks;

import com.impactarchitecture.common.itemblocks.IBConcrete;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

public class ConcreteBlock extends BaseBlock {

    private static final ConcreteBlock instance = new ConcreteBlock();
    private IIcon[] icons = new IIcon[16];

    private ConcreteBlock() {
        super();
        FMLCommonHandler.instance().bus().register(this);
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
    @SideOnly(Side.CLIENT)
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

    @SideOnly(Side.CLIENT)
    private static MovementInput manualInputCheck;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void speedupPlayer(PlayerTickEvent event) {
        if (event.phase == Phase.START && event.side.isClient() && event.player.onGround && event.player instanceof EntityPlayerSP) {
            if (manualInputCheck == null) {
                manualInputCheck = new MovementInputFromOptions(Minecraft.getMinecraft().gameSettings);
            }
            EntityPlayerSP player = (EntityPlayerSP) event.player;
            Block below = player.worldObj.getBlock(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY) - 2, MathHelper.floor_double(player.posZ));
            if (below == this) {
                manualInputCheck.updatePlayerMoveState();
                if (manualInputCheck.moveForward != 0 || manualInputCheck.moveStrafe != 0) {
                    player.motionX *= 1.40D;
                    player.motionZ *= 1.40D;
                }
            }
        }
    }
}
