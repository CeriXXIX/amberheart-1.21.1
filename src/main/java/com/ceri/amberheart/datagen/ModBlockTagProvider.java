package com.ceri.amberheart.datagen;

import com.ceri.amberheart.Amberheart;
import com.ceri.amberheart.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Amberheart.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ARCANIC_ORE.get())
                .add(ModBlocks.DEEPSLATE_ARCANIC_ORE.get());

        // tag(BlockTags.MINEABLE_WITH_AXE);

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.ARCANIC_DUST_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ARCANIC_ORE.get())
                .add(ModBlocks.DEEPSLATE_ARCANIC_ORE.get());

    }
}
