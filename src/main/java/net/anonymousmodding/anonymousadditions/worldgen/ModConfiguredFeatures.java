package net.anonymousmodding.anonymousadditions.worldgen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.ArrayList;
import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLAMING_EMBERS_ORE_KEY = registerKey("flaming_embers_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_CRYSTAL_GEODE_KEY = registerKey("enchanted_crystal_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OMNIGEODE_GEODE_KEY = registerKey("omnigeode_geode");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STONE_SAPPHIRE_KEY = registerKey("stone_sapphire");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STONE_RUBY_KEY = registerKey("stone_ruby");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_SAPPHIRE_KEY = registerKey("deepslate_sapphire");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_RUBY_KEY = registerKey("deepslate_ruby");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_TOPAZ_KEY = registerKey("deepslate_topaz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STONE_TOPAZ_KEY = registerKey("stone_topaz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SURFACE_BOULDERS_KEY = registerKey("surface_boulders");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_KEY = registerKey("pine");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, STONE_RUBY_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables, ModBlocks.RUBY_STONE_GEM.get().defaultBlockState(), 4));

        register(context, STONE_SAPPHIRE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables, ModBlocks.SAPPHIRE_STONE_GEM.get().defaultBlockState(), 4));

        register(context, DEEPSLATE_RUBY_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables, ModBlocks.RUBY_DEEPSLATE_GEM.get().defaultBlockState(), 4));

        register(context, DEEPSLATE_SAPPHIRE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables, ModBlocks.SAPPHIRE_DEEPSLATE_GEM.get().defaultBlockState(), 4));

        register(context, DEEPSLATE_TOPAZ_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables, ModBlocks.TOPAZ_DEEPSLATE_GEM.get().defaultBlockState(), 4));

        register(context, STONE_TOPAZ_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables, ModBlocks.TOPAZ_STONE_GEM.get().defaultBlockState(), 4));


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

        register(context, OMNIGEODE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.OMNIGEODE_BLOCK.get()), BlockStateProvider.simple(ModBlocks.BUDDING_OMNIGEODE_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE), BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.SMALL_OMNIGEODE_CLUSTER.get().defaultBlockState(), ModBlocks.MEDIUM_OMNIGEODE_CLUSTER.get().defaultBlockState(),
                                ModBlocks.LARGE_OMNIGEODE_CLUSTER.get().defaultBlockState(), ModBlocks.OMNIGEODE_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7, 2.2, 6.0, 9.0),
                        new GeodeCrackSettings(0.95, 2.0, 2), 0.35, 0.083,
                        true, UniformInt.of(4, 6), UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05, 1));

        register(context, PINE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PINE_LOG.get()),
                new StraightTrunkPlacer(5, 4, 1),

                BlockStateProvider.simple(ModBlocks.PINE_LEAVES.get()),
                new PineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(3)),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, SURFACE_BOULDERS_KEY, ModFeatures.SURFACE_BOULDERS.get(), new NoneFeatureConfiguration());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AnonymousAdditions.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}