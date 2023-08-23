package br.com.tech4me.tech4pizzaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4pizzaria.model.Pizza;
import br.com.tech4me.tech4pizzaria.repository.PizzaRepository;
import br.com.tech4me.tech4pizzaria.shared.PizzaCompletoDto;
import br.com.tech4me.tech4pizzaria.shared.PizzaDto;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository repositorio;

    @Override
    public List<PizzaDto> obterTodas() {
        return repositorio.findAll()
            .stream()
            .map(p -> new PizzaDto(p.getSabor(), p.getIngredientes()))
            .toList();
    }

    @Override
    public Optional<PizzaCompletoDto> obterPorId(String id) {
        Optional<Pizza> pizza = repositorio.findById(id);

        if (pizza.isPresent()) {
            return Optional.of(new PizzaCompletoDto(pizza.get().getId(),
                pizza.get().getSabor(),
                pizza.get().getIngredientes(),
                pizza.get().getTamanho(),
                pizza.get().getValor()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PizzaCompletoDto cadastrar(PizzaCompletoDto dto) {
        Pizza pizza = new Pizza(dto);
        repositorio.save(pizza);

        return new PizzaCompletoDto(pizza.getId(),
            pizza.getSabor(),
            pizza.getIngredientes(),
            pizza.getTamanho(),
            pizza.getValor());
    }

    @Override
    public PizzaCompletoDto atualizarPorId(String id, PizzaCompletoDto dto) {
        Pizza pizza = repositorio.findById(id).orElse(null);

        if (pizza != null) {
            Pizza pizzaAtualizar = new Pizza(dto);
            pizzaAtualizar.setId(id);
            repositorio.save(pizzaAtualizar);
            return new PizzaCompletoDto(pizzaAtualizar.getId(),
                pizzaAtualizar.getSabor(),
                pizzaAtualizar.getIngredientes(),
                pizzaAtualizar.getTamanho(),
                pizzaAtualizar.getValor());
        } else {
            return null;
        }
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }
    
}
