package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.model.Agente;

import java.util.List;
import java.util.Optional;


public interface AgenteRepository extends CrudRepository<Agente, Integer>{

	public void deleteByNombre(String nombre);
	public Optional<Agente> findById(Integer id);
	public Optional<Agente>findByNombre(String nombre);
	public List<Agente> findAll();
}
 