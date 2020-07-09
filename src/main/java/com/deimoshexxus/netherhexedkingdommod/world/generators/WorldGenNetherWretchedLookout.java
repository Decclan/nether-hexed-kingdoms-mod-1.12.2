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

public class WorldGenNetherWretchedLookout implements IWorldGenerator
{
	private static final ResourceLocation NETHER_WRETCHED_LOOKOUT = new ResourceLocation("netherhexedkingdommod:nether_wretched_lookout");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
        if(world.provider.getDimension() == -1)
        {
        	int chance = ConfigHandler.NETHER_WRETCHED_LOOKOUT_CHANCE;
        	int spawn = random.nextInt(chance);
        	if (spawn == 6)
        	//int i = 1 + random.nextInt(8);
        	//if (i == 5)
        	{
    			final TemplateManager templatemanager = world.getSaveHandler().getStructureTemplateManager();
    			Template template = templatemanager.getTemplate(world.getMinecraftServer(), NETHER_WRETCHED_LOOKOUT);
    			final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIntegrity(1.0F).setRandom(random);
    			final BlockPos basePos = new BlockPos(chunkX * 16 + 8, 64 + random.nextInt(40), chunkZ * 16 + 8);
    			if (world.getBlockState(basePos.up(+24)).getBlock() != Blocks.NETHER_BRICK)
    			{
	    			if (world.getBlockState(basePos.down()).getBlock() == Blocks.NETHERRACK)
	    			//if (world.getBlockState(basePos.up()).getBlock() == Blocks.AIR)
	    			{		
	    				template.addBlocksToWorld(world, basePos, settings);
	    			}
    			}
            }
        }
	}
}
