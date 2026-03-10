package com.alonso.forohub.controller;

import com.alonso.forohub.domain.Topico;
import com.alonso.forohub.dto.DatosRegistroTopico;
import com.alonso.forohub.dto.DatosActualizarTopico;
import com.alonso.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    // Crear tópico
    @PostMapping
    public Topico registrarTopico(@RequestBody DatosRegistroTopico datos) {

        Topico topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.autor(),
                datos.curso()
        );

        return repository.save(topico);
    }

    // Listar todos los tópicos
    @GetMapping
    public List<Topico> listarTopicos(){
        return repository.findAll();
    }

    // Buscar tópico por ID
    @GetMapping("/{id}")
    public Topico buscarTopico(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topico no encontrado"));
    }

    // Actualizar tópico
    @PutMapping("/{id}")
    public Topico actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datos){

        Topico topico = repository.findById(id).orElseThrow();

        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());

        return repository.save(topico);
    }

    // Eliminar tópico
    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable Long id){
        repository.deleteById(id);
    }
}