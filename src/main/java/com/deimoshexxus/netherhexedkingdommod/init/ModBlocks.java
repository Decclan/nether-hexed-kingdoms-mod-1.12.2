package com.deimoshexxus.netherhexedkingdommod.init;

import java.util.ArrayList;
import java.util.List;

import com.deimoshexxus.netherhexedkingdommod.blocks.EternalLight;

import com.deimoshexxus.netherhexedkingdommod.blocks.StairBase;
import com.deimoshexxus.netherhexedkingdommod.blocks.NetherDeadstone;
import com.deimoshexxus.netherhexedkingdommod.blocks.HumanSkeletonBottom;
import com.deimoshexxus.netherhexedkingdommod.blocks.HumanSkeletonTop;
import com.deimoshexxus.netherhexedkingdommod.blocks.TileStoneSword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ETERNAL_LIGHT = new EternalLight("eternal_light", Material.GLASS);
	public static final Block NETHER_DEADSTONE = new NetherDeadstone("nether_deadstone", Material.ROCK);

	//**Stairs**
	
	public static final Block RED_NETHER_BRICK_STAIRS = new StairBase("red_nether_brick_stairs", Blocks.RED_NETHER_BRICK.getDefaultState(), Material.ROCK);	
	
	//**Half Slabs**
	
	//**Structure Decorations(Custom Models)**
		
	//**Unique Blocks**

	public static final Block HUMAN_SKELETON_TOP = new HumanSkeletonTop("human_skeleton_top", Material.CLAY);
	public static final Block HUMAN_SKELETON_BOTTOM = new HumanSkeletonBottom("human_skeleton_bottom", Material.CLAY);
	
	//**Tool Tiles**
	
	public static final Block TILE_STONE_SWORD = new TileStoneSword("tile_stone_sword", Material.CLAY);
}
