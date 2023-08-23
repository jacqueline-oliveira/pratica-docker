package br.com.tech4me.tech4pizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4pizzaria.service.PizzaService;
import br.com.tech4me.tech4pizzaria.shared.PizzaCompletoDto;
import br.com.tech4me.tech4pizzaria.shared.PizzaDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService servico;

    @GetMapping("/porta")
    private String obterPorta(@Value("${local.server.port}") String porta) {
        return "A instância que respondeu a requisição está rodando na porta " + porta;
    }
    
    @GetMapping
    private ResponseEntity<List<PizzaDto>> obterPizzas() {
        return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PizzaCompletoDto> obterPizzaPorId(@PathVariable String id) {
        Optional<PizzaCompletoDto> pizza = servico.obterPorId(id);

        if (pizza.isPresent()) {
            return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<PizzaCompletoDto> cadastrarPizza(@RequestBody @Valid PizzaCompletoDto pizza) {
        return new ResponseEntity<>(servico.cadastrar(pizza), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirPizzaPorId(@PathVariable String id) {
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<PizzaCompletoDto> atualizarPizza(@PathVariable String id, @RequestBody @Valid PizzaCompletoDto pizza) {
        PizzaCompletoDto pizzaAtualizada = servico.atualizarPorId(id, pizza);

        if (pizzaAtualizada != null) {
            return new ResponseEntity<>(pizzaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
