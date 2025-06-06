package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.DomainModel.Usuario;
import br.com.fiap.VIAF.Dto.LoginDTO;
import br.com.fiap.VIAF.Dto.TokenDTO;
import br.com.fiap.VIAF.service.TokenService;
import br.com.fiap.VIAF.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager,
                          UsuarioService usuarioService,
                          TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken dadosLogin =
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());

        try {
            authenticationManager.authenticate(dadosLogin);

            Usuario usuario = (Usuario) usuarioService.loadUserByUsername(loginDTO.getEmail());

            String token = tokenService.gerarToken(usuario.getEmail());

            return ResponseEntity.ok(new TokenDTO(token));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }
}

