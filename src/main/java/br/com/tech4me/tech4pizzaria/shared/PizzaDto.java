package br.com.tech4me.tech4pizzaria.shared;

import java.util.List;

public record PizzaDto (String id,
                      String sabor, 
                      List<String> ingredientes) {   
}





