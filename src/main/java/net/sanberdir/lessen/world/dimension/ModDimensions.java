package net.sanberdir.lessen.world.dimension;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.sanberdir.lessen.Lessen;

public class ModDimensions {
    public static final RegistryKey<World> CRAZY = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(Lessen.MOD_ID, "crazy"));
    }