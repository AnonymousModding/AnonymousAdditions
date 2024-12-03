package net.anonymousmodding.anonymousadditions.worldgen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.ArrayList;
import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_STONE_KEY = registerKey("enchanted_stone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_DEEPSLATE_KEY = registerKey("enchanted_deepslate");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLAMING_EMBERS_ORE_KEY = registerKey("flaming_embers_ore");



    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, ENCHANTED_STONE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables, ModBlocks.ENCHANTED_STONE.get().defaultBlockState(), 4));
        register(context, ENCHANTED_DEEPSLATE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables, ModBlocks.ENCHANTED_DEEPSLATE.get().defaultBlockState(), 6));
        register(context, FLAMING_EMBERS_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.FLAMING_EMBERS_ORE.get().defaultBlockState(), 12));



    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AnonymousAdditions.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}