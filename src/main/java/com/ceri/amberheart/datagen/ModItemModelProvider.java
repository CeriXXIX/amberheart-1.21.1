package com.ceri.amberheart.datagen;

import com.ceri.amberheart.Amberheart;
import com.ceri.amberheart.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Amberheart.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ARCANIC_DUST.get());
        basicItem(ModItems.HYMNAL_BATON.get());
    }
}
