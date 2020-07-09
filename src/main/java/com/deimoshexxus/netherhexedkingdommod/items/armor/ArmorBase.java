package com.deimoshexxus.netherhexedkingdommod.items.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

import com.deimoshexxus.netherhexedkingdommod.Main;
import com.deimoshexxus.netherhexedkingdommod.init.ModItems;

public class ArmorBase extends ItemArmor
{

	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn,
			EntityEquipmentSlot equipmentSlotIn) 
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ModItems.ITEMS.add(this);
	}
}