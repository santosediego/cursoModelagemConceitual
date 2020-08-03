package com.santosediego.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosediego.cursomc.domain.Categoria;
import com.santosediego.cursomc.repositories.CategoriaRepository;
import com.santosediego.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired //A depedência será auto instanciada pelo Spring Boot com esta anotação;
	private CategoriaRepository repo;// A interface.
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		/*Esse modelo é para o Sprint a partir da 2.0*/
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
