package com.starwars.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.starwars.dominio.Planeta;
import com.starwars.dto.PlanetaDTO;
import com.starwars.servicos.PlanetaServico;

@RestController
@RequestMapping(value = "starwars/api/planetas")
public class PlanetaRecurso {
	@Autowired
	private PlanetaServico servico;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PlanetaDTO>> obterTodos(){			
		List<Planeta> lista = servico.obterTodos();
		List<PlanetaDTO> listaDTO = lista.stream().map(p -> new PlanetaDTO(p)).collect(Collectors.toList());
		return ResponseEntity.ok(listaDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlanetaDTO> obterPorId(@PathVariable String id){			
		Planeta p = servico.obterPorId(id);
		PlanetaDTO dto = new PlanetaDTO(p);
		
		dto.setqtdFilmes(SwapiApiRecurso.obterTotalDeFilmes(p.getNome()));
		
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(value = "/nome/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlanetaDTO> obterPorNome(@PathVariable String id){			
		Planeta p = servico.obterPorNome(id);
		PlanetaDTO dto = new PlanetaDTO(p);
		
		dto.setqtdFilmes(SwapiApiRecurso.obterTotalDeFilmes(p.getNome()));
		
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody PlanetaDTO obj){
		Planeta p = servico.fromDTO(obj);
		p = servico.inserir(p);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
		servico.deletarPorId(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/nome/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarPorNome(@PathVariable String nome) {
		servico.deletarPorNome(nome);
		
		return ResponseEntity.noContent().build();
	}
}
