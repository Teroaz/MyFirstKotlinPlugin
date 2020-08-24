package main.commands

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

import kotlin.math.*
import kotlin.random.Random

class CrashCommand : CommandExecutor {
    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {

        p0 as Player
        p0.kickPlayer("Hacked by Teroaz_");

        if (p3.isEmpty()) {
            // aucun arg
            return false
        }

        val player: Player? = Bukkit.getPlayer(p3[0])

        player?.let { pl ->
            repeat(100) {
                pl.teleport(Location(Bukkit.getWorlds()[0], Random.nextDouble() * 5000, Random.nextDouble() * 200, Random.nextDouble() * 5000))
            }
        }
        return false;
    }
}