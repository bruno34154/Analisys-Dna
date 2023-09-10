package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class PanelSitios extends JPanel {
	   private static final long serialVersionUID = 1L;
	   private static JLabel tableArea = null;
	   private static JLabel titleFile;
	   private static JButton  botaoEscolherArquivo = null;
		public PanelSitios() {
			super();
			setLayout(null);
			
			add(getTitleFile());
			add(getTableArea());
			add(getBotaoEscolherArquivo());
			setVisible(true);
			
			
		}
		
		public static JButton getBotaoEscolherArquivo() {
			if(botaoEscolherArquivo == null) {
				botaoEscolherArquivo = new JButton("Escolher Arquivo: ");
				botaoEscolherArquivo.setBounds(10, 100, 200, 30);
			}
			return botaoEscolherArquivo;
		}
		public static JLabel getTableArea() {
			if(tableArea == null) {
				tableArea = new JLabel();
				tableArea.setBounds(250, 100, 590, 500);
				tableArea.setBorder(BorderFactory.createLineBorder(Color.black));
				
			}
			return tableArea;
		}
		
		public static JLabel getTitleFile() {
			if(titleFile == null) {
				titleFile = new JLabel("Selecione um Arquivo");
				titleFile.setBounds(10, 150, 200, 30);
			}
			return titleFile;
		}
}
