package me.flayan.spoutinfo;

import org.getspout.spoutapi.gui.Align;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericSlider;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.flayan.spoutinfo.SpoutInfo;

public class SpoutInfoGUI
{
	private SpoutInfo plugin;

    public SpoutInfoGUI(SpoutInfo spoutinfo)
    {
    	plugin = spoutinfo;
    }
    
    public void openMainOverlay(SpoutPlayer player){
    	plugin.mainpopup = new GenericPopup();

    	plugin.mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericLabel").setHexColor(0xFFFFFF).setAlignY(Align.FIRST)).setAlignX(Align.FIRST).setX(0).setY(0).setHeight(240).setWidth(427));
    	plugin.mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel(plugin.config.getString("label.text")).setHexColor(Integer.parseInt(plugin.config.getString("label.color"), 16))
				.setAlignY(Align.FIRST)).setAlignX(Align.FIRST).setX(5).setY(20).setHeight(240).setWidth(427));
    	plugin.mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(1).setX(5).setY(40)));

    	plugin.mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericButton").setHexColor(0xFFFFFF).setAlignY(Align.FIRST)).setAlignX(Align.SECOND).setX(0).setY(0).setHeight(240).setWidth(427));
		plugin.mainpopup.attachWidget(plugin, ((GenericButton) new GenericButton(plugin.config.getString("button.text")).setColor(Integer.parseInt(plugin.config.getString("button.color"), 16)))
				.setHoverColor(Integer.parseInt(plugin.config.getString("button.hovercolor"), 16)).setX((427/2)-(plugin.config.getInt("button.width", 100)/2)).setY(20).setHeight(plugin.config.getInt("button.height", 10)).setWidth(plugin.config.getInt("button.width", 80)));
		plugin.mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(2).setX(427/2-(60/2)).setY(40)));

		plugin.mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericTextField").setHexColor(0xFFFFFF).setAlignY(Align.FIRST)).setAlignX(Align.THIRD).setX(0).setY(0).setHeight(240).setWidth(427));
		plugin.mainpopup.attachWidget(plugin, ((GenericTextField) new GenericTextField().setX(427-105).setY(20).setHeight(plugin.config.getInt("textfield.height", 10)).setWidth(plugin.config.getInt("textfield.width", 100))));
		plugin.mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(3).setX(350).setY(40)));

		plugin.mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericContainer").setHexColor(0xFFFFFF).setAlignY(Align.SECOND)).setAlignX(Align.FIRST).setX(0).setY(0).setHeight(240).setWidth(427));
		//mainpopup.attachWidget(plugin, ((GenericContainer) new GenericContainer().setX(5).setY(240/2+40).setHeight(50).setWidth(50)));
		plugin.mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(4).setX(5).setY(240/2+20)));

		plugin.mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericSlider").setHexColor(0xFFFFFF).setAlignY(Align.SECOND)).setAlignX(Align.SECOND).setX(0).setY(0).setHeight(240).setWidth(427));
		plugin.mainpopup.attachWidget(plugin, ((GenericSlider) new GenericSlider()).setX(427/2-(plugin.config.getInt("slider.width", 100)/2)).setY(240/2+20).setHeight(plugin.config.getInt("slider.height", 10)).setWidth(plugin.config.getInt("slider.width", 100)));
		plugin.mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(5).setX(427/2-(60/2)).setY(240/2+40)));

		plugin.mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericTexture").setHexColor(0xFFFFFF).setAlignY(Align.SECOND)).setAlignX(Align.THIRD).setX(0).setY(0).setHeight(240).setWidth(427));
		plugin.mainpopup.attachWidget(plugin, (GenericTexture) new GenericTexture().setUrl(plugin.config.getString("texture.url", "http://dl.dropbox.com/u/7238554/generictexture.png"))
				.setHeight(plugin.config.getInt("texture.height", 32)).setWidth(plugin.config.getInt("texture.width", 32)).setX(350).setY(130));
		plugin.mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(6).setX(427-80).setY(240/2+60)));

		plugin.mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericItemWidget").setHexColor(0xFFFFFF).setAlignY(Align.THIRD)).setAlignX(Align.FIRST).setX(50).setY(0).setHeight(240));
		plugin.mainpopup.attachWidget(plugin, ((GenericItemWidget) new GenericItemWidget().setTypeId(plugin.config.getInt("itemwidget.type", 14)).setDepth(plugin.config.getInt("itemwidget.size", 20))
				.setTooltip("test").setHeight(plugin.config.getInt("itemwidget.size", 20)).setWidth(plugin.config.getInt("itemwidget.size", 20)).setX(((427/2)/2)-20).setY(240-40)));
		plugin.mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(7).setX(((427/2)/2)-40).setY(240-60)));

		player.getMainScreen().attachPopupScreen(plugin.mainpopup);
	}
    
}