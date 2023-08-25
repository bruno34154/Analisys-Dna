package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import view.PanelSitios;

public class ControllerButton implements ActionListener {
	
	public ControllerButton() {
		PanelSitios.getBotaoEscolherArquivo().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == PanelSitios.getBotaoEscolherArquivo()) {
			JFileChooser fc = new JFileChooser();
			//abri o fileChosser em aba separadas
			int res = fc.showOpenDialog(null);
			if(res == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				System.out.println("escolheu o diretorio: " + file.getName());
				
			}
		}
	
		System.out.println("clicou");
	}
}
