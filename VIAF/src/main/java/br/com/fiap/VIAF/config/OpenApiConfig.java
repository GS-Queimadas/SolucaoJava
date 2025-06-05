package br.com.fiap.VIAF.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "VIAF API",
                version = "1.0.0",
                description = "API RESTful para gerenciamento de dados sobre queimadas e ações de controle",
                contact = @Contact(
                        name = "Equipe VIAF: André, Isabela e Thaís",
                        url= "https://github.com/GS-Queimadas"
                )
        )
)
@Configuration
public class OpenApiConfig {

}
