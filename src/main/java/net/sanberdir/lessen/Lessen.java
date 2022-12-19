package net.sanberdir.lessen;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sanberdir.lessen.init.FeatureInit;
import net.sanberdir.lessen.init.SurfaceBuilderInit;
import net.sanberdir.lessen.init.blocks.InitBlocks;
import net.sanberdir.lessen.init.blocks.custom.ModWoodTypes;
import net.sanberdir.lessen.init.entity.ModBrownEntityTypes;
import net.sanberdir.lessen.init.entity.ModEntityTypes;
import net.sanberdir.lessen.init.entity.custom.MetalSpiderEntity;
import net.sanberdir.lessen.init.entity.render.MetalSpiderRender;
import net.sanberdir.lessen.init.entity.renderer.ModBrownBoatRenderer;
import net.sanberdir.lessen.init.entity.tileentity.ModTileEntities;
import net.sanberdir.lessen.init.items.InitItems;
import net.sanberdir.lessen.world.ModWorldEvents;
import net.sanberdir.lessen.world.biome.Desert;
import net.sanberdir.lessen.world.biome.YellowForest;
import net.sanberdir.lessen.world.gen.ModOreGeneration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Lessen.MOD_ID)
public class Lessen
{
    public static final String MOD_ID = "lessen";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Lessen() {

        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitItems.register(eventBus);

        InitBlocks.register(eventBus);

        ModBrownEntityTypes.register(eventBus);

        ModTileEntities.register(eventBus);

        ModEntityTypes.register(eventBus);

        FeatureInit.FEATURES.register(eventBus);

        SurfaceBuilderInit.SURFACE_BUILDERS.register(eventBus);

        YellowForest.BIOMES.register(eventBus);
        YellowForest.registerBiomes();

        Desert.BIOMES.register(eventBus);
        Desert.registerBiomes();

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
                .put(InitBlocks.BROWN_LOG.get(), InitBlocks.STRIPPED_BROWN_LOG.get())
                .put(InitBlocks.BROWN_WOOD.get(), InitBlocks.STRIPPED_BROWN_WOOD.get()).build();
        WoodType.register(ModWoodTypes.BROWN);

        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(InitItems.BROWN_LEAVES.get(), 0.25f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(InitItems.BROWN_SAPLING.get(), 0.25f);
        });
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(InitItems.PURPLE_GRASS.get(), 0.25f);
        });

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(InitBlocks.BLUE_GLASS.get(), RenderType.getTranslucent());

        RenderTypeLookup.setRenderLayer(InitBlocks.BROWN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(InitBlocks.BROWN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(InitBlocks.PURPLE_GRASS.get(), RenderType.getCutout());

        ClientRegistry.bindTileEntityRenderer(ModTileEntities.SIGN_TILE_ENTITIES.get(),
                SignTileEntityRenderer::new);

        Atlases.addWoodType(ModWoodTypes.BROWN);

        RenderingRegistry.registerEntityRenderingHandler(ModBrownEntityTypes.BROWN_BOAT.get(), ModBrownBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.METAL_SPIDER.get(), MetalSpiderRender::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
