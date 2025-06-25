package com.ceri.amberheart.item;

import com.ceri.amberheart.Amberheart;
import com.ceri.amberheart.item.custom.HymnalBatonItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Amberheart.MOD_ID);

    // This registers the Arcanic Dust item.
    public static final DeferredItem<Item> ARCANIC_DUST = ITEMS.register("arcanic_dust",
            () -> new Item(new Item.Properties()));
    // This registers the Hymnal Baton item.
    public static final DeferredItem<Item> HYMNAL_BATON = ITEMS.register("hymnal_baton",
            () -> new HymnalBatonItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
