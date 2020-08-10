package main

import commands.TeroazCommand
import main.commands.BroadcastCommand
import main.commands.HealCommand
import main.commands.PlayersCommand

import main.listeners.eventLoader

import org.bukkit.command.CommandExecutor
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Loader : JavaPlugin(), Listener, CommandExecutor{

    override fun onEnable() {

        // Event Handler
        logger.info("[INIT] Event Loader")
        eventLoader(this)
        logger.info("[SUCCESS] Init de l'event loader")

        // Commandes
        logger.info("[INIT] Commandes")
        getCommand("heal")?.setExecutor(HealCommand())
        getCommand("broadcast")?.setExecutor(BroadcastCommand())
        getCommand("players")?.setExecutor(PlayersCommand())
        getCommand("teroaz")?.setExecutor(TeroazCommand())
        logger.info("[SUCCESS] Init des commandes")

        logger.info("[SUCCESS] Terozax-Core démarré")
    }
}