package br.com.zupacademy.marciosouza.casadocodigo.repository;

import br.com.zupacademy.marciosouza.casadocodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
