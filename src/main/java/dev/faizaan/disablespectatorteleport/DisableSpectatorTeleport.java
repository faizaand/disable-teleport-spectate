package dev.faizaan.disablespectatorteleport;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DisableSpectatorTeleport extends JavaPlugin implements Listener {

    private static final String PREFIX = ChatColor.DARK_RED + "Cornell" + ChatColor.WHITE + "Craft" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Spectator teleportation will be disabled. Made by Faizaan Datoo.");
    }

    @EventHandler
    public void onSpectatorTeleport(PlayerTeleportEvent e) {
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.SPECTATE && !e.getPlayer().hasPermission("spectatortp.bypass")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(PREFIX + ChatColor.RED + "Sorry, but we don't allow spectator teleportation on this server.");
        }
    }

    @Override
    public void onDisable() {
    }
}
