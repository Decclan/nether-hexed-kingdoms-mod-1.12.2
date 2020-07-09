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

public class WorldGenNetherLostOutpost implements IWorldGenerator
{
	private static final ResourceLocation NETHER_LOST_OUTPOST = new ResourceLocation("netherhexedkingdommod:nether_lost_outpost");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
        if(world.provider.getDimension() == -1)
        {
        	int chance = ConfigHandler.NETHER_LOST_OUTPOST_CHANCE;
        	int spawn = random.nextInt(chance);
        	if (spawn == 3)
        	//int i = 1 + random.nextInt(32);
        	//if (i == 8)
        	{
    			final TemplateManager templatemanager = world.getSaveHandler().getStructureTemplateManager();
    			Template template = templatemanager.getTemplate(world.getMinecraftServer(), NETHER_LOST_OUTPOST);
    			final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIntegrity(1.0F).setRandom(random);
    			final BlockPos basePos = new BlockPos(chunkX * 16 + 8, 48 + random.nextInt(24), chunkZ * 16 + 8);
    			if (world.getBlockState(basePos.up(+24)).getBlock() != Blocks.NETHER_BRICK)
    			{
	    			if (world.getBlockState(basePos.down()).getBlock() == Blocks.NETHERRACK)
	    			{		
	    				template.addBlocksToWorld(world, basePos, settings);
	    			}
    			}
            }
        }
	}
}
