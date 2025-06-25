package com.ceri.amberheart.datagen;

import com.ceri.amberheart.Amberheart;
import com.ceri.amberheart.block.ModBlocks;
import com.ceri.amberheart.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> ARCANIC_SMELTABLES = List.of(ModBlocks.ARCANIC_ORE,
                ModBlocks.DEEPSLATE_ARCANIC_ORE);

        // Generates recipe for Arcanic Dust Block.
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ARCANIC_DUST_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ARCANIC_DUST.get())
                .unlockedBy("has_arcanic_dust", has(ModItems.ARCANIC_DUST)).save(recipeOutput);

        // Generates left recipe for Hymnal Baton.
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HYMNAL_BATON.get())
                .pattern("FA ")
                .pattern("AS ")
                .pattern("  S")
                .define('A', ModItems.ARCANIC_DUST.get())
                .define('F', Items.FEATHER)
                .define('S', Items.STICK)
                .unlockedBy("has_arcanic_dust", has(ModItems.ARCANIC_DUST))
                .save(recipeOutput, "amberheart:hymnal_baton_left");

        // Generates right recipe for Hymnal Baton.
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HYMNAL_BATON.get())
                .pattern(" AF")
                .pattern(" SA")
                .pattern("S  ")
                .define('A', ModItems.ARCANIC_DUST.get())
                .define('F', Items.FEATHER)
                .define('S', Items.STICK)
                .unlockedBy("has_arcanic_dust", has(ModItems.ARCANIC_DUST))
                .save(recipeOutput, "amberheart:hymnal_baton_right");

        // Generates recipe for shapeless decompacting of Arcanic Dust Block.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ARCANIC_DUST.get(), 9)
                .requires(ModBlocks.ARCANIC_DUST_BLOCK)
                .unlockedBy("has_arcanic_dust_block", has(ModBlocks.ARCANIC_DUST_BLOCK)).save(recipeOutput);

        //Generates ore smelting and blasting recipes for Arcanic Ore.
        oreSmelting(recipeOutput, ARCANIC_SMELTABLES, RecipeCategory.MISC, ModBlocks.ARCANIC_ORE.get(), 0.25f, 200 , "arcanic");
        oreBlasting(recipeOutput, ARCANIC_SMELTABLES, RecipeCategory.MISC, ModBlocks.ARCANIC_ORE.get(), 0.25f, 100 , "arcanic");

        //Generates ore smelting and blasting recipes for Deepslate Arcanic Ore.
        oreSmelting(recipeOutput, ARCANIC_SMELTABLES, RecipeCategory.MISC, ModBlocks.DEEPSLATE_ARCANIC_ORE.get(), 0.25f, 200 , "arcanic");
        oreBlasting(recipeOutput, ARCANIC_SMELTABLES, RecipeCategory.MISC, ModBlocks.DEEPSLATE_ARCANIC_ORE.get(), 0.25f, 100 , "arcanic");
    }


    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "from_blasting");
    }

    protected static<T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                      List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemLike), has (itemLike))
                    .save(recipeOutput, Amberheart.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
