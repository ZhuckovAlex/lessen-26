package net.sanberdir.lessen.init.procedures;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.blocks.InitBlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ConvertingFarmlandHoe {
    @Mod.EventBusSubscriber
    private static class GlobalTrigger {
        @SubscribeEvent
        public static void onUseHoe(UseHoeEvent event) {
            PlayerEntity entity = event.getPlayer();
            double i = event.getContext().getPos().getX();
            double j = event.getContext().getPos().getY();
            double k = event.getContext().getPos().getZ();
            World world = entity.world;
            BlockState state = world.getBlockState(event.getContext().getPos());
            Map<String, Object> dependencies = new HashMap<>();
            dependencies.put("x", i);
            dependencies.put("y", j);
            dependencies.put("z", k);
            dependencies.put("world", world);
            dependencies.put("entity", entity);
            dependencies.put("blockstate", state);
            dependencies.put("event", event);
            executeProcedure(dependencies);
        }
    }

    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                Lessen.LOGGER.warn("Failed to load dependency world for procedure Hoemod!");
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                Lessen.LOGGER.warn("Failed to load dependency x for procedure Hoemod!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                Lessen.LOGGER.warn("Failed to load dependency y for procedure Hoemod!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                Lessen.LOGGER.warn("Failed to load dependency z for procedure Hoemod!");
            return;
        }
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity"))
                Lessen.LOGGER.warn("Failed to load dependency entity for procedure Hoemod!");
            return;
        }
        IWorld world = (IWorld) dependencies.get("world");
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        Entity entity = (Entity) dependencies.get("entity");
        if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocks.PURPLE_DIRT.get()
                && !world.getBlockState(new BlockPos(x, y + 1, z)).isSolid()
                || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == InitBlocks.PURPLE_GRASS_BLOCK.get()
                && !world.getBlockState(new BlockPos(x, y + 1, z)).isSolid()
        ) {
            {
                BlockPos _bp = new BlockPos(x, y, z);
                BlockState _bs = InitBlocks.FARMLAND_PURPLE.get().getDefaultState();
                world.setBlockState(_bp, _bs, 3);
            }
            if (world instanceof World && !world.isRemote()) {
                ((World) world).playSound(null, new BlockPos(x, y, z),
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.hoe.till")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1);
            } else {
                ((World) world).playSound(x, y, z,
                        (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.hoe.till")),
                        SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
            }
            if (new Object() {
                public boolean checkGamemode(Entity _ent) {
                    if (_ent instanceof ServerPlayerEntity) {
                        return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
                    } else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
                        NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
                                .getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
                        return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
                    }
                    return false;
                }
            }.checkGamemode(entity)) {
                {
                    ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
                    if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
                        _ist.shrink(1);
                        _ist.setDamage(0);
                    }
                }
            }

        }
    }
}
