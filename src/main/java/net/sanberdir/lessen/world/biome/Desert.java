package net.sanberdir.lessen.world.biome;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;

import java.util.function.Supplier;

public class Desert {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            Lessen.MOD_ID);

    // Add more biomes here!
    static {
        createBiome("desert", BiomeMaker::makeVoidBiome);
    }

    // (and also here!)
    public static RegistryKey<Biome> DESERT = registerBiome("desert");

    public static RegistryKey<Biome> registerBiome(String biomeName) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Lessen.MOD_ID, biomeName));
    }

    public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
        return BIOMES.register(biomeName, biome);
    }


    public static void registerBiomes() {

    }
}
