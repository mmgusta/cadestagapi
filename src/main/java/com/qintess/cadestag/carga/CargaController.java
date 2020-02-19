package com.qintess.cadestag.carga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.cadestag.carga.service.CargaService;

@RestController
public class CargaController {

	@Autowired
	private CargaService cargaService;
	
	@RequestMapping("/carga")
	@ResponseBody
	public String carga() {
		
		cargaService.realizaCarga();
		
		return "carga realizada com sucesso";
	}
}
