package net.anonymousmodding.anonymousadditions.worldgen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FLAMING_EMBERS_ORE_PLACED_KEY = registerKey("flaming_embers_ore_placed");

    public static final ResourceKey<PlacedFeature> ENCHANTED_CRYSTAL_GEODE_PLACED_KEY = registerKey("enchanted_crystal_geode_placed");
    public static final ResourceKey<PlacedFeature> OMNIGEODE_GEODE_PLACED_KEY = registerKey("omnigeode_geode_placed");

    public static final ResourceKey<PlacedFeature> STONE_SAPPHIRE_PLACED_KEY = registerKey("stone_sapphire_placed");
    public static final ResourceKey<PlacedFeature> STONE_RUBY_PLACED_KEY = registerKey("stone_ruby_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_RUBY_PLACED_KEY = registerKey("deepslate_ruby_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_SAPPHIRE_PLACED_KEY = registerKey("deepslate_sapphire_placed");
    public static final ResourceKey<PlacedFeature> STONE_TOPAZ_PLACED_KEY = registerKey("stone_topaz_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_TOPAZ_PLACED_KEY = registerKey("deepslate_topaz_placed");
    public static final ResourceKey<PlacedFeature> PINE_PLACED_KEY = registerKey("pine_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, FLAMING_EMBERS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLAMING_EMBERS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));

        register(context, STONE_RUBY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STONE_RUBY_KEY),
                ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(50))));

        register(context, STONE_SAPPHIRE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STONE_SAPPHIRE_KEY),
                ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(50))));

        register(context, DEEPSLATE_RUBY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_RUBY_KEY),
                ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(5))));

        register(context, DEEPSLATE_SAPPHIRE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_SAPPHIRE_KEY),
                ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(5))));

        register(context, STONE_TOPAZ_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STONE_TOPAZ_KEY),
                ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(50))));

        register(context, DEEPSLATE_TOPAZ_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEPSLATE_TOPAZ_KEY),
                ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(5))));

        register(context, ENCHANTED_CRYSTAL_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENCHANTED_CRYSTAL_GEODE_KEY), List.of(RarityFilter.onAverageOnceEvery(24),
                InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(0)), BiomeFilter.biome()));

        register(context, OMNIGEODE_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OMNIGEODE_GEODE_KEY), List.of(RarityFilter.onAverageOnceEvery(40),
                InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(0)), BiomeFilter.biome()));

        register(context, PINE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PINE_KEY), VegetationPlacements.treePlacement(PlacementUtils
                .countExtra(3, 0.1f, 2), ModBlocks.PINE_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(AnonymousAdditions.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
