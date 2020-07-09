package com.deimoshexxus.netherhexedkingdommod.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import com.deimoshexxus.netherhexedkingdommod.Main;
import com.deimoshexxus.netherhexedkingdommod.init.ModBlocks;
import com.deimoshexxus.netherhexedkingdommod.init.ModItems;

public class StairBase extends BlockStairs
{
	public StairBase (String name, IBlockState modelState, Material material)
	{
		super(modelState);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
