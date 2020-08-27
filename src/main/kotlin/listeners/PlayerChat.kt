package main.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class PlayerChat : Listener{

    @EventHandler
    fun asyncPlayerChatEvent(event: AsyncPlayerChatEvent) {
        event.isCancelled = true

        val player = event.player
        val message = event.message

        if (message.replace("(&.?)".toRegex(), "").isNotEmpty()) {
            player.server.broadcastMessage("§6${player.name}§7 : §f${message.replace("&", "§")}")
        }
    }
}