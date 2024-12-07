package net.anonymousmodding.anonymousadditions.datagen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AnonymousAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ENCHANTED_CRYSTAL_SHARD.get());
        basicItem(ModItems.ENCHANTED_CRYSTAL.get());
        basicItem(ModItems.ENCHANTED_STEEL.get());
        basicItem(ModItems.MAGIC_MIRROR.get());
        basicItem(ModItems.FLAMING_EMBERS.get());
        basicItem(ModItems.CLOUD_IN_A_BOTTLE.get());
        basicItem(ModItems.RAW_RUBY.get());
        basicItem(ModItems.POLISHED_RUBY.get());
        basicItem(ModItems.RAW_SAPPHIRE.get());
        basicItem(ModItems.POLISHED_SAPPHIRE.get());
        basicItem(ModItems.RAW_TOPAZ.get());
        basicItem(ModItems.POLISHED_TOPAZ.get());
    }
}