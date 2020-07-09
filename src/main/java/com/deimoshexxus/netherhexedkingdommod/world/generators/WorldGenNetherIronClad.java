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

public class WorldGenNetherIronClad implements IWorldGenerator
{
	private static final ResourceLocation NETHER_IRON_CLAD = new ResourceLocation("netherhexedkingdommod:nether_iron_clad");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
        if(world.provider.getDimension() == -1)
        {
        	int chance = ConfigHandler.NETHER_IRON_CLAD_CHANCE;
        	int randomNum = (int)(Math.random() * 1001);
        	if (randomNum <= chance)
        	//int spawn = random.nextInt(chance);
        	//if (spawn == 9)
        	{
    			final TemplateManager templatemanager = world.getSaveHandler().getStructureTemplateManager();
    			Template template = templatemanager.getTemplate(world.getMinecraftServer(), NETHER_IRON_CLAD);
    			final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIntegrity(1.0F).setRandom(random);
    			final BlockPos basePos = new BlockPos(chunkX * 16 + 8, 29, chunkZ * 16 + 8);
    			if (world.getBlockState(basePos.up(+16)).getBlock() == Blocks.AIR)
    			{
    				if (world.getBlockState(basePos.east(+24)).getBlock() == Blocks.LAVA)
        			{
		    			if (world.getBlockState(basePos.down(-2)).getBlock() == Blocks.LAVA)
		    			{		
		    				template.addBlocksToWorld(world, basePos, settings);
		    			}
        			}
    			}
            }
        }
	}
}
