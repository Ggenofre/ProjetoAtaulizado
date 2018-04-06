package model;

import java.util.ArrayList;

public class Olimpiadas {
	private int id_ano; 
	private String tipo;
	
	//get e set
	public int getid_Ano() {
		return id_ano;
	}
	public void setid_Ano(int id_ano) {
		this.id_ano = id_ano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Olimpiadas other = (Olimpiadas) obj;
		if (id_ano != other.id_ano)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	public Olimpiadas() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	ArrayList <Modalidade> mode = new ArrayList<>();
}
