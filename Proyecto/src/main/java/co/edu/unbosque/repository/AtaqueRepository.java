package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.model.Ataque;


public interface AtaqueRepository extends CrudRepository<Ataque, Integer>{

	public void deleteByEmpresa(String empresa);
	public Optional<Ataque> findById(Integer id);
	public Optional<Ataque>findByEmpresa(String empresa);
	public List<Ataque> findAll();
//	public Optional<Ataque>findByAgentes1(String agente);
//	public Optional<Ataque>findByAgentes2(String agente);
//	public Optional<Ataque>findByAgentes3(String agente);
//	public Optional<Ataque>findByAgentes4(String agente);
}
