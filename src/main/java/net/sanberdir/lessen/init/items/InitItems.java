package net.sanberdir.lessen.init.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.blocks.InitBlocks;
import net.sanberdir.lessen.init.entity.ModEntityTypes;
import net.sanberdir.lessen.init.items.custom.BurnedBlockItem;
import net.sanberdir.lessen.init.items.custom.ModBrownBoatItem;
import net.sanberdir.lessen.init.items.custom.ModSpawnEggItem;

public class InitItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Lessen.MOD_ID);

    public static final RegistryObject<Item> FIRE_POT = ITEMS.register("fire_pot",
            () -> new Item( new Item.Properties().group(ModItemsGroup.MOD_ITEMS)));

    public static final RegistryObject<Item> BROWN_LEAVES = ITEMS.register("brown_leaves",
            () -> new BlockItem(InitBlocks.BROWN_LEAVES.get(),
                    new Item.Properties().group(ModItemsGroup.MOD_BLOCKS)));

    public static final RegistryObject<Item> PURPLE_GRASS = ITEMS.register("purple_grass",
            () -> new BlockItem(InitBlocks.PURPLE_GRASS.get(), new Item.Properties()
                    .group(ModItemsGroup.MOD_BLOCKS)));

    public static final RegistryObject<Item> BROWN_BOAT = ITEMS.register("brown_boat",
            () -> new ModBrownBoatItem(new Item.Properties().maxStackSize(1).group(ModItemsGroup.MOD_BLOCKS),"brown"));

    public static final RegistryObject<Item> BROWN_SIGN = ITEMS.register("brown_sign",
            () -> new SignItem(new Item.Properties().maxStackSize(16).group(ModItemsGroup.MOD_BLOCKS),
                    InitBlocks.BROWN_SIGN.get(), InitBlocks.BROWN_WALL_SIGN.get()));


    public static final RegistryObject<Item> BROWN_SAPLING = ITEMS.register("brown_sapling",
            () -> new BlockItem(InitBlocks.BROWN_SAPLING.get(),
                    new Item.Properties().group(ModItemsGroup.MOD_BLOCKS)));

    public static final RegistryObject<Item> BROWN_FENCE = ITEMS.register("brown_fence",
            () -> new BurnedBlockItem(InitBlocks.BROWN_FENCE.get(),
                    new Item.Properties().group(ModItemsGroup.MOD_BLOCKS)));
    public static final RegistryObject<Item> BROWN_FENCE_GATE = ITEMS.register("brown_fence_gate",
            () -> new BurnedBlockItem(InitBlocks.BROWN_FENCE_GATE.get(),
                    new Item.Properties().group(ModItemsGroup.MOD_BLOCKS)));

    public static final RegistryObject<Item> METAL_SPIDER_SPAWN_EGG = ITEMS.register("metal_spider_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.METAL_SPIDER,0x30d5c8,0x42aaff, new Item.Properties().group(ModItemsGroup.MOD_ITEMS)));
//HEX цвета
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
