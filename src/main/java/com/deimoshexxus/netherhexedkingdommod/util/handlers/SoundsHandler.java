package com.deimoshexxus.netherhexedkingdommod.util.handlers;

import com.deimoshexxus.netherhexedkingdommod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler 
{
	public static SoundEvent NETHERGUARD_AMBIENT;
	public static SoundEvent NETHERGUARD_HURT;
	public static SoundEvent NETHERGUARD_DEATH;
	
	public static void registerSounds()
	{
		NETHERGUARD_AMBIENT = registerSound("entity.netherguardsounds.nether_guard_ambient");
		NETHERGUARD_HURT = registerSound("entity.netherguardsounds.nether_guard_hit");
		NETHERGUARD_DEATH = registerSound("entity.netherguardsounds.nether_guard_death");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}