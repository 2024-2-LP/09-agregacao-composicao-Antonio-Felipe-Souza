package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Livro() {
    }

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        if (descricao != null && !descricao.isBlank()){
            if(qtdEstrelas != null && qtdEstrelas >= 0 && qtdEstrelas <= 5){
                Avaliacao avaliacao01 = new Avaliacao(descricao, qtdEstrelas);
                avaliacoes.add(avaliacao01);
            }
        }
    }

    public Double calcularMediaAvaliacoes(){
        Integer quantidade = avaliacoes.size();
        Double totalEstrelas = 0.0;

        if (avaliacoes.isEmpty()){
            return 0.0;
        }

        for (Avaliacao avaliacaoDaVez: avaliacoes){
            totalEstrelas += avaliacaoDaVez.getQtdEstrelas();
        }

        return totalEstrelas/quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return """
                Título: %s
                Autor: %s
                Data de publicação: %.2f""".formatted(titulo, autor, dataPublicacao);
    }
}
