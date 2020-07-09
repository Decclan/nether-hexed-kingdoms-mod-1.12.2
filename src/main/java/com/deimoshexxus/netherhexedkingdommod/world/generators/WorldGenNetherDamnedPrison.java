package com.deimoshexxus.netherhexedkingdommod.world.generators;

import java.util.Random;

import com.deimoshexxus.netherhexedkingdommod.util.handlers.ConfigHandler;

import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;
//import net.minecraft.world.gen.feature.WorldGenFossils;
//import net.minecraft.world.gen.structure.MapGenMineshaft;

public class WorldGenNetherDamnedPrison implements IWorldGenerator
{
	private static final ResourceLocation NETHER_DAMNED_PRISON = new ResourceLocation("netherhexedkingdommod:nether_damned_prison");
	private Rotation rotation;

	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
        if(world.provider.getDimension() == -1)
        {
        	int chance = ConfigHandler.NETHER_DAMNED_PRISON_CHANCE;
        	int spawn = random.nextInt(chance);
        	if (spawn == 4)
        	//int i = 1 + random.nextInt(32);
        	//if (i == 4)
        	{
    			final TemplateManager templatemanager = world.getSaveHandler().getStructureTemplateManager();
    			Template template = templatemanager.getTemplate(world.getMinecraftServer(), NETHER_DAMNED_PRISON);
    			final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIntegrity(1.0F).setRandom(random);
    			//can't rotate due to skeleton blocks changing direction
    			final BlockPos basePos = new BlockPos(chunkX * 16 + 8, 31 + random.nextInt(2), chunkZ * 16 + 8);
    			if (world.getBlockState(basePos.up(+24)).getBlock() != Blocks.NETHER_BRICK)
    			{
    				if (world.getBlockState(basePos.down()).getBlock() != Blocks.NETHER_BRICK)
    				{
	    				if (world.getBlockState(basePos.down()).getBlock() == Blocks.NETHERRACK)
	    				{
	    					if (world.getBlockState(basePos.up(+24)).getBlock() == Blocks.AIR)
	    					{		
	    	    				template.addBlocksToWorld(world, basePos, settings);
	    	    			}
	    				}
    				}
    			}
    			
    			
    			
            }
        }
	}
}
