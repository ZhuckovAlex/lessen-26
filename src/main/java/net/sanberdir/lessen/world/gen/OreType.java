package net.sanberdir.lessen.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.util.Lazy;
import net.sanberdir.lessen.init.blocks.InitBlocks;

public enum OreType {

    IRON_ORE(Lazy.of(InitBlocks.IRON_ORE), 8, 8, 120, 60),
    GOLD_ORE(Lazy.of(InitBlocks.GOLDEN_ORE), 7, 20, 120, 60),
    EMERALD_ORE_OVERWORLD(Lazy.of(Blocks.EMERALD_ORE.delegate), 20, 5, 120, 60),
    PRISMARINE_ENDER(Lazy.of(Blocks.PRISMARINE.delegate), 20, 5, 120, 60);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;
    private final int veinsPerChunk;


    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.veinsPerChunk = veinsPerChunk;
    }
    public int getVeinsPerChunk() {
        return veinsPerChunk;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if(block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}
