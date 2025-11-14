package com.portalestagios.controller;

import com.portalestagios.dto.empresa.EmpresaRequestDTO;
import com.portalestagios.dto.empresa.EmpresaResponseDTO;
import com.portalestagios.model.Empresa;
import com.portalestagios.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping
    @PreAuthorize("hasRole('EMPRESA') or hasRole('ADMIN')")
    public EmpresaResponseDTO create(@RequestBody @jakarta.validation.Valid EmpresaRequestDTO dto){
        Empresa e = new Empresa();
        e.setNome(dto.getNome()); e.setCnpj(dto.getCnpj()); e.setEmail(dto.getEmail());
        e.setTelefone(dto.getTelefone()); e.setEndereco(dto.getEndereco()); e.setAreas(dto.getAreas());
        Empresa saved = empresaRepository.save(e);
        EmpresaResponseDTO res = new EmpresaResponseDTO();
        res.setId(saved.getId()); res.setNome(saved.getNome()); res.setCnpj(saved.getCnpj());
        res.setEmail(saved.getEmail()); res.setTelefone(saved.getTelefone()); res.setEndereco(saved.getEndereco());
        res.setAreas(saved.getAreas());
        return res;
    }

    @GetMapping
    public List<EmpresaResponseDTO> all(){
        return empresaRepository.findAll().stream().map(e->{
            EmpresaResponseDTO r = new EmpresaResponseDTO();
            r.setId(e.getId()); r.setNome(e.getNome()); r.setCnpj(e.getCnpj()); r.setEmail(e.getEmail());
            r.setTelefone(e.getTelefone()); r.setEndereco(e.getEndereco()); r.setAreas(e.getAreas());
            return r;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<EmpresaResponseDTO> one(@PathVariable Long id){
        return empresaRepository.findById(id).map(e->{
            EmpresaResponseDTO r = new EmpresaResponseDTO();
            r.setId(e.getId()); r.setNome(e.getNome()); r.setCnpj(e.getCnpj()); r.setEmail(e.getEmail());
            r.setTelefone(e.getTelefone()); r.setEndereco(e.getEndereco()); r.setAreas(e.getAreas());
            return r;
        });
    }
}
