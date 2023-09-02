package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.DNA;


public class ControllerArquivos {
	private File caminho;
	public ControllerArquivos (File caminho){
		this.caminho = caminho;
	}
	
	public List<DNA> lerArquivo() throws IOException {
		List<DNA> arrDna = new ArrayList<DNA>();
		
		BufferedReader BuffRead;
		BuffRead = new BufferedReader(new FileReader(caminho));
		String linha = "";
		String taxon = "";
		while(true) {
			DNA dna = new DNA("", "");		
			if(linha != null ) {	
				if(linha.startsWith(">")) {
					taxon= "";
					taxon = linha;
				}
				else{
					dna.setTaxon(taxon);
					dna.setBase(linha);
					if(taxon != "") { // garante que nao vai pegar elementos nulos
						arrDna.add(dna);
					}	
				}
			}
			else {
				
				break;
			}
			linha = BuffRead.readLine();
		}
		BuffRead.close();
		return arrDna;
	}
}
