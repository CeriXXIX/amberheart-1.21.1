/* package com.ceri.amberheart.datagen;
import com.ceri.amberheart.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }
    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.FUEL_PLACEHOLDER.getId(), new FurnaceFuel(1200, false));
    }
}

This is one big placeholder for if fuel is ever added to the mod. Remove the comment sections and
replace FUEL_PLACEHOLDER in the gather method (as well as FurnaceFuel's burntime). Also make sure
you uncomment the ModDataMapProvider generator in com.ceri.amberheart.datagen.DataGenerators.

*/