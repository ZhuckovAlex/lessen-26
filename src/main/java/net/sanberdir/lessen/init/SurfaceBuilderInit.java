package net.sanberdir.lessen.init;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.world.surface.ConcreteGraySurfaceBuilder;

public class SurfaceBuilderInit {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Lessen.MOD_ID);

    public static final RegistryObject<ConcreteGraySurfaceBuilder> CONCRETE_GRAY_SURFACE_BUILDERS = SURFACE_BUILDERS.register("concrete_gray",
            () -> new  ConcreteGraySurfaceBuilder(SurfaceBuilderConfig.CODEC));

}
