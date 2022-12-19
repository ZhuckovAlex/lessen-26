package net.sanberdir.lessen.events;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.entity.ModEntityTypes;
import net.sanberdir.lessen.init.entity.custom.MetalSpiderEntity;
import net.sanberdir.lessen.init.items.custom.ModSpawnEggItem;

@Mod.EventBusSubscriber(modid = Lessen.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.METAL_SPIDER.get(), MetalSpiderEntity.MutableAttributeMetalSpider().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

}