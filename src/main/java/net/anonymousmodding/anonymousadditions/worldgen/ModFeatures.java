package net.anonymousmodding.anonymousadditions.worldgen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.worldgen.custom.SurfaceBoulders;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES
            = DeferredRegister.create(ForgeRegistries.FEATURES, AnonymousAdditions.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SURFACE_BOULDERS
            = FEATURES.register("surface_boulders",
            () -> new SurfaceBoulders(NoneFeatureConfiguration.CODEC));
}
