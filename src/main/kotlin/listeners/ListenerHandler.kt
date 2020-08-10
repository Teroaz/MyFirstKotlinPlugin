package main.listeners

import listeners.PlayerJoin
import main.Loader
import org.bukkit.Bukkit

fun eventLoader (loader: Loader) {

    Bukkit.getPluginManager().registerEvents(PlayerJoin(), loader)
    loader.logger.info("[SUCCESS] Event : PlayerPreLogin")

    Bukkit.getPluginManager().registerEvents(PlayerJoin(), loader)
    loader.logger.info("[SUCCESS] Event : PlayerJoinEvent")

    Bukkit.getPluginManager().registerEvents(PlayerChat(), loader)
    loader.logger.info("[SUCCESS] Event : PlayerChatEvent")

}