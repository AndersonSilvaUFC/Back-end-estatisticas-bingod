package br.com.bingod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bingod.models.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
