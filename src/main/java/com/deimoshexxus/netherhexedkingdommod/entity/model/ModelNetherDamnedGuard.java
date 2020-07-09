package com.deimoshexxus.netherhexedkingdommod.entity.model;

import com.deimoshexxus.netherhexedkingdommod.entity.NetherDamnedGuard;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelNetherDamnedGuard extends ModelBiped
{
    public ModelRenderer right_arm;
    public ModelRenderer right_leg;
    public ModelRenderer head;
    public ModelRenderer torso;
    public ModelRenderer left_arm;
    public ModelRenderer left_leg;
    public ModelRenderer over_head_hood;

    public ModelNetherDamnedGuard()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.right_arm = new ModelRenderer(this, 40, 16);
        this.right_arm.setRotationPoint(-6.0F, 2.0F, 0.0F);
        this.right_arm.addBox(-1.0F, -2.0F, -1.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(right_arm, 0.0F, 0.0F, 0.10000736613927509F);
        this.right_leg = new ModelRenderer(this, 0, 16);
        this.right_leg.setRotationPoint(-3.0F, 12.0F, 0.1F);
        this.right_leg.addBox(-1.0F, 0.0F, -1.0F, 3, 12, 3, 0.0F);
        this.left_leg = new ModelRenderer(this, 0, 16);
        this.left_leg.mirror = true;
        this.left_leg.setRotationPoint(2.0F, 12.0F, 0.1F);
        this.left_leg.addBox(-1.0F, 0.0F, -1.0F, 3, 12, 3, 0.0F);
        this.torso = new ModelRenderer(this, 16, 16);
        this.torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.torso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.over_head_hood = new ModelRenderer(this, 32, 0);
        this.over_head_hood.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.over_head_hood.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.left_arm = new ModelRenderer(this, 40, 16);
        this.left_arm.mirror = true;
        this.left_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.left_arm.addBox(-1.0F, -2.0F, -1.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(left_arm, 0.0F, 0.0F, -0.10000736613927509F);
    }

	@Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        this.rightArmPose = ModelBiped.ArmPose.EMPTY;
        this.leftArmPose = ModelBiped.ArmPose.EMPTY;
		ItemStack itemstack = entitylivingbaseIn.getHeldItem(EnumHand.MAIN_HAND);

        if (itemstack.getItem() instanceof ItemBow && ((NetherDamnedGuard)entitylivingbaseIn).isSwingingArms())
        {
            if (entitylivingbaseIn.getPrimaryHand() == EnumHandSide.RIGHT)
            {
                this.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
            }
            else
            {
                this.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
            }
        }
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
    }
	
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
        this.right_leg.render(f5);
        this.left_leg.render(f5);
        this.torso.render(f5);
        this.left_arm.render(f5);
        this.head.render(f5);
        this.over_head_hood.render(f5);
        this.right_arm.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn)
    {
    	
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    	ItemStack itemstack = ((EntityLivingBase)entityIn).getHeldItemMainhand();
    	NetherDamnedGuard NetherDamnedGuard = (NetherDamnedGuard)entityIn;

    	if (NetherDamnedGuard.isSwingingArms() && (itemstack.isEmpty() || (itemstack.getItem() instanceof ItemSword) || (itemstack.getItem() instanceof ItemAxe)))
    	{
            float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
            this.right_arm.rotateAngleZ = 0.0F;
            this.left_arm.rotateAngleZ = 0.0F;
            this.right_arm.rotateAngleY = -(0.1F - f * 0.6F);
            this.left_arm.rotateAngleY = 0.1F - f * 0.6F;
            this.right_arm.rotateAngleX = -((float)Math.PI / 2.0F);
            this.left_arm.rotateAngleX = -((float)Math.PI / 2.0F);
            this.right_arm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.left_arm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.right_arm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.left_arm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.right_arm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            this.left_arm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        	this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;
        	this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        	this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        	this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	}
    	
    	else if (NetherDamnedGuard.isSwingingArms() && itemstack.getItem() instanceof ItemBow)
    	{
            float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
            this.right_arm.rotateAngleZ = 0.0F;
            this.left_arm.rotateAngleZ = 0.0F;
            this.right_arm.rotateAngleY = -(0.1F - f * 0.6F);
            this.left_arm.rotateAngleY = 0.1F - f * 0.6F;
            this.right_arm.rotateAngleX = -((float)Math.PI / 2.0F);
            this.left_arm.rotateAngleX = -((float)Math.PI / 2.0F);
            this.right_arm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.left_arm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.right_arm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.left_arm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.right_arm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            this.left_arm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        	this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        	this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        	
            if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
            {
                this.right_arm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY;
                this.left_arm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY + 0.4F;
                this.right_arm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
                this.left_arm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
            }
            else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
            {
                this.right_arm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY - 0.4F;
                this.left_arm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY;
                this.right_arm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
                this.left_arm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
            }
    	}
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    }
    
    public void postRenderArm(float scale, EnumHandSide side)
    {
        float f = side == EnumHandSide.RIGHT ? 1.0F : -1.0F;
        ModelRenderer modelrenderer = this.getArmForSide(side);
        modelrenderer.rotationPointX += f;
        modelrenderer.postRender(scale);
        modelrenderer.rotationPointX -= f;
    }
}
