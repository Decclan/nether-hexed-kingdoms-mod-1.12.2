package com.deimoshexxus.netherhexedkingdommod.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class NetherDeadstone extends BlockBase
{

	public NetherDeadstone(String name, Material material) 
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(0.9F);
		setResistance(3.5F);
		setHarvestLevel("pickaxe", 1);
		setLightLevel(0.1F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.FLINT;
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		int max = 1;
		int min = 0;
		return rand.nextInt(max) + min;
	}
}
	