package me.flayan.spoutinfo;

import me.flayan.spoutinfo.SpoutInfoInputListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;
import org.getspout.spoutapi.gui.*;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpoutInfo extends JavaPlugin{
	
	private CommandListener cmdListener;
	private GenericPopup popup;
	private SpoutInfo plugin;
	public Configuration config;
	
	public SpoutInfo(){
		cmdListener = new CommandListener(this);
	}
	
	public void onEnable() {
		setupConfig();
		getServer().getPluginManager().registerEvent(Type.CUSTOM_EVENT, new SpoutInfoInputListener(), Priority.Normal, this);
		getServer().getPluginManager().registerEvent(Type.CUSTOM_EVENT, new SpoutInfoScreenListener(), Priority.Normal, this);
		//getServer().getPluginManager().registerEvent(Type.CUSTOM_EVENT, new SpoutInfoGenericButton(), Priority.Normal, this);
        System.out.println(this + " is now enabled!");
    }
	
	public void onDisable(){
		System.out.println(this + " is now disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
    {
        return cmdListener.onCommand(sender, cmd, label, args);
    }
	
	public void openOverlay(SpoutPlayer player){
		popup = new GenericPopup();
		
		popup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericLabel").setHexColor(0xFFFFFF).setAlignY(Align.FIRST)).setAlignX(Align.FIRST).setX(0).setY(0).setHeight(240).setWidth(427));
		popup.attachWidget(plugin, ((GenericLabel) new GenericLabel(config.getString("label.text")).setHexColor(Integer.parseInt(config.getString("label.color"), 16))
				.setAlignY(Align.FIRST)).setAlignX(Align.FIRST).setX(5).setY(20).setHeight(240).setWidth(427));
		popup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(1).setX(5).setY(40)));
		
		popup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericButton").setHexColor(0xFFFFFF).setAlignY(Align.FIRST)).setAlignX(Align.SECOND).setX(0).setY(0).setHeight(240).setWidth(427));
		popup.attachWidget(plugin, ((GenericButton) new GenericButton(config.getString("button.text")).setColor(Integer.parseInt(config.getString("button.color"), 16)))
				.setHoverColor(Integer.parseInt(config.getString("button.hovercolor"), 16)).setX((427/2)-(config.getInt("button.width", 100)/2)).setY(20).setHeight(config.getInt("button.height", 10)).setWidth(config.getInt("button.width", 80)));
		popup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(2).setX(427/2-(60/2)).setY(40)));
		
		popup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericTextField").setHexColor(0xFFFFFF).setAlignY(Align.FIRST)).setAlignX(Align.THIRD).setX(0).setY(0).setHeight(240).setWidth(427));
		popup.attachWidget(plugin, ((GenericTextField) new GenericTextField().setX(427-105).setY(20).setHeight(config.getInt("textfield.height", 10)).setWidth(config.getInt("textfield.width", 100))));
		popup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(3).setX(350).setY(40)));
		
		popup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericContainer").setHexColor(0xFFFFFF).setAlignY(Align.SECOND)).setAlignX(Align.FIRST).setX(0).setY(0).setHeight(240).setWidth(427));
		//popup.attachWidget(plugin, ((GenericContainer) new GenericContainer().setX(5).setY(240/2+40).setHeight(50).setWidth(50)));
		popup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(4).setX(5).setY(240/2+20)));
		
		popup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericSlider").setHexColor(0xFFFFFF).setAlignY(Align.SECOND)).setAlignX(Align.SECOND).setX(0).setY(0).setHeight(240).setWidth(427));
		popup.attachWidget(plugin, ((GenericSlider) new GenericSlider()).setX(427/2-(config.getInt("slider.width", 100)/2)).setY(240/2+20).setHeight(config.getInt("slider.height", 10)).setWidth(config.getInt("slider.width", 100)));
		popup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(5).setX(427/2-(60/2)).setY(240/2+40)));
		
		popup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericTexture").setHexColor(0xFFFFFF).setAlignY(Align.SECOND)).setAlignX(Align.THIRD).setX(0).setY(0).setHeight(240).setWidth(427));
		popup.attachWidget(plugin, (GenericTexture) new GenericTexture().setUrl(config.getString("texture.url", "http://dl.dropbox.com/u/7238554/generictexture.png"))
				.setHeight(config.getInt("texture.height", 32)).setWidth(config.getInt("texture.width", 32)).setX(350).setY(130));
		popup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(6).setX(427-80).setY(240/2+60)));
		
		popup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericItemWidget").setHexColor(0xFFFFFF).setAlignY(Align.THIRD)).setAlignX(Align.FIRST).setX(50).setY(0).setHeight(240));
		popup.attachWidget(plugin, ((GenericItemWidget) new GenericItemWidget().setTypeId(config.getInt("itemwidget.type", 14)).setDepth(config.getInt("itemwidget.size", 20))
				.setTooltip("test").setHeight(config.getInt("itemwidget.size", 20)).setWidth(config.getInt("itemwidget.size", 20)).setX(((427/2)/2)-20).setY(240-40)));
		popup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(7).setX(((427/2)/2)-40).setY(240-60)));
		
		player.getMainScreen().attachPopupScreen(popup);
	}
	
	public void setupConfig(){
		config = this.getConfiguration();
		config.setHeader("#Config for SpoutInfo");
	    config.getString("label.text", "This is a label");
	    config.getString("label.color", "FFFFFF");
	    config.getString("button.text", "This is a button");
	    config.getString("button.color", "FFFFFF");
	    config.getString("button.hovercolor", "FFFFFF");
	    config.getInt("button.height", 10);
	    config.getInt("button.width", 100);
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
