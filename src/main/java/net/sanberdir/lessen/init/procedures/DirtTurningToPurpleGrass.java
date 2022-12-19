package net.sanberdir.lessen.init.procedures;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.blocks.InitBlocks;

import java.util.Map;


public class DirtTurningToPurpleGrass {
    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                Lessen.LOGGER.warn("Failed to load dependency world for procedure Kpkpl!");
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                Lessen.LOGGER.warn("Failed to load dependency x for procedure Kpkpl!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                Lessen.LOGGER.warn("Failed to load dependency y for procedure Kpkpl!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                Lessen.LOGGER.warn("Failed to load dependency z for procedure Kpkpl!");
            return;
        }
        IWorld world = (IWorld) dependencies.get("world");
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        boolean found = false;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        double enchant_levels = 0;
        ItemStack emeralds = ItemStack.EMPTY;
        ItemStack tool = ItemStack.EMPTY;
        if (Math.random() >= 0.3) {
            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x + 1, y, z), InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x - 1, y, z),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x, y, z + 1),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x, y, z - 1),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if((!((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR))&&
                        ((world.getBlockState(new BlockPos(x, y + 1, z)).isSolid())))
                    world.setBlockState(new BlockPos(x, y, z),InitBlocks.PURPLE_DIRT.get().getDefaultState(), 3);
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x - 1, y + 2, z))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x - 1, y + 1, z),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x + 1, y + 2, z))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x + 1, y + 1, z),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x + 1, y - 1, z),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }
            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x - 1, y - 1, z),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x, y + 2, z + 1))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x, y + 1, z + 1),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x, y + 2, z - 1))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x, y + 1, z - 1),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }

            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x, y - 1, z - 1),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }
            if (Math.random() >= 0.5) {
                if ((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.AIR) {
                    if ((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == InitBlocks.PURPLE_DIRT.get()) {
                        world.setBlockState(new BlockPos(x, y - 1, z + 1),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
                    }
                }
            }
        } else {
            world.setBlockState(new BlockPos(x, y, z),InitBlocks.PURPLE_GRASS_BLOCK.get().getDefaultState(), 3);
        }
    }
}
