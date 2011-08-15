package me.flayan.spoutinfo;

import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.keyboard.Keyboard;

public class SpoutInfoInputListener extends InputListener {
	
	@Override
	public void onKeyPressedEvent(KeyPressedEvent event) {
		if (event.getKey() == Keyboard.KEY_ESCAPE) {
			event.getPlayer().getMainScreen().closePopup();
		}
	}
}
