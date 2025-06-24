package com.ceri.amberheart.item;

import com.ceri.amberheart.Amberheart;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Amberheart.MOD_ID);

    //This registers the Arcanic Dust item.
    public static final DeferredItem<Item> ARCANIC_DUST = ITEMS.register("arcanic_dust",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
