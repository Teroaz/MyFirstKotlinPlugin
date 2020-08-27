package main.commands

import org.bukkit.attribute.Attribute
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HealCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, lbl: String, args: Array<out String>): Boolean {

        if (sender !is Player) {
            sender.sendMessage("[Heal] Cette commande ne peut être exécutée depuis la console.")
            return true
        }

        if (!sender.isOp || !sender.hasPermission("terozax.heal")) {
            sender.sendMessage("§8[§cHeal§8] §7Vous n'avez pas la permission de §c/heal§7.")
            return true
        }

        var playerToHeal: Player? = null

        if (args.isEmpty()) {
           playerToHeal = sender
            sender.sendMessage("§8[§cHeal§8] §7Vous avez été soigné avec succès.")
        } else {
            val targetPlayer: Player? = sender.server.getPlayer(args[0])
            if (targetPlayer == null) {
                sender.sendMessage("§8[§cHeal§8] §7Ce joueur n'est pas connecté.")
                return true
            }

            playerToHeal = targetPlayer
            if (targetPlayer.name == sender.name) {
                sender.sendMessage("§8[§cHeal§8] §7Vous avez été soigné avec succès.")
            } else {
                sender.sendMessage("§8[§cHeal§8] §7Vous avez soigné §c${targetPlayer.name} §7avec succès.")
                targetPlayer.sendMessage("§8[§cHeal§8] §c${sender.name} §7vous a soigné.")
                }
        }

        playerToHeal.health = playerToHeal.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.defaultValue ?: 20.0
        playerToHeal.foodLevel = 20
        return true
        }
    }
