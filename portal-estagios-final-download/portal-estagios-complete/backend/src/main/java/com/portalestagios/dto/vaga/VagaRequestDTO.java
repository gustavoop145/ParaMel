package com.portalestagios.dto.vaga;

import jakarta.validation.constraints.NotBlank;

public class VagaRequestDTO {
    @NotBlank
    private String titulo;
    private String descricao;
    private String area;
    private String localizacao;
    private String modalidade;
    private String cargaHoraria;
    private String requisitos;
    private Long empresaId;

    public VagaRequestDTO(){}
    public String getTitulo(){return titulo;}
    public void setTitulo(String titulo){this.titulo=titulo;}
    public String getDescricao(){return descricao;}
    public void setDescricao(String descricao){this.descricao=descricao;}
    public String getArea(){return area;}
    public void setArea(String area){this.area=area;}
    public String getLocalizacao(){return localizacao;}
    public void setLocalizacao(String localizacao){this.localizacao=localizacao;}
    public String getModalidade(){return modalidade;}
    public void setModalidade(String modalidade){this.modalidade=modalidade;}
    public String getCargaHoraria(){return cargaHoraria;}
    public void setCargaHoraria(String cargaHoraria){this.cargaHoraria=cargaHoraria;}
    public String getRequisitos(){return requisitos;}
    public void setRequisitos(String requisitos){this.requisitos=requisitos;}
    public Long getEmpresaId(){return empresaId;}
    public void setEmpresaId(Long empresaId){this.empresaId=empresaId;}
}
