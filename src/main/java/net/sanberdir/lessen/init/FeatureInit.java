package net.sanberdir.lessen.init;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.world.feature.ExampleTreeFeature;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            Lessen.MOD_ID);

    public static final RegistryObject<ExampleTreeFeature> EXAMPLE_TREE = FEATURES.register("example_tree",
            () -> new ExampleTreeFeature(NoFeatureConfig.CODEC));

}