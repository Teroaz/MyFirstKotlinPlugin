package main.listeners

import org.bukkit.GameMode
import org.bukkit.attribute.Attribute
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoin() : Listener {

    @EventHandler
    fun joinEvent(event: PlayerJoinEvent){

    event.joinMessage = null;
    val player = event.player

    player.sendMessage("""
    §bHeyy my boy §6${player.name} §b!

    §8• §cVoici ton adresse IP : §6${player.address} ?: "N/A"}
    §8• §cTa render distance est de : §6${player.clientViewDistance}
    §8• §cT'habites ici : §6${player.locale}
    §8• §fVive les chèvres :)

    """.trimIndent())

    player.gameMode = GameMode.CREATIVE
    }
}