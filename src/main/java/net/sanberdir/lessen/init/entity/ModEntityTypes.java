package net.sanberdir.lessen.init.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.entity.custom.MetalSpiderEntity;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, Lessen.MOD_ID);

    public static final RegistryObject<EntityType<MetalSpiderEntity>> METAL_SPIDER =
            ENTITY_TYPES.register("metal_spider",()-> EntityType.Builder.create(MetalSpiderEntity::new,
                            EntityClassification.MONSTER).size(1f,1f)
                    .build(new ResourceLocation(Lessen.MOD_ID, "metal_spider").toString()));



    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
