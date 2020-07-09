package com.deimoshexxus.netherhexedkingdommod.blocks;

import com.deimoshexxus.netherhexedkingdommod.Main;
import com.deimoshexxus.netherhexedkingdommod.init.ModBlocks;
import com.deimoshexxus.netherhexedkingdommod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block
{
	public BlockBase (String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}