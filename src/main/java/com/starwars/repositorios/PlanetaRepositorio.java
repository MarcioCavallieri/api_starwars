package com.starwars.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.starwars.dominio.Planeta;

@Repository
public interface PlanetaRepositorio extends MongoRepository<Planeta, String> {
	//https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference
	
	Planeta findByNomeIgnoreCase(String texto);
	void deleteByNomeIgnoreCase(String texto);
}
