package net.anonymousmodding.anonymousadditions.worldgen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.ArrayList;
import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLAMING_EMBERS_ORE_KEY = registerKey("flaming_embers_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_CRYSTAL_GEODE_KEY = registerKey("enchanted_crystal_geode");



    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, FLAMING_EMBERS_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.FLAMING_EMBERS_ORE.get().defaultBlockState(), 12));

        register(context, ENCHANTED_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.ENCHANTED_CRYSTAL_BLOCK.get()), BlockStateProvider.simple(ModBlocks.BUDDING_ENCHANTED_CRYSTAL.get()),
                        BlockStateProvider.simple(Blocks.CALCITE), BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.SMALL_ENCHANTED_CLUSTER_BUD.get().defaultBlockState(), ModBlocks.MEDIUM_ENCHANTED_CLUSTER_BUD.get().defaultBlockState(),
                                ModBlocks.LARGE_ENCHANTED_CLUSTER_BUD.get().defaultBlockState(), ModBlocks.ENCHANTED_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7, 2.2, 6.0, 9.0),
                        new GeodeCrackSettings(0.95, 2.0, 2), 0.35, 0.083,
                        true, UniformInt.of(4, 6), UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05, 1));


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AnonymousAdditions.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}