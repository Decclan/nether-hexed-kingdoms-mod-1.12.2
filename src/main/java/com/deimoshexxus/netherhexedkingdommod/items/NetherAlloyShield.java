package com.deimoshexxus.netherhexedkingdommod.items;

import java.util.Objects;

import javax.annotation.Nullable;

import com.deimoshexxus.netherhexedkingdommod.Main;
import com.deimoshexxus.netherhexedkingdommod.init.ModItems;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NetherAlloyShield extends ItemShield
{
	public NetherAlloyShield(int maxDamage, String name)
	{
		int damage;
		{
			damage = maxDamage;
	        this.maxStackSize = 1;
	        this.setMaxDamage(damage);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(CreativeTabs.COMBAT);
			this.isDamageable();
	        this.isRepairable();
	        this.showDurabilityBar(new ItemStack(this));
			ModItems.ITEMS.add(this);
			this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
	        {
	            @SideOnly(Side.CLIENT)
	            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
	            {
	                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
	            }
	        });
	        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
		}
	}
	
	public String getItemStackDisplayName(ItemStack stack)
    {
        if (stack.getSubCompound("BlockEntityTag") != null)
        {
            return I18n.translateToLocal("item.shield." + ".name");
        }
        else
        {
            return I18n.translateToLocal("item.shield.name");
        }
    }
	
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
	
	public boolean isDamageable()
	{
        return true;
    }
	
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 52000;
    }
	
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public boolean isRepairable()
	{
        return true;
    }
	
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
    	return repair.getItem() == Items.NETHER_WART ? true : super.getIsRepairable(toRepair, repair);
    }
    
    //Item.getItemFromBlock(Blocks.NETHER_BRICK)
    
    
    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(Objects.requireNonNull(getRegistryName()), "inventory"));
    }
}
