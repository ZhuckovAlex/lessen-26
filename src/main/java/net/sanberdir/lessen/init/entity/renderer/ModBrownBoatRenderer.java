package net.sanberdir.lessen.init.entity.renderer;

import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;
import net.sanberdir.lessen.Lessen;

public class ModBrownBoatRenderer extends BoatRenderer {
    private static final ResourceLocation BOAT_TEXTURE =
            new ResourceLocation(Lessen.MOD_ID, "textures/entity/boat/brown.png");

    public ModBrownBoatRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }


    @Override
    public ResourceLocation getEntityTexture(BoatEntity entity) {
        return BOAT_TEXTURE;
    }
}