package me.flayan.spoutinfo;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;

public class SpoutInfoScreenListener extends ScreenListener{

	@Override
	public void onButtonClick(ButtonClickEvent event) {
		if (event.getButton() instanceof SpoutInfoGenericButton) {
			SpoutInfoGenericButton button = (SpoutInfoGenericButton) event.getButton();
			if (button.getID() == 1) {
				event.getPlayer().getMainScreen().closePopup();
			}
		}
	}
}
