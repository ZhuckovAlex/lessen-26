package net.sanberdir.lessen.init.blocks.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;
import net.sanberdir.lessen.init.blocks.InitBlocks;
import net.sanberdir.lessen.init.items.InitItems;


public class PurpleGrass extends CropsBlock{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 13.0D, 12.0D, 13.0D)};
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }
    public PurpleGrass(Properties builder) {
        super(builder);
    }

    @Override
    public int getMaxAge() {
        return 0;
    }
    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(InitItems.PURPLE_GRASS.get());
    }
    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.get(PurpleGrass.AGE.getName());
    }
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.matchesBlock(InitBlocks.PURPLE_GRASS_BLOCK.get())
                ||state.matchesBlock(InitBlocks.PURPLE_DIRT.get());
    }

}