package com.unitins.atividadeavaliativa.Repositories;

import com.unitins.atividadeavaliativa.Entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByAutor(String autor);
    List<Livro> findByTitulo(String titulo);

    Livro findLivroById(Long id);


    Livro save(Livro livro);

    void deleteById(Long id);
}
