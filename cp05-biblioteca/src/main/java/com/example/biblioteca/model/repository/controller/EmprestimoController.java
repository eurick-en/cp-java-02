package com.example.biblioteca.controller;

import com.example.biblioteca.model.*;
import com.example.biblioteca.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("emprestimos", emprestimoRepository.findByAtivoTrue());
        return "emprestimos/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        model.addAttribute("livros", livroRepository.findByEmprestadoFalse());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "emprestimos/form";
    }

    @PostMapping
    public String salvar(Emprestimo emprestimo) {
        Livro livro = emprestimo.getLivro();
        livro.setEmprestado(true);
        livroRepository.save(livro);
        emprestimo.setDataRetirada(LocalDate.now());
        emprestimo.setAtivo(true);
        emprestimoRepository.save(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/devolver/{id}")
    public String devolver(@PathVariable Long id) {
        Emprestimo e = emprestimoRepository.findById(id).orElseThrow();
        e.setAtivo(false);
        Livro l = e.getLivro();
        l.setEmprestado(false);
        livroRepository.save(l);
        emprestimoRepository.save(e);
        return "redirect:/emprestimos";
    }
}
