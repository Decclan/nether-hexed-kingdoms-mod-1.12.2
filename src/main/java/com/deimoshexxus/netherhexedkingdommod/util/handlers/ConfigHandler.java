package com.deimoshexxus.netherhexedkingdommod.util.handlers;

import java.io.File;

import com.deimoshexxus.netherhexedkingdommod.Main;
import com.deimoshexxus.netherhexedkingdommod.util.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler 
{
	public static Configuration config;
	
	//Entities
	public static int ENTITY_NETHER_DAMNED_GUARD = 120;
	
	//Structures
	public static boolean MAGMA_CUBE_NEST = false;
	public static boolean NETHER_DAMNED_PRISON = true;
	public static boolean NETHER_FALLEN_WALLS = true;
	public static boolean NETHER_GREED_MINES = true;
	public static boolean NETHER_LOST_OUTPOST = true;
	public static boolean NETHER_WRATH_TOWER = true;
	public static boolean NETHER_WRETCHED_LOOKOUT = true;
	public static boolean NETHER_IRON_CLAD = true;
	public static boolean NETHER_TOWER_OF_RED_SUN = true; 
	
	public static int MAGMA_CUBE_NEST_CHANCE = 30;
	public static int NETHER_DAMNED_PRISON_CHANCE = 35;
	//public static int NETHER_FALLEN_WALLS_CHANCE = 10;
	public static int NETHER_GREED_MINES_CHANCE = 140;
	public static int NETHER_LOST_OUTPOST_CHANCE = 35;
	public static int NETHER_WRATH_TOWER_CHANCE = 25;
	public static int NETHER_WRETCHED_LOOKOUT_CHANCE = 30;
	public static int NETHER_IRON_CLAD_CHANCE = 20;
	public static int NETHER_TOWER_OF_RED_SUN_CHANCE = 20;
	//Miscellaneous
	//public static boolean
	
	public static void init(File file)
	{
		config = new Configuration(file);
		String category;
		
		category = "Structure Spawn's";
		config.addCustomCategoryComment(category, "Enables/disables spawn for each structure, true or false.");
		MAGMA_CUBE_NEST = config.getBoolean("Magma Cube Spawn", category, false, "do you want the Magma Cube structure to spawn?");
		NETHER_DAMNED_PRISON = config.getBoolean("Nether Damned Prison Spawn", category, true, "do you want the Damned Prison structure to spawn?");
		//NETHER_FALLEN_WALLS = config.getBoolean("Nether Fallen Walls Spawn", category, true, "do you want the Fallen Walls structure to spawn?");
		NETHER_GREED_MINES = config.getBoolean("Nether Greed Mines Spawn", category, true, "do you want the Greed Mines structure to spawn?");
		NETHER_LOST_OUTPOST = config.getBoolean("Nether Lost Outpost Spawn", category, true, "do you want the Lost Outpost structure to spawn?");
		NETHER_WRATH_TOWER = config.getBoolean("Nether Wrath Tower Spawn", category, true, "do you want the Wrath Tower structure to spawn?");
		NETHER_WRETCHED_LOOKOUT = config.getBoolean("Nether Wretched Lookout Spawn", category, true, "do you want the Wretched Lookout structure to spawn?");
		NETHER_IRON_CLAD = config.getBoolean("Nether Iron Clad Spawn", category, true, "do you want the Iron Clad structure to spawn?");
		NETHER_TOWER_OF_RED_SUN = config.getBoolean("Nether Tower of Red Sun Spawn", category, true, "do you want the Tower of Red Sun structure to spawn?");
		
		category = "Structure Spawn Chance";
		config.addCustomCategoryComment(category, "Sets spawn chance for each structure.");
		MAGMA_CUBE_NEST_CHANCE = config.getInt("Magma Cube Spawn Chance", category, 30, 10, 1000, "chance of 1 in number supplied");
		NETHER_DAMNED_PRISON_CHANCE = config.getInt("Damned Prison Spawn Chance", category, 50, 10, 1000, "chance of 1 in number supplied");
		//NETHER_FALLEN_WALLS_CHANCE = config.getInt("Magma Cube Spawn Chance", category, 10, 10, 1000, "chance of 1 in number supplied");
		NETHER_GREED_MINES_CHANCE = config.getInt("Greed Mines Spawn Chance", category, 140, 10, 1000, "chance of 1 in number supplied");
		NETHER_LOST_OUTPOST_CHANCE = config.getInt("Lost Outpost Spawn Chance", category, 35, 10, 1000, "chance of 1 in number supplied");
		NETHER_WRATH_TOWER_CHANCE = config.getInt("Wrath Tower Spawn Chance", category, 25, 10, 1000, "chance of 1 in number supplied");
		NETHER_WRETCHED_LOOKOUT_CHANCE = config.getInt("Wretched Lookout Spawn Chance", category, 30, 10, 1000, "chance of 1 in number supplied");
		NETHER_IRON_CLAD_CHANCE = config.getInt("Iron Clad Spawn Chance", category, 20, 0, 1000, "chance of 1 in 1000");
		NETHER_TOWER_OF_RED_SUN_CHANCE = config.getInt("Tower of Red Sun Spawn Chance", category, 20, 0, 1000, "chance of 1 in 1000");
		
		category = "Entity ID's";
		config.addCustomCategoryComment(category, "Set ID's for each entity.");
		ENTITY_NETHER_DAMNED_GUARD = config.getInt("Nether Guard", category, 120, 0, 500, "Category ID for Nether Guard entity.");
		
		category = "Miscellaneous";
		config.addCustomCategoryComment(category, "Placeholder.");
		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MOD_ID + ".cfg"));
	}
}
