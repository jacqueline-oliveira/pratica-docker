package br.com.tech4me.tech4pizzaria.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4pizzaria.shared.PizzaCompletoDto;
import br.com.tech4me.tech4pizzaria.shared.PizzaDto;

public interface PizzaService {
    List<PizzaDto> obterTodas();
    Optional<PizzaCompletoDto> obterPorId(String id);
    PizzaCompletoDto cadastrar(PizzaCompletoDto dto);
    PizzaCompletoDto atualizarPorId(String id, PizzaCompletoDto dto);
    void excluirPorId(String id);
}
