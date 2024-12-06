package net.anonymousmodding.anonymousadditions.worldgen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ENCHANTED_STONE_PLACED_KEY = registerKey("enchanted_stone_placed");
    public static final ResourceKey<PlacedFeature> ENCHANTED_DEEPSLATE_PLACED_KEY = registerKey("enchanted_deepslate_placed");
    public static final ResourceKey<PlacedFeature> FLAMING_EMBERS_ORE_PLACED_KEY = registerKey("flaming_embers_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBY_GEODE_PLACED_KEY = registerKey("ruby_geode_placed");



    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ENCHANTED_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENCHANTED_STONE_KEY),
                ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(80), VerticalAnchor.absolute(256))));

        register(context, ENCHANTED_DEEPSLATE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENCHANTED_DEEPSLATE_KEY),
                ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(-64))));

        register(context, FLAMING_EMBERS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLAMING_EMBERS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));

        register(context, RUBY_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_GEODE_KEY), List.of(RarityFilter.onAverageOnceEvery(24),
                InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(0)), BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(AnonymousAdditions.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
