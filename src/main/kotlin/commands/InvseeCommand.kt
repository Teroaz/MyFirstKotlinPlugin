package main.commands

import org.bukkit.attribute.Attribute
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class InvseeCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, lbl: String, args: Array<out String>): Boolean {

        if (sender !is Player) {
            sender.sendMessage("[Invsee] Cette commande ne peut être exécutée depuis la console.")
            return true
        }

        if (!sender.isOp || !sender.hasPermission("terozax.invsee")) {
            sender.sendMessage("§8[§cInvsee§8] §7Vous n'avez pas la permission de §c/invsee§7.")
            return true
        }

        if (args.isEmpty()) {
            sender.sendMessage("§8[§cInvsee§8] §7La commande doit être suivie du pseudo.")
            return true
        } else {
            val targetPlayer: Player? = sender.server.getPlayer(args[0])
            targetPlayer?.let { pl ->
                sender.openInventory(pl.inventory)
                return true
            }
            sender.sendMessage("§8[§cInvsee§8] §7Ce joueur n'est pas connecté.")
            return true
        }
    }
}