package net.anonymousmodding.anonymousadditions.datagen;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.anonymousmodding.anonymousadditions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }
    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        List<ItemLike> ENCHANTED_SHARD_SMELTABLES = List.of(ModBlocks.ENCHANTED_STONE.get(), ModBlocks.ENCHANTED_DEEPSLATE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENCHANTED_CLUSTER.get())
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.ENCHANTED_SHARD.get())
                .unlockedBy(getHasName(ModItems.ENCHANTED_SHARD.get()), has(ModItems.ENCHANTED_SHARD.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, ENCHANTED_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.ENCHANTED_SHARD.get(), 0.50f, 200, "enchanted_shard");
        oreBlasting(pRecipeOutput, ENCHANTED_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.ENCHANTED_SHARD.get(), 0.25f, 100, "enchanted_shard");

        smithingRecipe(pRecipeOutput, RecipeCategory.MISC, ModItems.ENCHANTED_CLUSTER.get(), Items.IRON_INGOT, Items.EXPERIENCE_BOTTLE, ModItems.ENCHANTED_STEEL.get(), "enchanted_steel");

    }

    // MAKE SURE FILES ARE GENERATED IN THE RIGHT PLACE

    protected static void smithingRecipe(RecipeOutput pRecipeOutput, RecipeCategory pCategory, ItemLike pBaseItem, Item pMaterialItem, ItemLike pAdditionalItem, Item pResultItem, String pGroup) {
        // Create the smithing recipe using the builder
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(pBaseItem),
                        Ingredient.of(pMaterialItem),
                        Ingredient.of(pAdditionalItem),
                        pCategory,
                        pResultItem)
                .unlocks("has_" + pMaterialItem.getDescriptionId(), has(pMaterialItem)) // Unlock condition based on the material item
                .save(pRecipeOutput, pResultItem.asItem() + "_smithing"); // Save with the correct recipe name
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, AnonymousAdditions.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
