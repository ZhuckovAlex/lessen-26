package net.sanberdir.lessen.world.surface;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.sanberdir.lessen.init.blocks.InitBlocks;

import java.util.Random;

public class ConcreteGraySurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState DIRT = InitBlocks.PURPLE_DIRT.get().getDefaultState();
    public static final BlockState GRASS_BLOCK = InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState();

    public static final SurfaceBuilderConfig GRAY_CONCRETE_BLOCK_CONFIG = new SurfaceBuilderConfig(GRASS_BLOCK, DIRT, DIRT);

    public ConcreteGraySurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
        super(codec);
    }
    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                             BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (random.nextInt(2) == 0){
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, GRAY_CONCRETE_BLOCK_CONFIG);
        }
        else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, GRAY_CONCRETE_BLOCK_CONFIG);
        }
    }
}
