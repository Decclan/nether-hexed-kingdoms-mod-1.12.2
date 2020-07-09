package com.deimoshexxus.netherhexedkingdommod.entity;

import javax.annotation.Nullable;

import com.deimoshexxus.netherhexedkingdommod.init.ModItems;
import com.deimoshexxus.netherhexedkingdommod.util.handlers.LootTableHandler;
import com.deimoshexxus.netherhexedkingdommod.util.handlers.SoundsHandler;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NetherDamnedGuard extends AbstractSkeleton
{
	
    private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(NetherDamnedGuard.class, DataSerializers.BOOLEAN);
    
	public NetherDamnedGuard(World worldIn) 
	{
		super(worldIn);
		this.setSize(0.6f, 1.9f);
		experienceValue = 5;
		this.isImmuneToFire = true;
		setNoAI(!true);
		this.getEquipmentAndArmor();
	}

    public static void registerFixesNetherDamnedGuard(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, NetherDamnedGuard.class);
    }
    
	@Override
	protected void initEntityAI() 
	{
		clearAITasks();
		((PathNavigateGround)this.getNavigator()).setBreakDoors(true);

		this.tasks.addTask(1, new EntityAIAttackRangedBow<NetherDamnedGuard>(this, 1.0D, 3, 14.0F));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(3, new EntityAIBreakDoor(this));
		this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAISwimming(this));
        //this.tasks.addTask(9, new EntityAIFollow(this, 1.0D, 1.0F, 24.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityVillager>(this, EntityVillager.class, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<EntityIronGolem>(this, EntityIronGolem.class, true));
	}
	
	protected void clearAITasks()
	{
	   tasks.taskEntries.clear();
	   targetTasks.taskEntries.clear();
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
	}
	
	
	@Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(SWINGING_ARMS, Boolean.valueOf(true));
    }
	
	@Override
    public float getEyeHeight()
    {
        return 1.8F;
    }

	@Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
    	super.setEquipmentBasedOnDifficulty(difficulty);
    	
        if (this.rand.nextFloat() < (this.world.getDifficulty() == EnumDifficulty.NORMAL ? 1.00F : 0.01F))
        {
            int i = this.rand.nextInt(7);

            if (i <= 1)
            {
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
                this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(ModItems.NETHER_ALLOY_SHIELD));

            }
            
            else if (i == 3)
            {
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
                this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(ModItems.NETHER_ALLOY_SHIELD));
            }
            
            else if (i >= 5)
            {
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
            }
            
            
            
            else
            {
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
                this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(ModItems.NETHER_ALLOY_SHIELD));

            }
        }
        
        int e = this.rand.nextInt(4);
        
        if (e <= 1)
        {
            this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(ModItems.NETHER_HELMET));
        }
       
		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(ModItems.NETHER_CHESTPLATE));
		this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(ModItems.NETHER_LEGGINGS));
		this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(ModItems.NETHER_BOOTS));
    }


    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        IEntityLivingData ientitylivingdata = super.onInitialSpawn(difficulty, livingdata);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.setCombatTask();
        return ientitylivingdata;
    }


	public void init(FMLInitializationEvent event) 
	{
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("hell")),};
		EntityRegistry.addSpawn(NetherDamnedGuard.class, 20, 5, 20, EnumCreatureType.MONSTER, spawnBiomes);
	}

	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() 
	{
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	public SoundEvent getAmbientSound() 
	{
		return SoundsHandler.NETHERGUARD_AMBIENT;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) 
	{
		return SoundsHandler.NETHERGUARD_HURT;
	}
	
	@Override
	public SoundEvent getDeathSound() 
	{
		return SoundsHandler.NETHERGUARD_DEATH;
	}

	protected SoundEvent getStepSound() 
	{
	
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation(
				"entity.wither_skeleton.step"));
	}
	
	//@Override
    protected ResourceLocation getLootTable() 
    {
    	return LootTableHandler.NETHER_GUARD;
    }
	
    @SideOnly(Side.CLIENT)
    public boolean isSwingingArms()
    {
        return (true);
    }

}
