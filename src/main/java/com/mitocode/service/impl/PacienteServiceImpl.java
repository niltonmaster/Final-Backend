package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.Paciente;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPacienteRepo;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl extends GenericServiceImpl<Paciente, Integer> implements IPacienteService{

	@Autowired
	private IPacienteRepo repo;
	
	@Override
	protected IGenericRepo<Paciente, Integer> getRepo() {
		//esto funciona para saber cual repo usar en el generico gracias al Autowired
		return repo; 
	}

	@Override
	public Page<Paciente> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Paciente registrar2(Paciente p) {
		// TODO Auto-generated method stub
		return getRepo().save(p);
	}
	
	
	
	/*@Override
	public Paciente registrar(Paciente obj) {
		return repo.save(obj);
	}

	@Override
	public Paciente modificar(Paciente obj) {		
		return repo.save(obj);
	}

	@Override
	public List<Paciente> listar() {
		return repo.findAll();
	}

	@Override
	public Paciente listarPorId(Integer id) {
		Optional<Paciente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Paciente();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}*/

}
