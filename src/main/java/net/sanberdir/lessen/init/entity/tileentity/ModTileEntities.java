package net.sanberdir.lessen.init.entity.tileentity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sanberdir.lessen.Lessen;
import net.sanberdir.lessen.init.blocks.InitBlocks;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Lessen.MOD_ID);

    public static final RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITIES =
            TILE_ENTITIES.register("sign", () -> TileEntityType.Builder.create(ModSignTileEntity::new,
                    InitBlocks.BROWN_SIGN.get(),
                    InitBlocks.BROWN_WALL_SIGN.get()
            ).build(null));


    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}