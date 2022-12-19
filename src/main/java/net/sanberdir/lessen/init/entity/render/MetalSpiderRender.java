package net.sanberdir.lessen.init.entity.render;


import net.minecraft.client.renderer.entity.EntityRendererManager;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.entity.custom.MetalSpiderEntity;
import net.sanberdir.lessen.init.entity.model.MetalSpiderModel;

public class MetalSpiderRender extends MobRenderer<MetalSpiderEntity, MetalSpiderModel<MetalSpiderEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(Lessen.MOD_ID, "textures/entity/metal_spider.png");

    public MetalSpiderRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MetalSpiderModel<>(), 0.2F);
    }

    @Override
    public ResourceLocation getEntityTexture(MetalSpiderEntity entity) {
        return TEXTURE;
    }
}