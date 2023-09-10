package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import model.DNA;
import view.PanelSitios;

public class ControllerButton implements ActionListener {
	private JLabel label;
	PanelSitios ps;
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
			List<DNA> arrDNA = new ArrayList<DNA>();
			if(res == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				int y = 10;
				ControllerArquivos controllerArq = new ControllerArquivos(file);
				try {
					PanelSitios.getTitleFile().setText(file.getName());
					//lerArquivo(file);
					if(file.getName().endsWith("fas")) {
						arrDNA = controllerArq.lerArquivoFas();
						//controllerArq.lerArquivo();
						
						for(int i=0; i<arrDNA.size(); i++) {
							label = new JLabel("especie: " + arrDNA.get(i).getTaxon() + "\n" + "base: " + arrDNA.get(i).getBase());
							label.setBounds(0, y+=10, 200, 50);
							PanelSitios.getTableArea().add(label); //adicionando labels a tela
							PanelSitios.getTableArea().revalidate();
							PanelSitios.getTableArea().repaint();
							System.out.println("especie: " + arrDNA.get(i).getTaxon() + "\n" + "base: " + arrDNA.get(i).getBase());
						}
					}
					if(file.getName().endsWith("nex")) {
						arrDNA = controllerArq.lerArquivoNex();
						for(int i=0; i<arrDNA.size(); i++) {
							System.out.println("especie: " + arrDNA.get(i).getTaxon() + "\n" + "base: " + arrDNA.get(i).getBase());
						}
					}
					if(file.getName().endsWith("phy")) {
						controllerArq.lerArquivoPhy();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		
	
		
	}
	
	
	

}
