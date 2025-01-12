package br.com.zupacademy.marciosouza.casadocodigo.controller;

import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.LivroRequest;
import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.LivroResponse;
import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.LivroResponseDetalhadoFront;
import br.com.zupacademy.marciosouza.casadocodigo.controller.dto.LivroResponseIdETitulo;
import br.com.zupacademy.marciosouza.casadocodigo.model.Livro;
import br.com.zupacademy.marciosouza.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marciosouza.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.marciosouza.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    @CacheEvict(value = "listar_todos", allEntries = true)
    public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest){

        Livro livro = livroRequest.converter(autorRepository, categoriaRepository);
        livroRepository.save(livro);
        LivroResponse livroResponse = new LivroResponse(livro);

        return ResponseEntity.ok().body(livroResponse);
    }

    @GetMapping
    @Cacheable(value = "listar_todos")
    public Page<LivroResponseIdETitulo> listar_todos(@PageableDefault (sort = "id", direction = Sort.Direction.DESC, page = 0, size = 1) Pageable page){

        return LivroResponseIdETitulo.ConvertePageLivroToPageDto(livroRepository.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id){
        Optional<Livro> livroBuscado = livroRepository.findById(id);

        if(livroBuscado.isPresent()){
            return ResponseEntity.ok(new LivroResponseDetalhadoFront(livroBuscado.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
