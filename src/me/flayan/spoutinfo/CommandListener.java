package me.flayan.spoutinfo;

import me.flayan.spoutinfo.SpoutInfo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CommandListener {
	private SpoutInfo plugin;
	private SpoutInfoGUI gui;

    public CommandListener(SpoutInfo spoutinfo){
    	plugin = spoutinfo;
    	gui = new SpoutInfoGUI(plugin);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
    	SpoutPlayer player = (SpoutPlayer)sender;
    	if ((player == sender) && (!sender.hasPermission("scrapbukkit.remove.self"))) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to show the gui");
            return true;
        }
    	if(cmd.getName().equals("spoutinfo")){
    		player.closeActiveWindow();
    		gui.openMainOverlay(player);
    		return true;
    	} else{
    		return false;
    	}
	}
}