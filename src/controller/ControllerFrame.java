package controller;

import view.Frame;
import view.PanelSitios;

public class ControllerFrame {
	static PanelSitios ps;
	static Frame frame = new Frame();
	public  ControllerFrame(){
		frame.validate();
		frame.repaint();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ps = new PanelSitios();
		frame.setContentPane(ps);
		new ControllerButton();
	}

}
