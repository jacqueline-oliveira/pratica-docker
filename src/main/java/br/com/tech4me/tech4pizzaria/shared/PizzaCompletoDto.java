package br.com.tech4me.tech4pizzaria.shared;

import java.util.List;

import br.com.tech4me.tech4pizzaria.model.Tamanho;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PizzaCompletoDto (String id,
    @NotEmpty(message = "Campo sabor deve ser informado!")
    @NotBlank(message = "Tá com caracteres em branco mas sem o sabor.")
    String sabor,
    List<String> ingredientes,
    @NotNull(message = "Valores válidos: PEQ, MED, GRD, GIG")
    Tamanho tamanho,
    @Positive(message = "Informe um valor positivo para a pizza")
    Double valor) { 
}



