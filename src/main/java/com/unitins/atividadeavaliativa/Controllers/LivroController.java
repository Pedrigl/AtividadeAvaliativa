package com.unitins.atividadeavaliativa.Controllers;

import com.unitins.atividadeavaliativa.Entities.Livro;
import com.unitins.atividadeavaliativa.Repositories.LivroRepository;
import com.unitins.atividadeavaliativa.Services.LivroService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping(path = "/add")
    public @ResponseBody String addLivro(@RequestBody Livro livro) {
        Livro newLivro = new Livro();
        newLivro.setTitulo(livro.getTitulo());
        newLivro.setAutor(livro.getAutor());

        livroService.inserirLivro(newLivro);
        return "Livro adicionado com sucesso!";
    }

    @GetMapping(path = "/get")
    public @ResponseBody List<Livro> getLivros() {
        return livroService.obterTodosLivros();
    }



}
