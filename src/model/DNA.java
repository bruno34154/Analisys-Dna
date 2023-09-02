package model;

public class DNA {
	private String taxon;
	private String base;
	public DNA(String taxon, String base) {
		this.base = base;
		this.taxon = taxon;
	}
	public String getTaxon() {
		return taxon;
	}
	public void setTaxon(String taxon) {
		this.taxon = taxon;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	
	
}
