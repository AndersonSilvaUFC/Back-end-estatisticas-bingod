package br.com.bingod.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table
public class Estatistica {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn
	private Map<Integer, Long> vezesSaida = new HashMap<Integer,Long>();
	
	@ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn
	private Map<Integer, Long> vezesSaidaPrimeira = new HashMap<Integer,Long>();
	
	@ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn
	private Map<Integer, Long> vezesSaidaUltima = new HashMap<Integer,Long>();
	
	public Estatistica() {
		for(int i=1; i<=90; i++) {
			vezesSaida.put(i, (long) 0);
			vezesSaidaPrimeira.put(i, (long) 0);
			vezesSaidaUltima.put(i, (long) 0);
		}
	}

	public Estatistica(int id, Map<Integer, Long> vezesSaida, Map<Integer, Long> vezesSaidaPrimeira,
			Map<Integer, Long> vezesSaidaUltima) {
		super();
		this.id = id;
		this.vezesSaida = vezesSaida;
		this.vezesSaidaPrimeira = vezesSaidaPrimeira;
		this.vezesSaidaUltima = vezesSaidaUltima;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Integer, Long> getVezesSaida() {
		return vezesSaida;
	}

	public void setVezesSaida(Map<Integer, Long> vezesSaida) {
		this.vezesSaida = vezesSaida;
	}

	public Map<Integer, Long> getVezesSaidaPrimeira() {
		return vezesSaidaPrimeira;
	}

	public void setVezesSaidaPrimeira(Map<Integer, Long> vezesSaidaPrimeira) {
		this.vezesSaidaPrimeira = vezesSaidaPrimeira;
	}

	public Map<Integer, Long> getVezesSaidaUltima() {
		return vezesSaidaUltima;
	}

	public void setVezesSaidaUltima(Map<Integer, Long> vezesSaidaUltima) {
		this.vezesSaidaUltima = vezesSaidaUltima;
	}
		
}
