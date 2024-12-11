package net.anonymousmodding.anonymousadditions.datagen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        blockWithItem(ModBlocks.BUDDING_OMNIGEODE_BLOCK);
        blockWithItem(ModBlocks.OMNIGEODE_BLOCK);

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

        budBlockWithItem(ModBlocks.SMALL_OMNIGEODE_CLUSTER.get(), "small_omnigeode_cluster");
        budBlockWithItem(ModBlocks.MEDIUM_OMNIGEODE_CLUSTER.get(), "medium_omnigeode_cluster");
        budBlockWithItem(ModBlocks.LARGE_OMNIGEODE_CLUSTER.get(), "large_omnigeode_cluster");
        budBlockWithItem(ModBlocks.OMNIGEODE_CLUSTER.get(), "omnigeode_cluster");

        logBlock(ModBlocks.PINE_LOG.get());
        logBlock(ModBlocks.STRIPPED_PINE_LOG.get());
        axisBlock(ModBlocks.PINE_WOOD.get(), blockTexture(ModBlocks.PINE_LOG.get()), blockTexture(ModBlocks.PINE_LOG.get()));
        axisBlock(ModBlocks.STRIPPED_PINE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()), blockTexture(ModBlocks.STRIPPED_PINE_LOG.get()));
        blockItem(ModBlocks.PINE_LOG);
        blockItem(ModBlocks.STRIPPED_PINE_WOOD);
        blockItem(ModBlocks.PINE_WOOD);
        blockItem(ModBlocks.STRIPPED_PINE_LOG);
        blockWithItem(ModBlocks.PINE_PLANKS);
        saplingBlock(ModBlocks.PINE_SAPLING);
        leavesBlock(ModBlocks.PINE_LEAVES);
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

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("anonymousadditions:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("anonymousadditions:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}


