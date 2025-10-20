package com.Space.ChatCalculator;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChatCalculator.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEventListener {

    @SubscribeEvent
    public static void onClientChat(ClientChatEvent event) {
        String message = event.getMessage();
        if (!message.matches("^= .+")) return;
        String input = message.substring(2);
        event.setCanceled(true);
        double result = NumberUtil.parse(input);

        Minecraft.getInstance().player.displayClientMessage(
                Component.literal(" " + result).withStyle(ChatFormatting.AQUA),
                false

        );
    }
}
