package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.Paciente;
import com.mitocode.model.Signo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ISignoVitalRepo;
import com.mitocode.service.ISignoVitalService;



@Service
public class SignoVitalServiceImpl  extends GenericServiceImpl<Signo, Integer> implements ISignoVitalService{

	@Autowired
	private ISignoVitalRepo repo;
	
	@Override
	protected IGenericRepo<Signo, Integer> getRepo() {
		//esto funciona para saber cual repo usar en el generico gracias al Autowired
		return repo; 
	}

	@Override
	public Page<Signo> listarPageable(Pageable pageable) {
		return 	repo.findAll(pageable);
	}

	
	

}
