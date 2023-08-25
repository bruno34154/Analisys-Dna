package view;

import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class PanelSitios extends JPanel {
	   private static final long serialVersionUID = 1L;
	private JFileChooser fileChooser;
	   private JPanel panel;
	   private static JButton  botaoEscolherArquivo = null;
		public PanelSitios() {
			super();
			this.setLayout(null);
			
			/*JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(402, 158, 46, 584);*/
			
			
			this.add(getBotaoEscolherArquivo());
			
		}
		
		public static JButton getBotaoEscolherArquivo() {
			if(botaoEscolherArquivo == null) {
				botaoEscolherArquivo = new JButton("Escolher Arquivo: ");
				botaoEscolherArquivo.setBounds(10, 100, 200, 30);
			}
			return botaoEscolherArquivo;
		}
		
}
