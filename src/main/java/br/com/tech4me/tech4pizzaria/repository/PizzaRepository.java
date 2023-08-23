package br.com.tech4me.tech4pizzaria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4pizzaria.model.Pizza;

public interface PizzaRepository extends MongoRepository<Pizza, String> {
    
}
