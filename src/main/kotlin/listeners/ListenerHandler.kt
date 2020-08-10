package main.listeners

import listeners.PlayerPreLogin
import main.Loader
import org.bukkit.Bukkit

fun eventLoader (loader: Loader) {

    Bukkit.getPluginManager().registerEvents(PlayerPreLogin(), loader)
    loader.logger.info("[SUCCESS] Event : PlayerPreLogin")

    Bukkit.getPluginManager().registerEvents(PlayerJoin(), loader)
    loader.logger.info("[SUCCESS] Event : PlayerJoinEvent")

    Bukkit.getPluginManager().registerEvents(PlayerChat(), loader)
    loader.logger.info("[SUCCESS] Event : PlayerChatEvent")

}