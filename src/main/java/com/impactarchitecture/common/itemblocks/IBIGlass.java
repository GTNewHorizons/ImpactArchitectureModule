package com.impactarchitecture.common.itemblocks;

import com.impactarchitecture.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class IBIGlass extends ItemBlock {

  public IBIGlass(Block block) {
    super(block);
  }

  @Override
  public int getMetadata(int meta) {
    return meta;
  }

  @Override
  public boolean getHasSubtypes() {
    return true;
  }

  @Override
  public String getUnlocalizedName(ItemStack stack) {
    return super.getUnlocalizedName() + "." + stack.getItemDamage();
  }

  @SuppressWarnings("unchecked")
  @Override
  public void addInformation(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean aF3_H) {
    aList.add(Utils.impactTag());
  }
}
