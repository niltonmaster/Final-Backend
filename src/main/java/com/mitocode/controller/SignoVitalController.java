package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Signo;
import com.mitocode.service.ISignoVitalService;

@RestController
@RequestMapping("/signos_vitales")
public class SignoVitalController {
	
	@Autowired
	private ISignoVitalService service;
	
	
	@GetMapping
	public ResponseEntity<List<Signo>> listar() throws Exception{
		List<Signo> lista = service.listar();
		return new ResponseEntity<List<Signo>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Signo> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Signo p = service.listarPorId(id);
		if(p == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Signo>(p, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Signo signo) throws Exception{
		Signo p = service.registrar(signo);
		//localhost:8080/pacientes/5		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdSigno()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Signo> modificar(@Valid @RequestBody Signo signo) throws Exception{
		Signo p = service.modificar(signo);
		return new ResponseEntity<Signo>(p, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
		Signo p = service.listarPorId(id);
		if(p == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Signo>> listarPageable(Pageable pageable){
		Page<Signo> signos= service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Signo>>(signos, HttpStatus.OK);
	}
	
	
	

}
