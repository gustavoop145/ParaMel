package com.portalestagios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vagas")
public class Vaga {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(length = 2000)
    private String descricao;
    private String area;
    private String localizacao;
    private String modalidade; // REMOTO/PRESENCIAL/HIBRIDO
    private String cargaHoraria;
    private String requisitos;
    private boolean encerrada = false;

    @ManyToOne
    private Empresa empresa;

    public Vaga(){}
    // getters e setters (omitted for brevity)
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitulo(){return titulo;}
    public void setTitulo(String t){this.titulo=t;}
    public String getDescricao(){return descricao;}
    public void setDescricao(String d){this.descricao=d;}
    public String getArea(){return area;}
    public void setArea(String a){this.area=a;}
    public String getLocalizacao(){return localizacao;}
    public void setLocalizacao(String l){this.localizacao=l;}
    public String getModalidade(){return modalidade;}
    public void setModalidade(String m){this.modalidade=m;}
    public String getCargaHoraria(){return cargaHoraria;}
    public void setCargaHoraria(String c){this.cargaHoraria=c;}
    public String getRequisitos(){return requisitos;}
    public void setRequisitos(String r){this.requisitos=r;}
    public boolean isEncerrada(){return encerrada;}
    public void setEncerrada(boolean e){this.encerrada=e;}
    public Empresa getEmpresa(){return empresa;}
    public void setEmpresa(Empresa e){this.empresa=e;}
}
