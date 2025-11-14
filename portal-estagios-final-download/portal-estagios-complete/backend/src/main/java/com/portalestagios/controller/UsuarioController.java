package com.portalestagios.controller;

import com.portalestagios.model.Usuario;
import com.portalestagios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario u){
        u.setSenha(encoder.encode(u.getSenha()));
        if (u.getPerfil()==null) u.setPerfil("ESTUDANTE");
        return usuarioRepository.save(u);
    }

    @GetMapping
    public List<Usuario> all(){ return usuarioRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional<Usuario> one(@PathVariable Long id){ return usuarioRepository.findById(id); }
}
