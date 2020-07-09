package com.deimoshexxus.netherhexedkingdommod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class EternalLight extends BlockBase
{

	public EternalLight(String name, Material material) 
	{
		super(name, material);
		setSoundType(SoundType.GLASS );
		setHardness(0.6F);
		setResistance(2.0F);
		setHarvestLevel("pickaxe", 1);
		setLightLevel(1.0F);
	}
	
	@Override
    public boolean isBurning(IBlockAccess world, BlockPos pos)
    {
        return true;
    }
}
	