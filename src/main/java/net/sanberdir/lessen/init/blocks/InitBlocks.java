package net.sanberdir.lessen.init.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.TreeInit;
import net.sanberdir.lessen.init.blocks.custom.*;
import net.sanberdir.lessen.init.items.InitItems;
import net.sanberdir.lessen.init.items.ModItemsGroup;
import net.sanberdir.lessen.init.trees.CustomSaplingBlock;

import java.util.function.Supplier;

public class InitBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Lessen.MOD_ID);


    public static final RegistryObject<Block> BLUE_GLASS = registerBlock("blue_glass",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.2f).sound(SoundType.GLASS)
                    .setLightLevel((state) -> { return 10; }).notSolid()));

    public static final RegistryObject<Block> BROWN_PLANKS = registerBlock("brown_planks",
            () -> new TPBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE)
                    .hardnessAndResistance(2,5).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_STONE = registerBlock("brown_stone",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2,5).sound(SoundType.STONE)));
    public static final RegistryObject<Block> IRON_ORE = registerBlock("iron_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2,5).sound(SoundType.STONE)));
    public static final RegistryObject<Block> GOLDEN_ORE = registerBlock("golden_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2,5).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BROWN_STAIRS = registerBlock("brown_stairs",
            () -> new FlameStairsBlock(() -> BROWN_PLANKS.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROWN_SLAB = registerBlock("brown_slab",
            () -> new FlameSlabBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_BUTTON = registerBlock("brown_button",
            () -> new FlameButton(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).doesNotBlockMovement()));
    public static final RegistryObject<Block> BROWN_PRESSURE_PLATE = registerBlock("brown_pressure_plate",
            () -> new FlamePressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_DOOR = registerBlock("brown_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> BROWN_TRAPDOOR = registerBlock("brown_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).notSolid()));

    public static final RegistryObject<Block> BROWN_SIGN = BLOCKS.register("brown_sign",
            () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1).sound(SoundType.WOOD), ModWoodTypes.BROWN));
    public static final RegistryObject<Block> BROWN_WALL_SIGN = BLOCKS.register("brown_wall_sign",
            () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1).sound(SoundType.WOOD), ModWoodTypes.BROWN));

    public static final RegistryObject<Block> BROWN_FENCE = BLOCKS.register("brown_fence",
            () -> new FlameFenceBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROWN_FENCE_GATE = BLOCKS.register("brown_fence_gate",
            () -> new FlameGateFenceBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_LOG = registerBlock("brown_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROWN_WOOD = registerBlock("brown_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> STRIPPED_BROWN_LOG = registerBlock("stripped_brown_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_BROWN_WOOD = registerBlock("stripped_brown_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BROWN_LEAVES = BLOCKS.register("brown_leaves",
            () -> new FlameLeaves(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)
                    .hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).harvestTool(ToolType.HOE).notSolid()));

    public static final RegistryObject<Block> BROWN_SAPLING = BLOCKS.register("brown_sapling",
            () -> new CustomSaplingBlock(AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT), TreeInit.BROWN));

    public static final RegistryObject<Block> PURPLE_GRASS_BLOCK = registerBlock("purple_grass_block",
            () -> new PurpleGrassBlock(AbstractBlock.Properties.create(Material.ORGANIC).harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(0.5F).sound(SoundType.PLANT).tickRandomly()));
    public static final RegistryObject<Block> PURPLE_DIRT = registerBlock("purple_dirt",
            () -> new Block(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.DIRT).harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(0.5F).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> PURPLE_GRASS = BLOCKS.register("purple_grass",
            () -> new PurpleGrass(AbstractBlock.Properties.create(Material.PLANTS)
                    .doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> FARMLAND_PURPLE = registerBlock("farmland_purple",
            () -> new ModFarmlandBlock(AbstractBlock.Properties.create(Material.EARTH).harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(0.5F).sound(SoundType.GROUND)));
    


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        InitItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemsGroup.MOD_BLOCKS)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
