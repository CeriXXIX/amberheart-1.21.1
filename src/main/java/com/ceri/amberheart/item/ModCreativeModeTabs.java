package com.ceri.amberheart.item;

import com.ceri.amberheart.Amberheart;
import com.ceri.amberheart.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

//This class creates the two custom Creative Mode Menus currently associated with Amberheart.
public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Amberheart.MOD_ID);

    // This block creates the Amberheart Items Tab.
    public static final Supplier<CreativeModeTab> AMBERHEART_ITEMS_TAB = CREATIVE_MODE_TAB.register("amberheart_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ARCANIC_DUST.get()))  // This makes Arcanic Dust the tab icon.
                    .title(Component.translatable("creativetab.amberheart.amberheart_items_tab"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModItems.ARCANIC_DUST);
                            }).build());

    // This block creates the Amberheart Blocks Tab.
    public static final Supplier<CreativeModeTab> AMBERHEART_BLOCK_TAB = CREATIVE_MODE_TAB.register("amberheart_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ARCANIC_ORE.get()))  // This makes Arcanic Ore the tab icon.
                    .title(Component.translatable("creativetab.amberheart.amberheart_blocks_tab"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Amberheart.MOD_ID, "amberheart_items_tab")) // This places the Blocks tab AFTER the Items tab.
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ARCANIC_ORE);
                        output.accept(ModBlocks.DEEPSLATE_ARCANIC_ORE);
                        output.accept(ModBlocks.ARCANIC_DUST_BLOCK);
                    }).build());


    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TAB.register(eventbus);
    }
}
