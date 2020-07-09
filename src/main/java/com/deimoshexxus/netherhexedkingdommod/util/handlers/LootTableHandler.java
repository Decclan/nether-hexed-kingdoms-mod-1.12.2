package com.deimoshexxus.netherhexedkingdommod.util.handlers;

import com.deimoshexxus.netherhexedkingdommod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler 
{
	public static final ResourceLocation NETHER_GUARD = LootTableList.register(new ResourceLocation(Reference.MOD_ID, ":loot_tables/entity/nether_guard.json"));
}