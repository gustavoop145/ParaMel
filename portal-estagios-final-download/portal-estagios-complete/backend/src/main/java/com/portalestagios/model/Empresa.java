package com.portalestagios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private String areas; // vírgula-separadas

    public Empresa(){}
    // getters e setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}
    public String getCnpj(){return cnpj;}
    public void setCnpj(String cnpj){this.cnpj=cnpj;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getTelefone(){return telefone;}
    public void setTelefone(String telefone){this.telefone=telefone;}
    public String getEndereco(){return endereco;}
    public void setEndereco(String endereco){this.endereco=endereco;}
    public String getAreas(){return areas;}
    public void setAreas(String areas){this.areas=areas;}
}
