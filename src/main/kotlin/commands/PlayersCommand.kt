package main.commands

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

import java.math.BigDecimal
import java.math.RoundingMode

class PlayersCommand : CommandExecutor{
    override fun onCommand(sender: CommandSender, cmd: Command, lbl: String, args: Array<out String>): Boolean { 
        if (sender !is Player) {
            sender.sendMessage("[Players] Cette commande ne peut être exécutée depuis la console.")
            return true
        }

        val connectedPlayers = sender.server.onlinePlayers

        val commandGui : Inventory = Bukkit.createInventory(null, 54, "§8• §3${connectedPlayers.size} joueur${if (connectedPlayers.size == 1) "" else "s"} en ligne" )

        connectedPlayers.forEachIndexed { index, player ->
            
            if (player == null) return@forEachIndexed

            val playerHead = ItemStack(Material.PLAYER_HEAD, 1)
            val meta : SkullMeta = playerHead.itemMeta as SkullMeta

            meta.owningPlayer = player
            meta.setDisplayName("§b${player.name}")
            meta.lore = mutableListOf("§8• §cSanté §7: ${player.health.toInt()} / ${player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.defaultValue?.toInt() ?: 20}", "§8• §6Faim §7: ${(player.foodLevel)} / 20", "§8• §6Monde §7: ${player.world.name}")

            playerHead.itemMeta = meta

            commandGui.setItem(index, playerHead)
        }
        sender.openInventory(commandGui)
    return true
    }
}



