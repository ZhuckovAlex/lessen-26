package net.sanberdir.lessen.init.blocks.custom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.sanberdir.lessen.world.dimension.CrazyWorld;
import net.sanberdir.lessen.world.dimension.ModDimensions;

public class TPBlock extends Block {
    public TPBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == ModDimensions.CRAZY) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new CrazyWorld(pos, false));
                        }
                    } else {
                        ServerWorld RDim = server.getWorld(ModDimensions.CRAZY);
                        if (RDim != null) {
                            player.changeDimension(RDim, new CrazyWorld(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}