package main.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class BroadcastCommand : CommandExecutor{
    override fun onCommand(sender: CommandSender, cmd: Command, lbl: String, args: Array<out String>): Boolean {

        if (!sender.isOp || !sender.hasPermission("terozax.broadcast")) {
            sender.sendMessage("§8[§cBroadcast§8] §7Vous n'avez pas la permission de &§/broadcast§7.")
            return true
        }

        if (args.isEmpty()) {
            sender.sendMessage("§8[§cBroadcast§8] §7La commande doit être suivie du message à diffuser.")
            return true
        }

        sender.server.broadcastMessage("§8§l[§c§lALERTE§8§l] §6§l${sender.name} §7: §b${args.joinToString(" ")}")
        return true
    }

}