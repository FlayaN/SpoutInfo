package me.flayan.spoutinfo;

import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericGradient;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericSlider;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.flayan.spoutinfo.SpoutInfo;

public class SpoutInfoGUI {
	private SpoutInfo plugin;
	public GenericPopup mainpopup;
	public GenericPopup labelpopup;

	public SpoutInfoGUI(SpoutInfo spoutinfo){
		plugin = spoutinfo;
	}
    
	public void openMainOverlay(SpoutPlayer player){
		mainpopup = new GenericPopup();

		mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericLabel").setHexColor(0xFFFFFF).setAnchor(WidgetAnchor.TOP_LEFT)));
		mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel(plugin.config.getString("label.text")).setHexColor(Integer.parseInt(plugin.config.getString("label.color"), 16)).setAnchor(WidgetAnchor.TOP_LEFT).shiftXPos(5).shiftYPos(20)));
		mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(1).setAnchor(WidgetAnchor.TOP_LEFT).shiftXPos(5).shiftYPos(40)));

		mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericButton").setHexColor(0xFFFFFF).setAnchor(WidgetAnchor.TOP_CENTER)));
		mainpopup.attachWidget(plugin, ((GenericButton) new GenericButton(plugin.config.getString("button.text")).setColor(Integer.parseInt(plugin.config.getString("button.color"), 16))).setHoverColor(Integer.parseInt(plugin.config.getString("button.hovercolor"), 16)).setAnchor(WidgetAnchor.TOP_CENTER).shiftYPos(20).setHeight(plugin.config.getInt("button.height", 20)).setWidth(plugin.config.getInt("button.width", 200)));
		mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(2).setAnchor(WidgetAnchor.TOP_CENTER).shiftYPos(40)));

		mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericTextField").setHexColor(0xFFFFFF).setAnchor(WidgetAnchor.TOP_RIGHT)));
		mainpopup.attachWidget(plugin, ((GenericTextField) new GenericTextField().setAnchor(WidgetAnchor.TOP_RIGHT).shiftXPos(-5).shiftYPos(20).setHeight(plugin.config.getInt("textfield.height", 10)).setWidth(plugin.config.getInt("textfield.width", 100))));
		mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(3).setAnchor(WidgetAnchor.TOP_RIGHT).shiftXPos(-5).shiftYPos(40)));

		mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericGradient").setHexColor(0xFFFFFF).setAnchor(WidgetAnchor.CENTER_LEFT)));
		mainpopup.attachWidget(plugin, ((GenericGradient) new GenericGradient().setTopColor(new Color(0,0,1.0F,0.75F)).setBottomColor(new Color(1.0F, 0, 0, 0.75F)).setAnchor(WidgetAnchor.CENTER_LEFT).shiftXPos(10).shiftYPos(20).setHeight(32).setWidth(32)));
		mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(4).setAnchor(WidgetAnchor.CENTER_LEFT).shiftXPos(5).shiftYPos(60)));

		mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericSlider").setHexColor(0xFFFFFF).setAnchor(WidgetAnchor.CENTER_CENTER)));
		mainpopup.attachWidget(plugin, ((GenericSlider) new GenericSlider()).setAnchor(WidgetAnchor.CENTER_CENTER).shiftYPos(20).setHeight(plugin.config.getInt("slider.height", 10)).setWidth(plugin.config.getInt("slider.width", 100)));
		mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(5).setAnchor(WidgetAnchor.CENTER_CENTER).shiftYPos(40)));

		mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericTexture").setHexColor(0xFFFFFF).setAnchor(WidgetAnchor.CENTER_RIGHT)));
		mainpopup.attachWidget(plugin, (GenericTexture) new GenericTexture().setUrl(plugin.config.getString("texture.url", "http://dl.dropbox.com/u/7238554/generictexture.png")).setHeight(plugin.config.getInt("texture.height", 32)).setWidth(plugin.config.getInt("texture.width", 32)).setAnchor(WidgetAnchor.CENTER_RIGHT).shiftXPos(-50).shiftYPos(20));
		mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(6).setAnchor(WidgetAnchor.CENTER_RIGHT).shiftXPos(-5).shiftYPos(50)));

		mainpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("GenericItemWidget").setHexColor(0xFFFFFF).setAnchor(WidgetAnchor.BOTTOM_LEFT).shiftXPos(100)));
		mainpopup.attachWidget(plugin, ((GenericItemWidget) new GenericItemWidget().setTypeId(plugin.config.getInt("itemwidget.type", 14)).setDepth(plugin.config.getInt("itemwidget.size", 20)).setTooltip("test").setHeight(plugin.config.getInt("itemwidget.size", 20)).setWidth(plugin.config.getInt("itemwidget.size", 20)).setAnchor(WidgetAnchor.BOTTOM_LEFT).shiftXPos(100).shiftYPos(-40)));
		mainpopup.attachWidget(plugin, ((SpoutInfoGenericButton) new SpoutInfoGenericButton().setID(7).setAnchor(WidgetAnchor.BOTTOM_LEFT).shiftXPos(100).shiftYPos(-60)));
		player.getMainScreen().attachPopupScreen(mainpopup);
	}
	public void openLabelOverlay(SpoutPlayer player){
		player.getMainScreen().closePopup();
		labelpopup = new GenericPopup();
		labelpopup.attachWidget(plugin, ((GenericLabel) new GenericLabel("Title").setAlign(WidgetAnchor.TOP_CENTER)).setWidth(100).setHeight(10));
		player.getMainScreen().attachPopupScreen(labelpopup);
	}
}