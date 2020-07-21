package main

import main.commands.BroadcastCommand
import main.commands.HealCommand
import main.listeners.eventLoader

import org.bukkit.command.CommandExecutor
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Loader : JavaPlugin(), Listener, CommandExecutor{

    override fun onEnable() {
        logger.info("Core démarré avec succès")

        // Events
        eventLoader(this)

        // Commandes
        getCommand("heal")?.setExecutor(HealCommand())
        getCommand("broadcast")?.setExecutor(BroadcastCommand())
    }
}