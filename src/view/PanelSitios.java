package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelSitios extends JPanel {
	   private static final long serialVersionUID = 1L;
	   private  static JPanel tableArea = null;
	   private static JLabel titleFile;
	   private static JButton  botaoEscolherArquivo = null;
	   private static JPanel panelSetings;
	   private  JScrollPane scroll;
	   private static JPanel panelResults;
	   private static JPanel panelText;
	   private static JLabel sequenceInformation;
	   private static JButton  botaoAlinhar = null;
	   private static JButton  botaoQuebraLinha = null;
	   
		public PanelSitios() {
			super();
			setLayout(new BorderLayout());
			add(getTableArea(), BorderLayout.CENTER);
			add(getPanelSetings(), BorderLayout.PAGE_START);
			add(getPanelText(), BorderLayout.PAGE_END);
			setVisible(true);
			
			
		}
		public JPanel getPanelResults() {
			if(panelResults == null) {
				panelResults = new JPanel();
				panelResults.add(getScrollPane());
			}
			return panelResults;
		}
		public  JScrollPane getScrollPane() {
			if(scroll == null) {
				scroll = new JScrollPane(getTableArea());
				scroll.setBounds(250, 0, 200, 200);
				scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			}
			return scroll;
		}
		public static JPanel getPanelSetings() {
			if(panelSetings == null) {
				panelSetings = new JPanel();
				//panelSetings.setLayout(new BorderLayout());
				//panelSetings.setBounds(0, 20, 500, 700);
				panelSetings.add(getBotaoEscolherArquivo());
				panelSetings.add(getTitleFile());
				panelSetings.add(getSequenceInformation());			
			}
			return panelSetings;
			
		}
		public static JPanel getPanelText() {
			if(panelText == null) {
				panelText = new JPanel();
				//panelSetings.setLayout(new BorderLayout());
				//panelSetings.setBounds(0, 20, 500, 700);
				panelText.add(getBotaoAlinhar());
				panelText.add(getBotaoQuebraLinha());
							
			}
			return panelText;
			
		}
		public static JButton getBotaoEscolherArquivo() {
			if(botaoEscolherArquivo == null) {
				botaoEscolherArquivo = new JButton("Escolher Arquivo: ");
				botaoEscolherArquivo.setBounds(10, 100, 200, 30);
				
			}
			return botaoEscolherArquivo;
		}
		public static JPanel getTableArea() {
			if(tableArea == null) {
				tableArea = new JPanel();
				tableArea.setLayout(null);
				/*JTextArea text = new JTextArea();
				text.setBounds(0, 100, 200, 200);
				tableArea.add(text);*/
				tableArea.setBounds(400, 100, 1200, 800);
				tableArea.setBorder(BorderFactory.createLineBorder(Color.black));
				
				
			}
			return tableArea;
		}
		
		public static JLabel getTitleFile() {
			if(titleFile == null) {
				titleFile = new JLabel("Selecione um Arquivo");
				titleFile.setBounds(10, 300, 200, 30);
			}
			return titleFile;
		}
		public static JLabel getSequenceInformation() {
			if(sequenceInformation == null) {
				sequenceInformation = new JLabel("");
				sequenceInformation.setBounds(10, 800, 200, 30);
			}
			return sequenceInformation;
		}
		public static JButton getBotaoAlinhar() {
			if(botaoAlinhar == null) {
				botaoAlinhar = new JButton("Alinhar");
				botaoAlinhar.setBounds(10, 100, 200, 30);
				
			}
			return botaoAlinhar;
		}
		public static JButton getBotaoQuebraLinha() {
			if(botaoQuebraLinha == null) {
				botaoQuebraLinha = new JButton("Quebrar Linha");
				botaoQuebraLinha.setBounds(10, 100, 200, 30);
				
			}
			return botaoQuebraLinha;
		}
}
