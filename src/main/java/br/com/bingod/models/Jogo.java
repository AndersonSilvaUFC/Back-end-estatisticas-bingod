package br.com.bingod.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Jogo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable=false)
	private long id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataJogo;
	
	@ElementCollection
	private Set<String> cartelas;
	
	@ElementCollection
	private Set<Integer> bolasChamadas;
	
	@NotNull
	private int numeroBolasChamadas;
	
	@NotNull
	private int primeiraBolaChamada;
	
	@NotNull
	private int ultimaBolaChamada;
	
	@NotNull
	private int numeroBolasChamadasAoArmar;
	
	@NotNull
	private int quantidadeImpares;
	
	@NotNull
	private int quantidadePares;
	
	@ElementCollection
	private Set<String> cartelasArmadas;
	
	@ElementCollection
	private Set<String> cartelasBatidas;
	
	public Jogo() {}

	public Jogo(long id, @NotNull Date dataJogo, Set<String> cartelas, Set<Integer> bolasChamadas,
			@NotNull int numeroBolasChamadas, @NotNull int primeiraBolaChamada, @NotNull int ultimaBolaChamada,
			@NotNull int numeroBolasChamadasAoArmar, @NotNull int quantidadeImpares, @NotNull int quantidadePares,
			Set<String> cartelasArmadas, Set<String> cartelasBatidas) {
		super();
		this.id = id;
		this.dataJogo = dataJogo;
		this.cartelas = cartelas;
		this.bolasChamadas = bolasChamadas;
		this.numeroBolasChamadas = numeroBolasChamadas;
		this.primeiraBolaChamada = primeiraBolaChamada;
		this.ultimaBolaChamada = ultimaBolaChamada;
		this.numeroBolasChamadasAoArmar = numeroBolasChamadasAoArmar;
		this.quantidadeImpares = quantidadeImpares;
		this.quantidadePares = quantidadePares;
		this.cartelasArmadas = cartelasArmadas;
		this.cartelasBatidas = cartelasBatidas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataJogo() {
		return dataJogo;
	}

	public void setDataJogo(Date dataJogo) {
		this.dataJogo = dataJogo;
	}

	public Set<String> getCartelas() {
		return cartelas;
	}

	public void setCartelas(Set<String> cartelas) {
		this.cartelas = cartelas;
	}

	public Set<Integer> getBolasChamadas() {
		return bolasChamadas;
	}

	public void setBolasChamadas(Set<Integer> bolasChamadas) {
		this.bolasChamadas = bolasChamadas;
	}

	public int getNumeroBolasChamadas() {
		return numeroBolasChamadas;
	}

	public void setNumeroBolasChamadas(int numeroBolasChamadas) {
		this.numeroBolasChamadas = numeroBolasChamadas;
	}

	public int getPrimeiraBolaChamada() {
		return primeiraBolaChamada;
	}

	public void setPrimeiraBolaChamada(int primeiraBolaChamada) {
		this.primeiraBolaChamada = primeiraBolaChamada;
	}

	public int getUltimaBolaChamada() {
		return ultimaBolaChamada;
	}

	public void setUltimaBolaChamada(int ultimaBolaChamada) {
		this.ultimaBolaChamada = ultimaBolaChamada;
	}

	public int getNumeroBolasChamadasAoArmar() {
		return numeroBolasChamadasAoArmar;
	}

	public void setNumeroBolasChamadasAoArmar(int numeroBolasChamadasAoArmar) {
		this.numeroBolasChamadasAoArmar = numeroBolasChamadasAoArmar;
	}

	public int getQuantidadeImpares() {
		return quantidadeImpares;
	}

	public void setQuantidadeImpares(int quantidadeImpares) {
		this.quantidadeImpares = quantidadeImpares;
	}

	public int getQuantidadePares() {
		return quantidadePares;
	}

	public void setQuantidadePares(int quantidadePares) {
		this.quantidadePares = quantidadePares;
	}

	public Set<String> getCartelasArmadas() {
		return cartelasArmadas;
	}

	public void setCartelasArmadas(Set<String> cartelasArmadas) {
		this.cartelasArmadas = cartelasArmadas;
	}

	public Set<String> getCartelasBatidas() {
		return cartelasBatidas;
	}

	public void setCartelasBatidas(Set<String> cartelasBatidas) {
		this.cartelasBatidas = cartelasBatidas;
	}
}
