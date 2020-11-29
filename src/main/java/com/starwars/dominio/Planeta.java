package com.starwars.dominio;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planetas")
public class Planeta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	private String clima;
	private String terreno;
		
	public Planeta() {
		
	}

	public Planeta(String id, String nome, String clima, String terreno) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getClima() {
		return clima;
	}
	
	public String getTerreno() {
		return terreno;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planeta other = (Planeta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
