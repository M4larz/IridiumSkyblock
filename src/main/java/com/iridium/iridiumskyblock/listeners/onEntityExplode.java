package com.iridium.iridiumskyblock.listeners;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class onEntityExplode implements Listener {
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
    	if (!IridiumSkyblock.getConfiguration().enabledWorlds.contains(e.getLocation().getWorld().getName()) && !IridiumSkyblock.getConfiguration().enabledWorldsIsBlacklist)
    		return;
    	if (IridiumSkyblock.getConfiguration().enabledWorlds.contains(e.getLocation().getWorld().getName()) && IridiumSkyblock.getConfiguration().enabledWorldsIsBlacklist)
    		return;
        try {
            if (e.getLocation().getWorld().equals(IridiumSkyblock.getIslandManager().getWorld())) {
                e.setCancelled(true);
            }
        } catch (Exception ex) {
            IridiumSkyblock.getInstance().sendErrorMessage(ex);
        }
    }
}