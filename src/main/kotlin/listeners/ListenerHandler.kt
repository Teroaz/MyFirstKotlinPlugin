package main.listeners

import main.Loader
import org.bukkit.Bukkit

fun eventLoader (loader: Loader) {
    Bukkit.getPluginManager().registerEvents(PlayerJoin(), loader)
}