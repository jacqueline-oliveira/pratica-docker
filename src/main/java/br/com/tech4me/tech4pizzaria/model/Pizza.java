package br.com.tech4me.tech4pizzaria.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.tech4pizzaria.shared.PizzaCompletoDto;

@Document("pizzas")
public class Pizza {
    @Id
    private String id;
    private String sabor;
    private List<String> ingredientes;
    private Tamanho tamanho;
    private Double valor;

    public Pizza() {}

    public Pizza(PizzaCompletoDto dto) {
        this.id = dto.id();
        this.sabor = dto.sabor();
        this.ingredientes = dto.ingredientes();
        this.tamanho = dto.tamanho();
        this.valor = dto.valor();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSabor() {
        return sabor;
    }
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public List<String> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
    public Tamanho getTamanho() {
        return tamanho;
    }
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
}
