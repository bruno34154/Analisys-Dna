package controller;

import view.Frame;
import view.PanelSitios;

public class ControllerFrame {
	static PanelSitios ps;
	
	public  ControllerFrame(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		ps = new PanelSitios();
		frame.setContentPane(ps);
		new ControllerButton();
	}

}
