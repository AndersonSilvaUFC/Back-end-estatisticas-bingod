package br.com.bingod.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingod.models.Estatistica;
import br.com.bingod.repositories.EstatisticaRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class EstatisticaController {
	
	@Autowired
	private EstatisticaRepository estatisticaRepository;
	
	@GetMapping("/estatisticas")
	public ResponseEntity<Object> listarEstatisticas(){
		return new ResponseEntity<>(estatisticaRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/estatistica")
	public ResponseEntity<Object> cadastraEstatistica(@RequestBody Estatistica estatistica){
		List<Estatistica> lista = estatisticaRepository.findAll();
		if(!lista.isEmpty()) {
			return new ResponseEntity<>(ResponseEntity.status(HttpStatus.BAD_REQUEST).body
					("Somente uma instância pode ser cadastrada"), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(estatisticaRepository.save(estatistica),HttpStatus.CREATED);
	}
	
	@PutMapping("/estatistica")
	public ResponseEntity<Object> atualizaEstatistica(@RequestBody Estatistica estatistica){
		List<Estatistica> lista = estatisticaRepository.findAll();
		if(lista.isEmpty()) {
			return new ResponseEntity<>(ResponseEntity.status(HttpStatus.BAD_REQUEST).body
					("Impossível atualizar registro inexistente"), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(estatisticaRepository.save(estatistica),HttpStatus.OK);
	}
}
