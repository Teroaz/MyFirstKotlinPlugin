package main.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoin : Listener {

    @EventHandler
    fun joinEvent(event: PlayerJoinEvent){

    event.joinMessage = null;
    val player = event.player

    player.sendMessage("""
    §bHeyy my boy §6${player.name} §b!

    §8• §cVoici ton adresse IP : §6${player.address?.address?.hostAddress?: "N/A"} 
    §8• §fVive les chèvres :)

    """.trimIndent())

    }
}