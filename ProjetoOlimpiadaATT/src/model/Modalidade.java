package model;

public class Modalidade {
	private int id;
	private String nome; 
	private int ouro;
	private int prata; 
	private int bronze;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getOuro() {
		return ouro;
	}
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}
	public int getPrata() {
		return prata;
	}
	public void setPrata(int prata) {
		this.prata = prata;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	} 
	
	@Override
	public String toString() {
		return "Modalidade [nome=" + nome + ", ouro=" + ouro + ", prata=" + prata + ", bronze=" + bronze + "]";
	}
	
	public Modalidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
