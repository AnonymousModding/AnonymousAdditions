package net.anonymousmodding.anonymousadditions.worldgen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_FLAMING_EMBERS_ORE = registerKey("add_flaming_embers_ore");
    public static final ResourceKey<BiomeModifier> ADD_ENCHANTED_CRYSTAL_GEODE = registerKey("add_enchanted_crystal_geode");
    public static final ResourceKey<BiomeModifier> ADD_STONE_RUBY_GEM = registerKey("add_stone_ruby_gem");
    public static final ResourceKey<BiomeModifier> ADD_STONE_SAPPHIRE_GEM = registerKey("add_stone_sapphire_gem");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_RUBY_GEM = registerKey("add_deepslate_ruby_gem");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_SAPPHIRE_GEM = registerKey("add_deepslate_sapphire_gem");
    public static final ResourceKey<BiomeModifier> ADD_STONE_TOPAZ_GEM = registerKey("add_stone_topaz_gem");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_TOPAZ_GEM = registerKey("add_deepslate_topaz_gem");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_FLAMING_EMBERS_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.FLAMING_EMBERS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_STONE_RUBY_GEM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT), biomes.getOrThrow(Biomes.BADLANDS), biomes.getOrThrow(Biomes.SAVANNA)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.STONE_RUBY_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_STONE_SAPPHIRE_GEM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OCEAN),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.STONE_SAPPHIRE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEEPSLATE_RUBY_GEM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.DEEPSLATE_RUBY_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEEPSLATE_SAPPHIRE_GEM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.DEEPSLATE_SAPPHIRE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_STONE_TOPAZ_GEM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.OLD_GROWTH_SPRUCE_TAIGA), biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.OLD_GROWTH_PINE_TAIGA)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.STONE_TOPAZ_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_DEEPSLATE_TOPAZ_GEM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.DEEPSLATE_TOPAZ_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ENCHANTED_CRYSTAL_GEODE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.ENCHANTED_CRYSTAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(AnonymousAdditions.MOD_ID, name));
    }
}
