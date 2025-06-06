package br.com.fiap.VIAF.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    // Getters e setters (ou lombok, se preferir)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
