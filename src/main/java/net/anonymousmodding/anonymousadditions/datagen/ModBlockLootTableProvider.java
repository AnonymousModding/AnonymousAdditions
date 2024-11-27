package net.anonymousmodding.anonymousadditions.datagen;

import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.anonymousmodding.anonymousadditions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TINKERER_WORKBENCH.get());
        this.add(ModBlocks.ENCHANTED_STONE.get(), block -> createOreDrop(ModBlocks.ENCHANTED_STONE.get(), ModItems.ENCHANTED_SHARD.get()));
        this.add(ModBlocks.ENCHANTED_DEEPSLATE.get(), block -> createOreDrop(ModBlocks.ENCHANTED_DEEPSLATE.get(), ModItems.ENCHANTED_SHARD.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
