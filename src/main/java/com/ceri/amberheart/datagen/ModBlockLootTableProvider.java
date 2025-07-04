package com.ceri.amberheart.datagen;

import com.ceri.amberheart.block.ModBlocks;
import com.ceri.amberheart.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ARCANIC_DUST_BLOCK.get()); // Arcanic Dust Blocks will drop  themselves.
        add(ModBlocks.ARCANIC_ORE.get(), // Arcanic Ore will drop 1-2 Arcanic Dust.
                block -> createMultipleOreDrops(ModBlocks.ARCANIC_ORE.get(), ModItems.ARCANIC_DUST.get(), 1, 2));
        add(ModBlocks.DEEPSLATE_ARCANIC_ORE.get(), // Deepslate Arcanic Ore will drop 1-2 Arcanic Dust.
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_ARCANIC_ORE.get(), ModItems.ARCANIC_DUST.get(), 1, 2));
    }

    // Allows for ores to drop their drops in copper-esque quantities.
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    // Grabs every registered block from the ModBlocks class and iterates them in a method configurable by loot tables.
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
