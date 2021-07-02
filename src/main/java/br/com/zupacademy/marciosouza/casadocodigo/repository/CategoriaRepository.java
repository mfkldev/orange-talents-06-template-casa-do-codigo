package br.com.zupacademy.marciosouza.casadocodigo.repository;

import br.com.zupacademy.marciosouza.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> getByNome(String nomeCategoria);
}
