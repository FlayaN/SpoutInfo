package me.flayan.spoutinfo;

import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;;

public class SpoutInfoGenericButton extends GenericButton implements SpoutInfoButton{
	protected int id = 0;
	public SpoutInfoGenericButton(){
		super();
		this.setText("More info..").setHeight(6).setWidth(60);
	}
	public Button setID(int id){
		this.id = id;
		return this;
	}
	public int getID(){
		return this.id;
	}
}
