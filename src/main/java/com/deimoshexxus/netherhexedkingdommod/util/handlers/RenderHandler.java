package com.deimoshexxus.netherhexedkingdommod.util.handlers;

import com.deimoshexxus.netherhexedkingdommod.entity.NetherDamnedGuard;
import com.deimoshexxus.netherhexedkingdommod.entity.render.RenderNetherDamnedGuard;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(NetherDamnedGuard.class, new IRenderFactory<NetherDamnedGuard>()
		{

			@Override
			public Render<? super NetherDamnedGuard> createRenderFor(RenderManager manager) 
			{
				return new RenderNetherDamnedGuard(manager);
			}
			
		});
	}
	

}
