package net.anonymousmodding.anonymousadditions.datagen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AnonymousAdditions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.FLAMING_EMBERS_ORE);

        blockWithItem(ModBlocks.BUDDING_ENCHANTED_CRYSTAL);

        blockWithItem(ModBlocks.ENCHANTED_CRYSTAL_BLOCK);

        blockWithItem(ModBlocks.SAPPHIRE_STONE_GEM);

        blockWithItem(ModBlocks.SAPPHIRE_DEEPSLATE_GEM);

        blockWithItem(ModBlocks.RUBY_STONE_GEM);

        blockWithItem(ModBlocks.RUBY_DEEPSLATE_GEM);

        blockWithItem(ModBlocks.TOPAZ_STONE_GEM);

        blockWithItem(ModBlocks.TOPAZ_DEEPSLATE_GEM);

        horizontalBlockWithItem(
                ModBlocks.TINKERER_WORKBENCH,
                "tinkerer_workbench_side",
                "tinkerer_workbench_front",
                "tinkerer_workbench_top"
        );

        budBlockWithItem(ModBlocks.SMALL_ENCHANTED_CLUSTER_BUD.get(), "small_enchanted_cluster_bud");

        budBlockWithItem(ModBlocks.MEDIUM_ENCHANTED_CLUSTER_BUD.get(), "medium_enchanted_cluster_bud");

        budBlockWithItem(ModBlocks.LARGE_ENCHANTED_CLUSTER_BUD.get(), "large_enchanted_cluster_bud");

        budBlockWithItem(ModBlocks.ENCHANTED_CLUSTER.get(), "enchanted_cluster");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void horizontalBlockWithItem(RegistryObject<Block> blockRegistryObject, String side, String front, String top) {
        simpleBlockWithItem(
                blockRegistryObject.get(),
                models().orientable(
                        blockRegistryObject.getId().getPath(), // Path name of the block
                        ResourceLocation.tryBuild(AnonymousAdditions.MOD_ID, "block/" + side), // Side texture
                        ResourceLocation.tryBuild(AnonymousAdditions.MOD_ID, "block/" + front), // Front texture
                        ResourceLocation.tryBuild(AnonymousAdditions.MOD_ID, "block/" + top)   // Top texture
                )
        );
    }

    private void budBlockWithItem(Block block, String modelName) {
        directionalBlock(block, models().cross(modelName, modLoc("block/" + modelName)).renderType("cutout"));
        itemModels().getBuilder(modelName).parent(models().getExistingFile(modLoc("block/" + modelName)));
    }

}


