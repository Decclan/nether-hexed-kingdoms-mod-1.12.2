package com.deimoshexxus.netherhexedkingdommod.init;

import com.deimoshexxus.netherhexedkingdommod.Main;
import com.deimoshexxus.netherhexedkingdommod.entity.NetherDamnedGuard;
import com.deimoshexxus.netherhexedkingdommod.util.Reference;
import com.deimoshexxus.netherhexedkingdommod.util.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities 
{
	
	public static void registerEntities()
	{
		registerEntity("nether_damned_guard", NetherDamnedGuard.class, ConfigHandler.ENTITY_NETHER_DAMNED_GUARD, 120, -6750157, -6710887);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int colour1, int colour2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, colour1, colour2);
		System.out.println("Entity Added");
	}
}
