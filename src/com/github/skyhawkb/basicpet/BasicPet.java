package com.github.skyhawkb.basicpet;

import java.util.logging.*;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.*;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.plugin.java.*;

/**
 * @author Daniel Meylakh
 * @version 1.3
 */

public class BasicPet extends JavaPlugin {
    private static final Logger LOG = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("dog")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;

                Location loc = me.getLocation();
                World world = me.getWorld();

                String name = "Dog of: " + me.getDisplayName();

                Wolf wolf = world.spawn(loc, Wolf.class);
                wolf.setOwner(me);
                wolf.setCollarColor(DyeColor.LIME);
                wolf.setSitting(true);
                wolf.setCustomName(name);

                LOG.info("[BasicPet] Summoned 1 dog!");
                return true;
            }
        }

        if(label.equalsIgnoreCase("cat")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;

                Location loc = me.getLocation();
                World world = me.getWorld();

                String name = "Cat of: " + me.getDisplayName();

                Ocelot cat = world.spawn(loc, Ocelot.class);
                cat.setCatType(Ocelot.Type.RED_CAT);
                cat.setOwner(me);
                cat.setSitting(true);
                cat.setCustomName(name);


                LOG.info("[BasicPet] Summoned 1 cat!");
                return true;
            }
        }
        return false;
    }
}
