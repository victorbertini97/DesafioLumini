package com.desafio.viacep.controller;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.desafio.viacep.cep.CEP;

@RestController
public class ViaCepController implements Serializable {

	private static final long serialVersionUID = -8566347563069949182L;

	@GetMapping(value = "/desafiolumini/{cep}")
	public ResponseEntity<CEP> BuscaporCEP(@PathVariable(name = "cep") String cep) {

		RestTemplate template = new RestTemplate();
		String uri = "https://viacep.com.br/ws/{cep}/json";

		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);

		CEP cepresultado = template.getForObject(uri, CEP.class, params);

		return new ResponseEntity<CEP>(cepresultado, HttpStatus.OK);
	}
}