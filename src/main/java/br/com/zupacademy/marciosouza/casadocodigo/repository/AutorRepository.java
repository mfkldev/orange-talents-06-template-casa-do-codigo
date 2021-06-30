package br.com.zupacademy.marciosouza.casadocodigo.repository;

import br.com.zupacademy.marciosouza.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> getByEmail(String email);
}
