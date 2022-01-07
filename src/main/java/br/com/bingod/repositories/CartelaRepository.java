package br.com.bingod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bingod.models.Cartela;

@Repository
public interface CartelaRepository extends JpaRepository<Cartela, String> {
	public Cartela findByCodigo(String codigo);
}
