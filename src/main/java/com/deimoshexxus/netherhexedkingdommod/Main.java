package com.deimoshexxus.netherhexedkingdommod;

import com.deimoshexxus.netherhexedkingdommod.proxy.CommonProxy;
import com.deimoshexxus.netherhexedkingdommod.util.Reference;

import java.io.File;

import com.deimoshexxus.netherhexedkingdommod.init.ModEntities;
import com.deimoshexxus.netherhexedkingdommod.util.handlers.ConfigHandler;
import com.deimoshexxus.netherhexedkingdommod.util.handlers.RegistryHandler;
import com.deimoshexxus.netherhexedkingdommod.util.handlers.RenderHandler;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenMagmaCubeNest;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherDamnedPrison;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherFallenWalls;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherGreedMines;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherIronClad;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherLostOutpost;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherWrathTower;
import com.deimoshexxus.netherhexedkingdommod.world.generators.WorldGenNetherWretchedLookout;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
{
	public static File config; 
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{
		RegistryHandler.preInitRegistries();
		ConfigHandler.registerConfig(event);
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event) 
	{
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) 
	{
		
	}

}
