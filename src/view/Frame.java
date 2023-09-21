package view;

import javax.swing.JFrame;

public class  Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(0,0);
		this.setSize(1200, 1000);
		this.setResizable(true);
		this.setTitle("Computação cientifica");
		
		this.setVisible(true);
	}
}
