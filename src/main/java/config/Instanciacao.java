package config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.starwars.dominio.Planeta;
import com.starwars.repositorios.PlanetaRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
    PlanetaRepositorio planetaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("ss/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		planetaRepositorio.deleteAll();
		
		Planeta p1 = new Planeta(null, "Tatooine", "arid", "desert");
		Planeta p2 = new Planeta(null, "Hoth", "frozen", "tundra, ice caves, mountain ranges");
		Planeta p3 = new Planeta(null, "Dagobah", "murky", "swamp, jungles");
		Planeta p4 = new Planeta(null, "Naboo", "temperate", "grassy hills, swamps, forests, mountains");
		
		planetaRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4));
	}
}
