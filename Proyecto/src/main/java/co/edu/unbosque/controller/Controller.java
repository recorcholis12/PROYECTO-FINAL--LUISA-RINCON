package co.edu.unbosque.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.model.Agente;
import co.edu.unbosque.model.Ataque;
import co.edu.unbosque.repository.AgenteRepository;
import co.edu.unbosque.repository.AtaqueRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/controller")
public class Controller {

	@Autowired
	private AgenteRepository repoagente;

	@Autowired
	private AtaqueRepository repoataque;

	@GetMapping("/crud/agente")
	public ResponseEntity<List<Agente>> listarAgentes(){
		List<Agente> lista = repoagente.findAll();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);

	}

	@GetMapping("/crud/ataque")
	public ResponseEntity<List<Ataque>> listarAtaques(){
		List<Ataque> lista = repoataque.findAll();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);

	}

	@PostMapping("/crud/ataque")
	public ResponseEntity<String> agregarAtaque (@RequestParam String empresa,@RequestParam int tiempo,@RequestParam int afectados, @RequestParam Date fecha, @RequestParam String lugar, @RequestParam String agente1,@RequestParam String agente2,@RequestParam String agente3,@RequestParam String agente4 ){
		Ataque tem = new Ataque();
//		Optional<Agente> agente = repoagente.findByNombre(agente1);
		tem.setEmpresa(empresa);
		tem.setTiempo(tiempo);
		tem.setP_afectadas(afectados);
		tem.setLugar(lugar);
		tem.setFecha(fecha);

		System.out.println(agente1);
		System.out.println(agente2);
		System.out.println(agente3);
		System.out.println(agente4);
		
		if(!agente1.isEmpty()&&agente1!=null&&agente1!="") {
			Optional<Agente> agente = repoagente.findByNombre(agente1);
			if(agente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dato ingresado en agente1 no existe");		
			}else {
				tem.setAgentes1(agente1);
			}
		}
		else {
			tem.setAgentes1(agente1);
		}
		
		if(!agente2.isEmpty()&&agente2!=null&&agente2!="") {
			Optional<Agente> agente = repoagente.findByNombre(agente2);
			if(agente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dato ingresado en agente2 no existe");		
			}else {
				tem.setAgentes2(agente2);
			}
		}
		else {
			tem.setAgentes2(agente2);
		}
		if(!agente3.isEmpty()&&agente3!=null&&agente3!="") {
			Optional<Agente> agente = repoagente.findByNombre(agente3);
			if(agente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dato ingresado en agente3 no existe");		
			}else {
				tem.setAgentes3(agente3);
			}
		}
		else {
			tem.setAgentes3(agente3);
		}
		
		if(!agente4.isEmpty()&&agente4!=null&&!agente4.equals("")) {
			Optional<Agente> agente = repoagente.findByNombre(agente4);
			if(agente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dato ingresado en agente4 no existe");		
			}else {
				tem.setAgentes4(agente4);
			}
		}
		else {
			tem.setAgentes4(agente4);
		}
		repoataque.save(tem);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito:201");

	}
	
	@PostMapping("/crud/agente")
	public ResponseEntity<String> agregarAgente(@RequestParam String nombre, @RequestParam Date nacimiento, @RequestParam String sexo, @RequestParam Date f_institucion, @RequestParam String rango, @RequestParam int casos){
		Agente tem = new Agente();
		tem.setNombre(nombre);
		tem.setF_nacimiento(nacimiento);
		tem.setSexo(sexo);
		tem.setE_institucion(f_institucion);
		tem.setRango(rango);
		tem.setCasos(casos);
		repoagente.save(tem);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito:201");

	}
	@PutMapping("/crud/agente")
	public ResponseEntity<String> actualizarAgente(@RequestParam String nombre, @RequestParam Date nacimiento, @RequestParam String sexo, @RequestParam Date f_institucion, @RequestParam String rango, @RequestParam int casos){
		
		Optional<Agente> dato = repoagente.findByNombre(nombre);
		if(dato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("dato no encontrado");
			
		}
		Agente tem = dato.get();
		tem.setNombre(nombre);
		tem.setF_nacimiento(nacimiento);
		tem.setSexo(sexo);
		tem.setE_institucion(f_institucion);
		tem.setRango(rango);
		tem.setCasos(casos);
		repoagente.save(tem);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("dato actualizado con exito");

	}
	
	@PutMapping("/crud/ataque")
	public ResponseEntity<String> actualizarAtaque(@RequestParam String empresa,@RequestParam int tiempo,@RequestParam int afectados, @RequestParam Date fecha, @RequestParam String lugar, @RequestParam String agente1,@RequestParam String agente2,@RequestParam String agente3,@RequestParam String agente4 ){
			
		Optional<Ataque> dato = repoataque.findByEmpresa(empresa);
		if(dato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("dato no encontrado");
			
		}
		Ataque tem = dato.get();
		tem.setEmpresa(empresa);
		tem.setTiempo(tiempo);
		tem.setP_afectadas(afectados);
		tem.setLugar(lugar);
		tem.setFecha(fecha);

		System.out.println(agente1);
		System.out.println(agente2);
		System.out.println(agente3);
		System.out.println(agente4);
		
		if(!agente1.isEmpty()&&agente1!=null&&agente1!="") {
			Optional<Agente> agente = repoagente.findByNombre(agente1);
			if(agente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dato ingresado en agente1 no existe");		
			}else {
				tem.setAgentes1(agente1);
			}
		}
		else {
			tem.setAgentes1(agente1);
		}
		
		if(!agente2.isEmpty()&&agente2!=null&&agente2!="") {
			Optional<Agente> agente = repoagente.findByNombre(agente2);
			if(agente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dato ingresado en agente2 no existe");		
			}else {
				tem.setAgentes2(agente2);
			}
		}
		else {
			tem.setAgentes2(agente2);
		}
		if(!agente3.isEmpty()&&agente3!=null&&agente3!="") {
			Optional<Agente> agente = repoagente.findByNombre(agente3);
			if(agente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dato ingresado en agente3 no existe");		
			}else {
				tem.setAgentes3(agente3);
			}
		}
		else {
			tem.setAgentes3(agente3);
		}
		
		if(!agente4.isEmpty()&&agente4!=null&&!agente4.equals("")) {
			Optional<Agente> agente = repoagente.findByNombre(agente4);
			if(agente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El dato ingresado en agente4 no existe");		
			}else {
				tem.setAgentes4(agente4);
			}
		}
		else {
			tem.setAgentes4(agente4);
		}
		repoataque.save(tem);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("dato actualizado con exito");

	}
	
	@DeleteMapping("/crud/agente")
	public ResponseEntity<String> eliminarAgente(@RequestParam String nombre){
		Optional<Agente> dato = repoagente.findByNombre(nombre);
		if(dato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("datos no encontrados");
			
		}
		repoagente.deleteByNombre(nombre);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("dato eliminados con exito");
		
	}
	
	@DeleteMapping("/crud/ataque")
	public ResponseEntity<String> eliminarAtaque(@RequestParam String empresa){
		Optional<Ataque> dato = repoataque.findByEmpresa(empresa);
		if(dato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("dato no encontrados");
			
		}
		repoataque.deleteByEmpresa(empresa);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("dato eliminados con exito");
		
	}
	
}
