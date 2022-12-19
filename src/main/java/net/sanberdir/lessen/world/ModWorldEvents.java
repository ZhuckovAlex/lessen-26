package net.sanberdir.lessen.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.world.gen.ModFlowerGeneration;
import net.sanberdir.lessen.world.gen.ModOreGeneration;

@Mod.EventBusSubscriber(modid = Lessen.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        ModOreGeneration.generateOres(event);
        ModFlowerGeneration.generateFlower(event);
    }
}