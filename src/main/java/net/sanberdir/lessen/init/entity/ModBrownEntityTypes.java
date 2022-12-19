package net.sanberdir.lessen.init.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.entity.custom.ModBrownBoatEntity;

public class ModBrownEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, Lessen.MOD_ID);

    public static final RegistryObject<EntityType<ModBrownBoatEntity>> BROWN_BOAT =
            ENTITY_TYPES.register("brown_boat",
                    () -> EntityType.Builder.<ModBrownBoatEntity>create(ModBrownBoatEntity::new,
                                    EntityClassification.MISC).size(0.5f, 0.5f)
                            .build(new ResourceLocation(Lessen.MOD_ID, "brown_boat").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
