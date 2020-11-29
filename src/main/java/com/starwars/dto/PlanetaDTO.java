package com.starwars.dto;

import java.io.Serializable;

import com.starwars.dominio.Planeta;

public class PlanetaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String clima;
	private String terreno;
	private Integer qtdFilmes;

	public PlanetaDTO() {
		
	}
	
	public PlanetaDTO(Planeta p) {
		nome = p.getNome();
		clima = p.getClima();
		terreno = p.getTerreno();
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

	public Integer getqtdFilmes() {
		return qtdFilmes;
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
	
	public void setqtdFilmes(Integer qtdFilmes) {
		this.qtdFilmes = qtdFilmes;
	}
}
