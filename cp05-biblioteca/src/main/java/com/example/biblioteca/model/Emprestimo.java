package com.example.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @NotNull
    private Livro livro;

    @ManyToOne @NotNull
    private Usuario usuario;

    private LocalDate dataRetirada;

    @Future(message = "A data de devolução deve ser futura.")
    private LocalDate dataDevolucao;

    private boolean ativo = true;

    public Emprestimo() {}

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataRetirada, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }

    // Getters e setters
    public Long getId() { return id; }
    public Livro getLivro() { return livro; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getDataRetirada() { return dataRetirada; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public boolean isAtivo() { return ativo; }

    public void setId(Long id) { this.id = id; }
    public void setLivro(Livro livro) { this.livro = livro; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setDataRetirada(LocalDate dataRetirada) { this.dataRetirada = dataRetirada; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
