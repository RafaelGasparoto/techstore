package br.com.rafael.techstore.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto implements Serializable {
    @NotBlank(message = "firstName obrigatório")
    private String firstName;
    
    @NotBlank(message = "lastName obrigatório")
    private String lastName;
    
    @NotBlank(message = "username obrigatório")
    private String username;

    @NotBlank(message = "password obrigatório")
    private String password;

    @NotBlank(message = "email obrigatório")
    private String email;
}
