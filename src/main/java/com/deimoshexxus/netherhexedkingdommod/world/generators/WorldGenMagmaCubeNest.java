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
import scala.reflect.internal.util.OffsetPosition;

public class WorldGenMagmaCubeNest implements IWorldGenerator
{
	private static final ResourceLocation MAGMA_CUBE_NEST = new ResourceLocation("netherhexedkingdommod:magma_cube_nest");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
        if(world.provider.getDimension() == -1)
        {
        	int chance = ConfigHandler.MAGMA_CUBE_NEST_CHANCE;
        	int spawn = random.nextInt(chance);
        	if (spawn == 1)
        	//int i = 1 + random.nextInt(16);
        	//if (i == 7)
        	{
    			final TemplateManager templatemanager = world.getSaveHandler().getStructureTemplateManager();
    			Template template = templatemanager.getTemplate(world.getMinecraftServer(), MAGMA_CUBE_NEST);
    			final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIntegrity(1.0F).setRandom(random);
    			final BlockPos basePos = new BlockPos(chunkX * 16 + 8, 32 + random.nextInt(8), chunkZ * 16 + 8);

    			if (world.getBlockState(basePos.down()).getBlock() == Blocks.MAGMA)
    			//if (world.getBlockState(basePos.up()).getBlock() == Blocks.AIR)
    			{		
    				template.addBlocksToWorld(world, basePos, settings);
    			}
            }
        }
	}
}
