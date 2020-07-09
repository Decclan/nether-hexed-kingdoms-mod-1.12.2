package com.deimoshexxus.netherhexedkingdommod.util.handlers;

import java.beans.EventHandler;

import com.deimoshexxus.netherhexedkingdommod.Main;
import com.deimoshexxus.netherhexedkingdommod.init.ModBlocks;
import com.deimoshexxus.netherhexedkingdommod.init.ModEntities;
import com.deimoshexxus.netherhexedkingdommod.init.ModItems;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenMagmaCubeNest;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherDamnedPrison;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherGreedMines;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherIronClad;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherLostOutpost;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherTowerOfRedSun;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherWrathTower;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherWretchedLookout;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}



	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onModelRegister(ModelRegistryEvent event)
	{
		RenderHandler.registerEntityRenders();
		for(Item item : ModItems.ITEMS)
		{
			Main.proxy.registerItemRenderer(item, 0, "inventory");
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			Main.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
		}
	}
	
	public static void preInitRegistries()
	{
		if(ConfigHandler.MAGMA_CUBE_NEST)
		{
			GameRegistry.registerWorldGenerator(new WorldGenMagmaCubeNest(), 5);
		}
		if(ConfigHandler.NETHER_DAMNED_PRISON)
		{
			GameRegistry.registerWorldGenerator(new WorldGenNetherDamnedPrison(), 8);
		}
		//if(ConfigHandler.NETHER_FALLEN_WALLS)
		//{
			//GameRegistry.registerWorldGenerator(new WorldGenNetherFallenWalls(), 5);
		//}
		if(ConfigHandler.NETHER_GREED_MINES)
		{
			GameRegistry.registerWorldGenerator(new WorldGenNetherGreedMines(), 8);
		}
		if(ConfigHandler.NETHER_LOST_OUTPOST)
		{
			GameRegistry.registerWorldGenerator(new WorldGenNetherLostOutpost(), 9);
		}
		if(ConfigHandler.NETHER_WRATH_TOWER)
		{
			GameRegistry.registerWorldGenerator(new WorldGenNetherWrathTower(), 5);
		}
		if(ConfigHandler.NETHER_WRETCHED_LOOKOUT)
		{
			GameRegistry.registerWorldGenerator(new WorldGenNetherWretchedLookout(), 7);
		}
		if(ConfigHandler.NETHER_IRON_CLAD)
		{
			GameRegistry.registerWorldGenerator(new WorldGenNetherIronClad(), 5);
		}
		if(ConfigHandler.NETHER_TOWER_OF_RED_SUN)
		{
			GameRegistry.registerWorldGenerator(new WorldGenNetherTowerOfRedSun(), 5);
		}
		System.out.println("Structures Added");
		//EventHandler.registerEvents();
		ModEntities.registerEntities();
		SoundsHandler.registerSounds();
		
	}
	public static void initRegistries()
	{

	}
	
	public static void postInitRegistries()
	{
	
	}	
}
