package com.mitocode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Consulta;
import com.mitocode.model.Paciente;
import com.mitocode.model.Signo;

public interface ISignoVitalService extends IGenericService<Signo, Integer>{
	
	//pageable paginator
	Page<Signo>   listarPageable(Pageable pageable);

}
