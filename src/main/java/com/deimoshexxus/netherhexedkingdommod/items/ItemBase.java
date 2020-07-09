package com.deimoshexxus.netherhexedkingdommod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.deimoshexxus.netherhexedkingdommod.Main;
import com.deimoshexxus.netherhexedkingdommod.init.ModItems;

public class ItemBase extends Item
{

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		
		ModItems.ITEMS.add(this);
	}
}
