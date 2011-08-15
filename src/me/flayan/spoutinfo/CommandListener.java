package me.flayan.spoutinfo;

import me.flayan.spoutinfo.SpoutInfo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CommandListener
{
	private SpoutInfo plugin;
	private SpoutInfoGUI gui;

    public CommandListener(SpoutInfo spoutinfo)
    {
        plugin = spoutinfo;
        gui = new SpoutInfoGUI(plugin);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
    {
        if(!(sender instanceof SpoutPlayer))
        {
            sender.sendMessage("You need to be a player!");
            return true;
        }
        SpoutPlayer player = (SpoutPlayer)sender;
        if(player.getVersion() < 18)
        {
            player.sendMessage("You need to have the latest Spoutcraft v1.0.1 at least!");
            return true;
        }
        if(cmd.getName().equals("spoutinfo"))
        {
            player.closeActiveWindow();
            gui.openMainOverlay(player);
            return true;
        } else
        {
            return false;
        }
    }
}