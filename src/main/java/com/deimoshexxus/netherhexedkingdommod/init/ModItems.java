package com.deimoshexxus.netherhexedkingdommod.init;

import java.util.ArrayList;
import java.util.List;

import com.deimoshexxus.netherhexedkingdommod.items.armor.ArmorBase;
import com.deimoshexxus.netherhexedkingdommod.items.ItemBase;
import com.deimoshexxus.netherhexedkingdommod.items.NetherAlloyShield;
import com.deimoshexxus.netherhexedkingdommod.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{

	public static final List<Item> ITEMS = new ArrayList<Item>();
	//Tool Materials
	
	//Armour Materials
	public static final ArmorMaterial ARMOUR_MATERIAL_NETHER_ALLOY = EnumHelper.addArmorMaterial("armour_material_nether_alloy", Reference.MOD_ID + ":nether_alloy", 8, new int [] {3, 6, 6, 3,}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.5F);
	//public static final ArmorMaterial ARMOUR_MATERIAL_CRYPTOS_INFERNIUM = EnumHelper.addArmorMaterial("armour_material_cryptos_infernium", Reference.MOD_ID + ":cryptos_infernium", 16, new int [] {5, 6, 6, 4,}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.5F);

	//Items
	
	//Ingot

	//Shields
	public static final ItemShield NETHER_ALLOY_SHIELD = new NetherAlloyShield(236, "nether_alloy_shield");
	
	//Armour	
	public static final Item NETHER_HELMET = new ArmorBase("nether_helmet", ARMOUR_MATERIAL_NETHER_ALLOY, 1, EntityEquipmentSlot.HEAD);
	public static final Item NETHER_CHESTPLATE = new ArmorBase("nether_chestplate", ARMOUR_MATERIAL_NETHER_ALLOY, 1, EntityEquipmentSlot.CHEST);
	public static final Item NETHER_LEGGINGS = new ArmorBase("nether_leggings", ARMOUR_MATERIAL_NETHER_ALLOY, 2, EntityEquipmentSlot.LEGS);
	public static final Item NETHER_BOOTS = new ArmorBase("nether_boots", ARMOUR_MATERIAL_NETHER_ALLOY, 1, EntityEquipmentSlot.FEET);
	//Food

	
}
