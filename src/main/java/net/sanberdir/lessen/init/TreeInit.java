package net.sanberdir.lessen.init;

import net.minecraft.world.gen.feature.Feature;
import net.sanberdir.lessen.world.TreeSpawner;

import java.util.Random;

@SuppressWarnings("rawtypes")
public class TreeInit {
    public static final TreeSpawner BROWN = new TreeSpawner() {
        @Override
        protected Feature getFeature(Random random) {
            return FeatureInit.EXAMPLE_TREE.get();
        }
    };
}