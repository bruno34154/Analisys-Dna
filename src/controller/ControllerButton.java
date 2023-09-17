package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.DNA;
import view.PanelSitios;

public class ControllerButton implements ActionListener {
	private JTextArea label;
	Boolean wordsInScreen = false;
	ArrayList<JTextArea> labels = new ArrayList<JTextArea>();
	PanelSitios ps;
	public ControllerButton() {
		PanelSitios.getBotaoEscolherArquivo().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(wordsInScreen) {//limpando labels antigos da tela
			for(int i=0; i<labels.size();i++) {
				PanelSitios.getTableArea().remove(labels.get(i));
			}
			labels.clear();
			
		}
		wordsInScreen = true;
		if(e.getSource() == PanelSitios.getBotaoEscolherArquivo()) {
			
			JFileChooser fc = new JFileChooser();
			//abri o fileChosser em aba separadas
			int res = fc.showOpenDialog(null);
			List<DNA> arrDNA = new ArrayList<DNA>();
			if(res == JFileChooser.APPROVE_OPTION) {
				
				File file = fc.getSelectedFile();
				int y = 10;
				Boolean color1 = true;
				Boolean color2 = false;
				Boolean aux;
				ControllerArquivos controllerArq = new ControllerArquivos(file);
				try {
					PanelSitios.getTitleFile().setText(file.getName());
					//lerArquivo(file);
					if(file.getName().endsWith("fas")) {
						arrDNA = controllerArq.lerArquivoFas();
						//controllerArq.lerArquivo();
						
						for(int i=0; i<arrDNA.size(); i++) {
							label = new JTextArea();
							label.setText("especie: " + arrDNA.get(i).getTaxon() + " base: " + arrDNA.get(i).getBase());
							label.setBounds(20, y, 1150, 100);
							label.setEditable(false);
							if(color2 == true) {
								label.setBackground(Color.gray);
								label.setForeground(Color.white);
							}
							label.setLineWrap(true);
							JScrollPane scroll = new JScrollPane(label);
							scroll.setBounds(10, y, 1050, 70);
							y+=100;
							PanelSitios.getTableArea().add(label); //adicionando labels a tela
							PanelSitios.getTableArea().revalidate();
							PanelSitios.getTableArea().repaint();
							System.out.println("especie: " + arrDNA.get(i).getTaxon() + "\n" + "base: " + arrDNA.get(i).getBase());
							aux = color2;
							color2 = color1;
							color1 = aux;
							labels.add(label);
							
						}
					}
					if(file.getName().endsWith("nex")) {
						arrDNA = controllerArq.lerArquivoNex();
						for(int i=0; i<arrDNA.size(); i++) {
							label = new JTextArea();
							label.setText("especie: " + arrDNA.get(i).getTaxon() + " base: " + arrDNA.get(i).getBase());
							label.setBounds(10, y, 1150, 100);
							label.setEditable(false);
							
							if(color2 == true) {
								label.setBackground(Color.gray);
								label.setForeground(Color.white);
							}
							label.setLineWrap(true);
							JScrollPane scroll = new JScrollPane(label);
							scroll.setBounds(20, y, 1050, 70);
							y+=100;
							PanelSitios.getTableArea().add(label); //adicionando labels a tela
							PanelSitios.getTableArea().revalidate();
							PanelSitios.getTableArea().repaint();
							System.out.println("especie: " + arrDNA.get(i).getTaxon() + "\n" + "base: " + arrDNA.get(i).getBase());
							aux = color2;
							color2 = color1;
							color1 = aux;
							labels.add(label);
						}
					}
					if(file.getName().endsWith("phy")) {
						arrDNA = controllerArq.lerArquivoPhy();
						for(int i=0; i<arrDNA.size(); i++) {
							label = new JTextArea();
							label.setText("especie: " + arrDNA.get(i).getTaxon() + " base: " + arrDNA.get(i).getBase());
							label.setBounds(10, y, 1150, 100);
							label.setEditable(false);
							
							if(color2 == true) {
								label.setBackground(Color.gray);
								label.setForeground(Color.white);
							}
							label.setLineWrap(true);
							JScrollPane scroll = new JScrollPane(label);
							scroll.setBounds(20, y, 1050, 70);
							y+=100;
							PanelSitios.getTableArea().add(label); //adicionando labels a tela
							PanelSitios.getTableArea().revalidate();
							PanelSitios.getTableArea().repaint();
							System.out.println("especie: " + arrDNA.get(i).getTaxon() + "\n" + "base: " + arrDNA.get(i).getBase());
							aux = color2;
							color2 = color1;
							color1 = aux;
							labels.add(label);
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		
	
		
	}
	
	
	

}
