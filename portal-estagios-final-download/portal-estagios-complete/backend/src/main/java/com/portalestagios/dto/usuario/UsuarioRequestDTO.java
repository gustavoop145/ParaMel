package com.portalestagios.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDTO {
    @NotBlank
    private String nome;
    @Email @NotBlank
    private String email;
    @NotBlank
    private String senha;
    private String perfil;

    public UsuarioRequestDTO() {}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getSenha(){return senha;}
    public void setSenha(String senha){this.senha=senha;}
    public String getPerfil(){return perfil;}
    public void setPerfil(String perfil){this.perfil=perfil;}
}
