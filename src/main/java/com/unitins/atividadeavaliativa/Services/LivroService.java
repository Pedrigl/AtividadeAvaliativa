package com.unitins.atividadeavaliativa.Services;

import com.unitins.atividadeavaliativa.Entities.Livro;
import com.unitins.atividadeavaliativa.Repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findByTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }

    public List<Livro> findByAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }

    public List<Livro> obterTodosLivros() {
        return livroRepository.findAll();
    }
    public void inserirLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public Livro atualizarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}

