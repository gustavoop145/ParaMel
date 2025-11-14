package com.portalestagios.dto.vaga;

import com.portalestagios.model.Empresa;

public class VagaResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String area;
    private String localizacao;
    private String modalidade;
    private String cargaHoraria;
    private String requisitos;
    private boolean encerrada;
    private Long empresaId;
    private String empresaNome;

    public VagaResponseDTO(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
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
    public boolean isEncerrada(){return encerrada;}
    public void setEncerrada(boolean encerrada){this.encerrada=encerrada;}
    public Long getEmpresaId(){return empresaId;}
    public void setEmpresaId(Long empresaId){this.empresaId=empresaId;}
    public String getEmpresaNome(){return empresaNome;}
    public void setEmpresaNome(String empresaNome){this.empresaNome=empresaNome;}
}
