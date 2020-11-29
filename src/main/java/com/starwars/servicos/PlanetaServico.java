package com.starwars.servicos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starwars.dominio.Planeta;
import com.starwars.dto.PlanetaDTO;
import com.starwars.excecoes.ObjectNotFoundException;
import com.starwars.repositorios.PlanetaRepositorio;

@Service
public class PlanetaServico {
	@Autowired
	private PlanetaRepositorio repositorio;
	
	public List<Planeta> obterTodos() {
		return repositorio.findAll();
	}
	
	public Planeta obterPorId(String id) {
		Optional<Planeta> p = repositorio.findById(id);
		
		if (! p.isPresent()) {
			throw new ObjectNotFoundException("Planeta não encontrado...");
		}
		
		return p.get();
	}
	
	public Planeta obterPorNome(String texto) {
		return repositorio.findByNomeIgnoreCase(texto);
	}
	
	public Planeta inserir(Planeta obj) {
		return repositorio.insert(obj);
	}
	
	public void deletarPorId(String id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	public void deletarPorNome(String nome) {
		repositorio.deleteById(nome);
	}
	
	public Planeta fromDTO(PlanetaDTO obj) {
		return new Planeta(null, obj.getNome(), obj.getClima(), obj.getTerreno());
	}
}