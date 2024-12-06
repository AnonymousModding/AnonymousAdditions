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
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ENCHANTED_STONE = registerKey("add_enchanted_stone");
    public static final ResourceKey<BiomeModifier> ADD_ENCHANTED_DEEPSLATE = registerKey("add_enchanted_deepslate");
    public static final ResourceKey<BiomeModifier> ADD_FLAMING_EMBERS_ORE = registerKey("add_flaming_embers_ore");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_GEODE = registerKey("add_ruby_geode");



    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_ENCHANTED_STONE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.ENCHANTED_STONE_PLACED_KEY)),
                GenerationStep.Decoration.RAW_GENERATION));

        context.register(ADD_ENCHANTED_DEEPSLATE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.ENCHANTED_DEEPSLATE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_FLAMING_EMBERS_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.FLAMING_EMBERS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_RUBY_GEODE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.RUBY_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(AnonymousAdditions.MOD_ID, name));
    }
}
