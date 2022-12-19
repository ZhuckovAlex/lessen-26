package net.sanberdir.lessen.init.blocks.custom;

import net.minecraft.block.WoodType;
import net.minecraft.util.ResourceLocation;
import net.sanberdir.lessen.Lessen;

public class ModWoodTypes {
    public static final WoodType BROWN =
            WoodType.create(new ResourceLocation(Lessen.MOD_ID, "brown").toString());
}