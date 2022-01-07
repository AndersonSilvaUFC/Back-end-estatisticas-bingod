package br.com.bingod.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingod.models.Cartela;
import br.com.bingod.repositories.CartelaRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class CartelaController {
	@Autowired
	private CartelaRepository cartelaRepository;
	
	@GetMapping("/cartelas")
	public ResponseEntity<Object>listaCartelas(){
		return new ResponseEntity<>(cartelaRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/cartela/{codigo}")
	public ResponseEntity<Object> getCartela(@PathVariable String codigo) {
		Cartela cartela = cartelaRepository.findByCodigo(codigo);
		if(cartela != null)
			return new ResponseEntity<>(cartela, HttpStatus.OK);
		else
			return new ResponseEntity<>(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartela inexistente"), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/cartela")
	public ResponseEntity<Object> cadastraCartela(@RequestBody @Valid Cartela cartela) {
		Cartela c = cartelaRepository.findByCodigo(cartela.getCodigo());
		if(c != null) {
			return new ResponseEntity<>(ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Cartela já existente"), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		cartelaRepository.save(cartela);
		return new ResponseEntity<>(cartela, HttpStatus.CREATED);
	}
	
	@PutMapping("/cartela")
	public ResponseEntity<Object> atualizaCartela(@RequestBody @Valid Cartela cartela) {
		Cartela c = cartelaRepository.findByCodigo(cartela.getCodigo());
		if(c == null) {
			return new ResponseEntity<>(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Impossível atualizar cartela inexistente"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<> (cartelaRepository.save(cartela), HttpStatus.OK);
	}
	
	@DeleteMapping("/cartela/{codigo}")
	public ResponseEntity<Object> atualizaCartela(@PathVariable String codigo) {
		Cartela c = cartelaRepository.findByCodigo(codigo);
		if(c == null) {
			return new ResponseEntity<>(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Impossível deletar cartela inexistente"), HttpStatus.BAD_REQUEST);
		}
		cartelaRepository.deleteById(codigo);
		return new ResponseEntity<> (null, HttpStatus.OK);
	}
}
