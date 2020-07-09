package com.deimoshexxus.netherhexedkingdommod.entity.render;

import com.deimoshexxus.netherhexedkingdommod.entity.NetherDamnedGuard;
import com.deimoshexxus.netherhexedkingdommod.entity.model.ModelNetherDamnedGuard;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNetherDamnedGuard extends RenderLiving<NetherDamnedGuard>
{
	//@SideOnly(Side.CLIENT)
	public RenderNetherDamnedGuard(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) 
	{
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	}

	public static final ResourceLocation TEXTURES = new ResourceLocation("netherhexedkingdommod:textures/entity/nether_damned_guard.png");
	
	public RenderNetherDamnedGuard(RenderManager manager) 
	{
		super(manager, new ModelNetherDamnedGuard(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerBipedArmor(this));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(NetherDamnedGuard entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations (NetherDamnedGuard entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
