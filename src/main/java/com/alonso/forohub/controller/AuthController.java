package com.alonso.forohub.controller;

import com.alonso.forohub.dto.DatosLogin;
import com.alonso.forohub.repository.UsuarioRepository;
import com.alonso.forohub.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody DatosLogin datos){

        var usuario = repository.findByUsername(datos.username());

        if(usuario == null){
            return "Usuario no encontrado";
        }

        if(!usuario.getPassword().equals(datos.password())){
            return "Contraseña incorrecta";
        }

        return tokenService.generarToken(usuario.getUsername());
    }
}