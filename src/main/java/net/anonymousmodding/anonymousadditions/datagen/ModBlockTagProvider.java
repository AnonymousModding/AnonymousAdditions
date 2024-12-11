package net.anonymousmodding.anonymousadditions.datagen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AnonymousAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FLAMING_EMBERS_ORE.get())
                .add(ModBlocks.ENCHANTED_CRYSTAL_BLOCK.get())
                .add(ModBlocks.BUDDING_ENCHANTED_CRYSTAL.get())
                .add(ModBlocks.SMALL_ENCHANTED_CLUSTER_BUD.get())
                .add(ModBlocks.MEDIUM_ENCHANTED_CLUSTER_BUD.get())
                .add(ModBlocks.LARGE_ENCHANTED_CLUSTER_BUD.get())
                .add(ModBlocks.ENCHANTED_CLUSTER.get())
                .add(ModBlocks.RUBY_DEEPSLATE_GEM.get())
                .add(ModBlocks.RUBY_STONE_GEM.get())
                .add(ModBlocks.SAPPHIRE_DEEPSLATE_GEM.get())
                .add(ModBlocks.SAPPHIRE_STONE_GEM.get())
                .add(ModBlocks.TOPAZ_STONE_GEM.get())
                .add(ModBlocks.TOPAZ_DEEPSLATE_GEM.get())
                .add(ModBlocks.OMNIGEODE_BLOCK.get())
                .add(ModBlocks.BUDDING_OMNIGEODE_BLOCK.get())
                .add(ModBlocks.SMALL_OMNIGEODE_CLUSTER.get())
                .add(ModBlocks.MEDIUM_OMNIGEODE_CLUSTER.get())
                .add(ModBlocks.LARGE_OMNIGEODE_CLUSTER.get())
                .add(ModBlocks.OMNIGEODE_CLUSTER.get());


        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.TINKERER_WORKBENCH.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RUBY_DEEPSLATE_GEM.get())
                .add(ModBlocks.RUBY_STONE_GEM.get())
                .add(ModBlocks.SAPPHIRE_DEEPSLATE_GEM.get())
                .add(ModBlocks.SAPPHIRE_STONE_GEM.get())
                .add(ModBlocks.TOPAZ_STONE_GEM.get())
                .add(ModBlocks.TOPAZ_DEEPSLATE_GEM.get())
                .add(ModBlocks.OMNIGEODE_BLOCK.get())
                .add(ModBlocks.BUDDING_OMNIGEODE_BLOCK.get())
                .add(ModBlocks.SMALL_OMNIGEODE_CLUSTER.get())
                .add(ModBlocks.MEDIUM_OMNIGEODE_CLUSTER.get())
                .add(ModBlocks.LARGE_OMNIGEODE_CLUSTER.get())
                .add(ModBlocks.OMNIGEODE_CLUSTER.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FLAMING_EMBERS_ORE.get())
                .add(ModBlocks.ENCHANTED_CRYSTAL_BLOCK.get())
                .add(ModBlocks.BUDDING_ENCHANTED_CRYSTAL.get())
                .add(ModBlocks.SMALL_ENCHANTED_CLUSTER_BUD.get())
                .add(ModBlocks.MEDIUM_ENCHANTED_CLUSTER_BUD.get())
                .add(ModBlocks.LARGE_ENCHANTED_CLUSTER_BUD.get())
                .add(ModBlocks.ENCHANTED_CLUSTER.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PINE_LOG.get())
                .add(ModBlocks.STRIPPED_PINE_WOOD.get())
                .add(ModBlocks.STRIPPED_PINE_LOG.get())
                .add(ModBlocks.PINE_WOOD.get());
    }
}
