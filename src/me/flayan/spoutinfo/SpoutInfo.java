package me.flayan.spoutinfo;

import me.flayan.spoutinfo.SpoutInfoInputListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class SpoutInfo extends JavaPlugin{

	private CommandListener cmdListener;
	public Configuration config;

	public SpoutInfo(){
		cmdListener = new CommandListener(this);
	}

	public void onEnable() {
		setupConfig();
		getServer().getPluginManager().registerEvent(Type.CUSTOM_EVENT, new SpoutInfoInputListener(), Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Type.CUSTOM_EVENT, new SpoutInfoScreenListener(), Priority.Normal, this);
		System.out.println(this + " is now enabled!");
	}

	public void onDisable(){
		System.out.println(this + " is now disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		return cmdListener.onCommand(sender, cmd, label, args);
	}

	public void setupConfig(){
		config = this.getConfiguration();
		config.setHeader("#Config for SpoutInfo");
		config.getString("label.text", "This is a label");
		config.getString("label.color", "FFFFFF");
		config.getString("button.text", "This is a button");
		config.getString("button.color", "FFFFFF");
		config.getString("button.hovercolor", "FFFFFF");
		config.getInt("button.height", 20);
		config.getInt("button.width", 200);
		config.getInt("textfield.height", 10);
		config.getInt("textfield.width", 100);
		config.getInt("slider.height", 10);
		config.getInt("slider.width", 100);
		config.getString("texture.url", "http://dl.dropbox.com/u/7238554/generictexture.png");
		config.getInt("texture.height", 32);
		config.getInt("texture.width", 32);
		config.getInt("itemwidget.type", 14);
		config.getInt("itemwidget.size", 20);
		config.save();
	}
}