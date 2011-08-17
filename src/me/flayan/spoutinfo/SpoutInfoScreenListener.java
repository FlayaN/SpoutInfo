package me.flayan.spoutinfo;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.flayan.spoutinfo.SpoutInfoGUI;
import me.flayan.spoutinfo.SpoutInfo;

public class SpoutInfoScreenListener extends ScreenListener{
	private SpoutInfo plugin;
	private SpoutInfoGUI gui = new SpoutInfoGUI(plugin);
	@Override
	public void onButtonClick(ButtonClickEvent event) {
		if (event.getButton() instanceof SpoutInfoGenericButton) {
			SpoutInfoGenericButton button = (SpoutInfoGenericButton) event.getButton();
			if (button.getID() == 1) {
				//event.getPlayer().getMainScreen().closePopup();
				SpoutPlayer splayer = (SpoutPlayer) event.getPlayer();
				gui.openLabelOverlay(splayer);
			}
		}
	}
}
