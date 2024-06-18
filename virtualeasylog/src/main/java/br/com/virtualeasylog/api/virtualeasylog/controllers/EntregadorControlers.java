package br.com.virtualeasylog.api.virtualeasylog.controllers;

import br.com.virtualeasylog.api.virtualeasylog.models.Entregador;
import br.com.virtualeasylog.api.virtualeasylog.repositories.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entregador")
@CrossOrigin
public class EntregadorControlers {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @GetMapping("/")
    public List<Entregador> listar() {
        return entregadorRepository.findAll();
    }



    @GetMapping("/id/{id}")
    public Optional<Entregador> listarPorId(@PathVariable String id) {
        return entregadorRepository.findById(id);
    }

/*
    @GetMapping("/entregadores/{id}")
    public Optional<Entregador> getEntregadorById(@PathVariable String id) {
        return entregadorRepository.findById(id);
    }
*/

    @PostMapping("/adicionar")
    public Entregador adicionar(@RequestBody Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    @PutMapping("/editar")
    public String editar(@RequestBody Entregador entregador) {
        if (entregadorRepository.existsById(entregador.getIdCpf())) {
            entregadorRepository.save(entregador);
            return "Editado com sucesso";
        }
        return "Comanda não encontrada";
    }

    @DeleteMapping("/apagar")
    public String deletar(@RequestBody Entregador entregador) {
        if (entregadorRepository.existsById(entregador.getIdCpf())) {
            entregadorRepository.delete(entregador);
            return "Apagado com sucesso";
        }
        return "Comanda não encontrada";
    }
}
