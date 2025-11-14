package com.portalestagios.controller;

import com.portalestagios.dto.vaga.VagaRequestDTO;
import com.portalestagios.dto.vaga.VagaResponseDTO;
import com.portalestagios.model.Empresa;
import com.portalestagios.model.Vaga;
import com.portalestagios.repository.EmpresaRepository;
import com.portalestagios.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {
    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private VagaResponseDTO toDto(Vaga v){
        VagaResponseDTO r = new VagaResponseDTO();
        r.setId(v.getId()); r.setTitulo(v.getTitulo()); r.setDescricao(v.getDescricao());
        r.setArea(v.getArea()); r.setLocalizacao(v.getLocalizacao()); r.setModalidade(v.getModalidade());
        r.setCargaHoraria(v.getCargaHoraria()); r.setRequisitos(v.getRequisitos()); r.setEncerrada(v.isEncerrada());
        if(v.getEmpresa()!=null){ r.setEmpresaId(v.getEmpresa().getId()); r.setEmpresaNome(v.getEmpresa().getNome()); }
        return r;
    }

    @GetMapping
    public List<VagaResponseDTO> all(){ return vagaRepository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }

    @GetMapping("/abertas")
    public List<VagaResponseDTO> abertas(){ return vagaRepository.findByEncerradaFalse().stream().map(this::toDto).collect(Collectors.toList()); }

    @PostMapping
    @PreAuthorize("hasRole('EMPRESA') or hasRole('ADMIN')")
    public VagaResponseDTO create(@RequestBody @jakarta.validation.Valid VagaRequestDTO dto){
        Vaga v = new Vaga();
        v.setTitulo(dto.getTitulo()); v.setDescricao(dto.getDescricao()); v.setArea(dto.getArea());
        v.setLocalizacao(dto.getLocalizacao()); v.setModalidade(dto.getModalidade()); v.setCargaHoraria(dto.getCargaHoraria());
        v.setRequisitos(dto.getRequisitos());
        if(dto.getEmpresaId()!=null){
            Empresa e = empresaRepository.findById(dto.getEmpresaId()).orElse(null);
            v.setEmpresa(e);
        }
        Vaga saved = vagaRepository.save(v);
        return toDto(saved);
    }

    @GetMapping("/{id}")
    public Optional<VagaResponseDTO> one(@PathVariable Long id){ return vagaRepository.findById(id).map(this::toDto); }

    @PutMapping("/{id}/encerrar")
    @PreAuthorize("hasRole('EMPRESA') or hasRole('ADMIN')")
    public VagaResponseDTO fechar(@PathVariable Long id){
        Vaga v = vagaRepository.findById(id).orElseThrow();
        v.setEncerrada(true);
        return toDto(vagaRepository.save(v));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EMPRESA') or hasRole('ADMIN')")
    public VagaResponseDTO update(@PathVariable Long id, @RequestBody @jakarta.validation.Valid VagaRequestDTO dto){
        Vaga v = vagaRepository.findById(id).orElseThrow();
        v.setTitulo(dto.getTitulo()); v.setDescricao(dto.getDescricao()); v.setArea(dto.getArea());
        v.setLocalizacao(dto.getLocalizacao()); v.setModalidade(dto.getModalidade()); v.setCargaHoraria(dto.getCargaHoraria());
        v.setRequisitos(dto.getRequisitos());
        if(dto.getEmpresaId()!=null){
            Empresa e = empresaRepository.findById(dto.getEmpresaId()).orElse(null);
            v.setEmpresa(e);
        }
        return toDto(vagaRepository.save(v));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EMPRESA') or hasRole('ADMIN')")
    public void delete(@PathVariable Long id){ vagaRepository.deleteById(id); }
}
