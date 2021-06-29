package br.com.zupacademy.marciosouza.cadadocodigo.repository;

import br.com.zupacademy.marciosouza.cadadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
