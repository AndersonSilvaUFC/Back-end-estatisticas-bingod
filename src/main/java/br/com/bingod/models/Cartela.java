package br.com.bingod.models;

import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Cartela {
	@Id
	private String codigo;
	
	@ElementCollection
	private Set<Integer> numeros;
	
	@NotNull
	private int vezesArmada;
	
	@NotNull
	private long vezesBatida;
	
	public Cartela() {}

	public Cartela(String codigo, Set<Integer> numeros, int vezesArmada, long vezesBatida) {
		super();
		this.codigo = codigo;
		this.numeros = numeros;
		this.vezesArmada = vezesArmada;
		this.vezesBatida = vezesBatida;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Set<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(Set<Integer> numeros) {
		this.numeros = numeros;
	}

	public int getVezesArmada() {
		return vezesArmada;
	}

	public void setVezesArmada(int vezesArmada) {
		this.vezesArmada = vezesArmada;
	}

	public long getVezesBatida() {
		return vezesBatida;
	}

	public void setVezesBatida(long vezesBatida) {
		this.vezesBatida = vezesBatida;
	}
}
