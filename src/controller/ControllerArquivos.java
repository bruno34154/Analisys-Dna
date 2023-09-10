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
	
	public List<DNA>  lerArquivoFas() throws IOException {
		List<DNA> arrDna = new ArrayList<DNA>();
		
		BufferedReader BuffRead;
		BuffRead = new BufferedReader(new FileReader(caminho));
		String linha = "";
		String taxon = "";
		while(true) {
			DNA dna = new DNA("", "");		
			if(linha != null ) {
				if(caminho.getName().endsWith("fas")) {
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
				    	System.out.println(linha);
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
	public List<DNA> lerArquivoNex() throws IOException {
		List<DNA> arrDna = new ArrayList<DNA>();
		
		BufferedReader BuffRead;
		BuffRead = new BufferedReader(new FileReader(caminho));
		String linha = "";
		String taxon = "";
		String base = "";
		Boolean key = false;
		String arrLinha[];
		
		while(true) {	
			DNA dna = new DNA("", "");	
			if(linha != null ) {
				
				if(linha.startsWith("End;") || linha.startsWith("END;") || linha.contains(";")) {
		    		key = false;
		    	}
				
				if(key == true) {
					arrLinha = linha.split("");
					for(int i = 0; i<arrLinha.length-1; i++) {
						if(arrLinha[i].toUpperCase().equals(arrLinha[i]) && arrLinha[i + 1].toUpperCase().equals(arrLinha[i + 1])) {
							base = base + arrLinha[i];
						}
						else {
							taxon = taxon + arrLinha[i];
						}
						
					}
					dna.setTaxon(taxon);
					dna.setBase(base);
					arrDna.add(dna);
					
				}
				if(linha.contains("Matrix")) {
					key = true;
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
	
	public void lerArquivoPhy() throws IOException {
		List<DNA> arrDna = new ArrayList<DNA>();
		
		BufferedReader BuffRead;
		BuffRead = new BufferedReader(new FileReader(caminho));
		String linha = "";
		String taxon = "";
		String base = "";
		Boolean key = false;
		String arrLinha[];
		
		while(true) {	
			DNA dna = new DNA("", "");	
			if(linha != null ) {
				
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
