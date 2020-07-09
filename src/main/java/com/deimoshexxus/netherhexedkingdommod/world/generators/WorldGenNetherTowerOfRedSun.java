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

public class WorldGenNetherTowerOfRedSun implements IWorldGenerator
{
	private static final ResourceLocation NETHER_TOWER_OF_RED_SUN_TOP = new ResourceLocation("netherhexedkingdommod:nether_tower_of_red_sun_top");
	private static final ResourceLocation NETHER_TOWER_OF_RED_SUN_BOTTOM = new ResourceLocation("netherhexedkingdommod:nether_tower_of_red_sun_bottom");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) 
	{
        if(world.provider.getDimension() == -1)
        {
        	int chance = ConfigHandler.NETHER_TOWER_OF_RED_SUN_CHANCE;
        	int randomNum = (int)(Math.random() * 1001);
        	if (randomNum <= chance)
        	//int spawn = random.nextInt(chance);
        	//if (spawn == 9)
        	{
    			final TemplateManager templatemanager = world.getSaveHandler().getStructureTemplateManager();
    			Template template = templatemanager.getTemplate(world.getMinecraftServer(), NETHER_TOWER_OF_RED_SUN_BOTTOM);
    			Template template1 = templatemanager.getTemplate(world.getMinecraftServer(), NETHER_TOWER_OF_RED_SUN_TOP);
    			final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIntegrity(1.0F).setRandom(random);
    			final BlockPos basePos = new BlockPos(chunkX * 16 + 8, 32 + random.nextInt(2), chunkZ * 16 + 8);
    			final BlockPos basePos1 = basePos.up(+32);
    			if (world.getBlockState(basePos.down()).getBlock() == Blocks.NETHERRACK && (world.getBlockState(basePos.east(+16)).getBlock() == Blocks.NETHERRACK))
    			{
    				if (world.getBlockState(basePos.up(+16)).getBlock() == Blocks.AIR && (world.getBlockState(basePos.up(+32)).getBlock() == Blocks.AIR))
        			{
    					if (world.getBlockState(basePos.up(+64)).getBlock() == Blocks.AIR)
		    			{		
		    				template.addBlocksToWorld(world, basePos, settings);
		    				template1.addBlocksToWorld(world, basePos1, settings);
		    			}
        			}
    			}
            }
        }
	}
}
