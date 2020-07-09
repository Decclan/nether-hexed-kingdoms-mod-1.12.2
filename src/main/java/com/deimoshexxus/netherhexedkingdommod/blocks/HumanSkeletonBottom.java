package com.deimoshexxus.netherhexedkingdommod.blocks;

import java.util.Random;

import com.deimoshexxus.netherhexedkingdommod.init.ModBlocks;
import com.deimoshexxus.netherhexedkingdommod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HumanSkeletonBottom extends Block
{
	public static final AxisAlignedBB HUMAN_SKELETON_BOTTOMAABB = new AxisAlignedBB(0.0625D, 0, 0.0625D, 0.9375D, 0.5D, 0.9375D);
	//Facing(kinda) more to do with facing of bounding boxes
	//public static final AxisAlignedBB HUMAN_SKELETON_BOTTOMAABB_WE = new AxisAlignedBB(0.0625D, 0.0D, 0.4375D, 0.9375D, 1.0D, 0.5625D);
	
	//Facing
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
	    this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)); 
	}
	
	public HumanSkeletonBottom(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.DECORATIONS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	//Facing
	@Override
	public IBlockState getStateFromMeta(int meta) 
    {
		EnumFacing facing = EnumFacing.getFront(meta);

		if(facing.getAxis()==EnumFacing.Axis.Y) 
		{
			facing=EnumFacing.NORTH;
		}
		return getDefaultState().withProperty(FACING, facing);
    }
	
	//Facing
	@Override
	public int getMetaFromState(IBlockState state) 
    {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
    }
	    
	//Facing
    @Override
	protected BlockStateContainer createBlockState() 
    {
    	return new BlockStateContainer(this, new IProperty[]{FACING});
    }
    
    //Facing
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos,EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
    {
	  return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
	
	private boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) 
	{
		return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) 
	{
		if(!this.canBlockStay(worldIn, pos))
		{
			worldIn.setBlockToAir(pos);
			InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.HUMAN_SKELETON_BOTTOM));
		}
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	//Facing(kinda) more to do with facing of bounding boxes
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		switch(((EnumFacing)state.getValue(FACING)))
        {
            case SOUTH:
            default:
                return HUMAN_SKELETON_BOTTOMAABB;
            case NORTH:
                return HUMAN_SKELETON_BOTTOMAABB;
            case EAST:
                return HUMAN_SKELETON_BOTTOMAABB;
            case WEST:
                return HUMAN_SKELETON_BOTTOMAABB;
        }
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.BONE;
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		int max = 5;
		int min = 1;
		return rand.nextInt(max) + min;
	}
}
	

