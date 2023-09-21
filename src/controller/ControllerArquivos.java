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
		String arrLinha[];
		while(true) {
			DNA dna = new DNA("", "");		
			int tamanho = 0;
			if(linha != null ) {
				if(caminho.getName().endsWith("fas")) {
						
						if(linha.startsWith(">")) {
							taxon= "";
							taxon = linha;
						}
						else{
							arrLinha = linha.split("");
							for(int i = 0; i<arrLinha.length-1; i++) {
								tamanho++;
							}
							dna.setTaxon(taxon);
							dna.setBase(linha);
							dna.setTamanho(tamanho);
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
			int tamanho = 0;
			if(linha != null ) {
				
				if(linha.startsWith("End;") || linha.startsWith("END;") || linha.contains(";")) {
		    		key = false;
		    	}
				
				if(key == true) {
					arrLinha = linha.split("");
					for(int i = 0; i<arrLinha.length-1; i++) {
						
						if(arrLinha[i].toUpperCase().equals(arrLinha[i]) && arrLinha[i + 1].toUpperCase().equals(arrLinha[i + 1]) || arrLinha[i].matches("\\d")) {
							tamanho++;
							base = base + arrLinha[i];
						}
						else {
							taxon = taxon + arrLinha[i];
						}
						
					}
					dna.setTaxon(taxon);
					dna.setBase(base);
					dna.setTamanho(tamanho);
					arrDna.add(dna);
					taxon = "";
					
				}
				if(linha.contains("Matrix") || linha.startsWith("MATRIX")) {
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
	
	@SuppressWarnings("null")
	public List<DNA>  lerArquivoPhy() throws IOException {
		List<DNA> arrDna = new ArrayList<DNA>();
		
		BufferedReader BuffRead;
		BuffRead = new BufferedReader(new FileReader(caminho));
		String linha = "";
		String taxon = "";
		String base = "";
		Boolean key = false;
		List <String> arrTaxon  = new ArrayList<String>();
		List<String> arrBase = new ArrayList<String>(); 
		List<Integer> arrTamanho = new ArrayList<Integer>(); 
		
		int cont = 0;
		 String arrLinha[];
		
		
		while(true) {	
			int tamanho = 0;
			DNA dna = new DNA("", "");	
			if(linha != null ) {
				arrLinha = linha.split("");
				if(key == true) {
					//System.out.println(linha);
				for(int i = 0; i<arrLinha.length-1; i++) {
					tamanho++;
					if(linha.startsWith("P")) {
						taxon = arrLinha[0] + arrLinha[1];
						
					}
					else {
						base = base + arrLinha[i];
						
					}
					
				}
				if(linha.startsWith("P")) {
					arrBase.add(base);
					arrTaxon.add(taxon);
					arrTamanho.add(tamanho);
					
				}
				else {
					if(cont > 5) {
						cont = 0;
					}
					arrBase.add(cont, arrBase.get(cont) + base);
					cont++;	
				}
				}
				if(linha.contains("6 ")) {
					key = true;
				}
				
				
				
				
			}
			
			else {
				
				break;
			}
			linha = BuffRead.readLine();
		}
		BuffRead.close();
		for(int j = 0; j<arrTaxon.size(); j++) {
			DNA dna = new DNA("", "");
			System.out.println("especie " + arrTaxon.get(j) + "\n base: " + arrBase.get(j));
			dna.setTaxon(arrTaxon.get(j));
			dna.setBase(arrBase.get(j));
			dna.setTamanho(arrTamanho.get(j));
			arrDna.add(dna);
		}
		return arrDna;
	}
	
	
	
}
