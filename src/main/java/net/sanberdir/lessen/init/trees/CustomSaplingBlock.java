package net.sanberdir.lessen.init.trees;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.sanberdir.lessen.world.TreeSpawner;

import java.util.Random;

public class CustomSaplingBlock extends SaplingBlock {

    private final TreeSpawner tree;

    public CustomSaplingBlock(Properties properties, TreeSpawner spawner) {
        super(null, properties);
        this.tree = spawner;
    }

    @Override
    public void placeTree(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.get(STAGE) == 0) {
            world.setBlockState(pos, state.cycleValue(STAGE), 4);
        }
        else {
            tree.spawn(world, world.getChunkProvider().getChunkGenerator(), pos, state, rand);
        }
    }

}