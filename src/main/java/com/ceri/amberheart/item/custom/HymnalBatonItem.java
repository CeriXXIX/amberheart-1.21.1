package com.ceri.amberheart.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HymnalBatonItem extends Item {
    public HymnalBatonItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            player.sendSystemMessage(Component.literal("The baton hums softly..."));
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context, List<Component> toolTipComponents, @NotNull TooltipFlag toolTipFlag) {
        toolTipComponents.add(Component.translatable("tooltip.amberheart.hymnal_baton.tooltip"));
        super.appendHoverText(stack, context, toolTipComponents, toolTipFlag);
    }
}
