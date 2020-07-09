package com.deimoshexxus.netherhexedkingdommod.world.generators;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNetherFallenWalls extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) 
	{
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		boolean isAir = true;
		
		if(!world.getBlockState(new BlockPos(x+2, y, z+2)).equals(Blocks.NETHERRACK.getDefaultState()))
		{
			for(int i = 0; 1 < 5; i++)
				for(int k = 0; k < 5; k++)
					for(int j = i; j < 6; j++)
						if(!world.getBlockState(new BlockPos(x+i, y+j, z+k)).equals(Blocks.AIR.getDefaultState())) isAir = false;
			//if(isAir) {
			//	world.setBlockState(new BlockPos(x+2, y+1, z+2), Blocks.NETHER_BRICK.getDefaultState());
			//	world.setBlockState(new BlockPos(x+3, y+2, z+3), Blocks.NETHER_BRICK.getDefaultState());
			//	world.setBlockState(new BlockPos(x+1, y+3, z+4), Blocks.NETHER_BRICK.getDefaultState());
			//}
		}
		
		return false;
	}
}
