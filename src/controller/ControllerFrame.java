package controller;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

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
		JScrollPane scroll = new JScrollPane(ps);
		scroll.setSize(1100, 700);
		scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.setContentPane(scroll);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		new ControllerButton();
	}

}
