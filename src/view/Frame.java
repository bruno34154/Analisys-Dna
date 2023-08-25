package view;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame() {
		super();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(0,0);
		this.setSize(800, 800);
		this.setTitle("Computação cientifica");
		repaint();
		validate();
	}
}
