package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import model.DNA;
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
			List<DNA> arrDNA = new ArrayList<DNA>();
			if(res == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				ControllerArquivos controllerArq = new ControllerArquivos(file);
				try {
					
					//lerArquivo(file);
					arrDNA = controllerArq.lerArquivo();
					
					for(int i=0; i<arrDNA.size(); i++) {
						System.out.println("especie: " + arrDNA.get(i).getTaxon() + "\n" + "base: " + arrDNA.get(i).getBase());
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		
	
		
	}
	
	private void lerArquivo(File caminho) throws IOException {
		BufferedReader BuffRead;
		BuffRead = new BufferedReader(new FileReader(caminho));
		String linha = "";
		while(true) {
			if(linha != null) {
				System.out.println(linha);
			}
			else {
				break;
			}
			linha = BuffRead.readLine();
			
		}
		BuffRead.close();
		
		
	}
	

}
