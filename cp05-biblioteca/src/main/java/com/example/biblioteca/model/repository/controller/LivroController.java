package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "livros/listar";
    }

    @GetMapping("/disponiveis")
    public String listarDisponiveis(Model model) {
        model.addAttribute("livros", livroRepository.findByEmprestadoFalse());
        return "livros/listar_disponiveis";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping
    public String salvar(Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "redirect:/livros";
    }
}
