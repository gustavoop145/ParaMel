package com.portalestagios.controller;

import com.portalestagios.dto.usuario.UsuarioRequestDTO;
import com.portalestagios.dto.usuario.UsuarioResponseDTO;
import com.portalestagios.model.Usuario;
import com.portalestagios.repository.UsuarioRepository;
import com.portalestagios.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody @jakarta.validation.Valid UsuarioRequestDTO dto){
        Usuario u = new Usuario();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setPerfil(dto.getPerfil()==null?"ESTUDANTE":dto.getPerfil());
        u.setSenha(encoder.encode(dto.getSenha()));
        Usuario saved = usuarioRepository.save(u);
        String token = jwtUtil.generateToken(saved.getEmail()+":"+saved.getPerfil());
        UsuarioResponseDTO res = new UsuarioResponseDTO();
        res.setId(saved.getId()); res.setNome(saved.getNome()); res.setEmail(saved.getEmail()); res.setPerfil(saved.getPerfil());
        return Map.of("token", token, "usuario", res);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String,String> body){
        String email = body.getOrDefault("email", "");
        String senha = body.getOrDefault("senha", "");
        Optional<Usuario> ou = usuarioRepository.findByEmail(email);
        if (ou.isPresent() && encoder.matches(senha, ou.get().getSenha())) {
            Usuario u = ou.get();
            String token = jwtUtil.generateToken(u.getEmail()+":"+u.getPerfil());
            UsuarioResponseDTO res = new UsuarioResponseDTO();
            res.setId(u.getId()); res.setNome(u.getNome()); res.setEmail(u.getEmail()); res.setPerfil(u.getPerfil());
            return Map.of("token", token, "usuario", res);
        }
        return Map.of("error", "Credenciais inválidas");
    }
}
