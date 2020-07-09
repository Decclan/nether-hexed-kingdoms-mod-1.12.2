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

public class WorldGenNetherGreedMines implements IWorldGenerator
{
	private static final ResourceLocation NETHER_GREED_MINES = new ResourceLocation("netherhexedkingdommod:nether_greed_mines");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
        if(world.provider.getDimension() == -1)
        {
        	int chance = ConfigHandler.NETHER_GREED_MINES_CHANCE;
        	int spawn = random.nextInt(chance);
        	if (spawn == 2)
        	//int i = 1 + random.nextInt(48);
        	//if (i == 6)
        	{
    			final TemplateManager templatemanager = world.getSaveHandler().getStructureTemplateManager();
    			Template template = templatemanager.getTemplate(world.getMinecraftServer(), NETHER_GREED_MINES);
    			final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIntegrity(1.0F).setRandom(random);
    			final BlockPos basePos = new BlockPos(chunkX * 16 + 8, 31 + random.nextInt(2), chunkZ * 16 + 8);
    			if (world.getBlockState(basePos.down()).getBlock() == Blocks.NETHERRACK)
    			{		
    				template.addBlocksToWorld(world, basePos, settings);
    			}
            }
        }
	}
}
