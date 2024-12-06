package net.anonymousmodding.anonymousadditions.datagen;

import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.anonymousmodding.anonymousadditions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
        this.add(ModBlocks.FLAMING_EMBERS_ORE.get(), block -> createMultipleOresDrop(ModBlocks.FLAMING_EMBERS_ORE.get(), ModItems.FLAMING_EMBERS.get(), 2, 5));
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.add(ModBlocks.BUDDING_RUBY.get(), block -> noDrop());
        this.add(ModBlocks.SMALL_RUBY_BUD.get(), block -> noDrop());
        this.add(ModBlocks.MEDIUM_RUBY_BUD.get(), block -> noDrop());
        this.add(ModBlocks.LARGE_RUBY_BUD.get(), block -> noDrop());
        dropOther(ModBlocks.RUBY_CLUSTER.get(), ModItems.RAW_RUBY.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createMultipleOresDrop(Block pBlock, Item pItem, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
}
