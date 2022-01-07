package br.com.bingod.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingod.models.Cartela;
import br.com.bingod.models.Estatistica;
import br.com.bingod.models.Jogo;
import br.com.bingod.repositories.JogoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class JogoController {
	@Autowired
	private JogoRepository jogoRepository; 
	
	@Autowired
	private CartelaController cartelaController;
	
	@Autowired
	private EstatisticaController estatisticaController;
	
	@GetMapping("/jogos")
	public ResponseEntity<Object> listarJogos(){
		return new ResponseEntity<>(jogoRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/jogo")
	public ResponseEntity<Object> cadastraJogo(@RequestBody @Valid Jogo jogo){	
		List<Estatistica> estatisticas = (List<Estatistica>) estatisticaController.listarEstatisticas().getBody();
		Estatistica estatistica;
		if(!estatisticas.isEmpty()) {
			estatistica = estatisticas.get(0);
			System.out.println(estatistica.getId());
			Map<Integer, Long> saidas = estatistica.getVezesSaida();
			Map<Integer, Long> primeiras = estatistica.getVezesSaidaPrimeira();
			Map<Integer, Long> ultimas = estatistica.getVezesSaidaUltima();
			
			System.out.println("Primeira bola chamada: "+jogo.getPrimeiraBolaChamada());
			primeiras.put(jogo.getPrimeiraBolaChamada(), primeiras.get(jogo.getPrimeiraBolaChamada()).longValue()+1);
			ultimas.put(jogo.getUltimaBolaChamada(), ultimas.get(jogo.getUltimaBolaChamada()).longValue()+1);
			
			for(Integer bola : jogo.getBolasChamadas()) {
				saidas.put(bola, saidas.get(bola).longValue()+1);
			}
			
			estatistica.setVezesSaida(saidas);
			estatistica.setVezesSaidaPrimeira(primeiras);
			estatistica.setVezesSaidaUltima(ultimas);
			
			estatisticaController.atualizaEstatistica(estatistica);
		}
		for(String codigo : jogo.getCartelasArmadas()) {
			ResponseEntity<Object> res = cartelaController.getCartela(codigo); 
			if(res.getStatusCode() != HttpStatus.NOT_FOUND) {
				Cartela cartela = (Cartela) res.getBody();
				cartela.setVezesArmada(cartela.getVezesArmada()+1);
				cartelaController.atualizaCartela(cartela);
			}			
		}
		
		for(String codigo : jogo.getCartelasBatidas()) {
			ResponseEntity<Object> res = cartelaController.getCartela(codigo); 
			if(res.getStatusCode() != HttpStatus.NOT_FOUND) {
				Cartela cartela = (Cartela) res.getBody();
				cartela.setVezesBatida(cartela.getVezesBatida()+1);
				cartelaController.atualizaCartela(cartela);
			}			
		}		
		jogoRepository.save(jogo);
		return new ResponseEntity<>(jogo,HttpStatus.CREATED);
	}
}
