package net.sanberdir.lessen.init.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.sanberdir.lessen.init.blocks.InitBlocks;

public class ModItemsGroup {

    public static final ItemGroup MOD_ITEMS = new ItemGroup("mod_items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(InitItems.FIRE_POT.get());
        }
    };

    public static final ItemGroup MOD_BLOCKS = new ItemGroup("mod_blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(InitBlocks.BROWN_PLANKS.get());
        }
    };
}
