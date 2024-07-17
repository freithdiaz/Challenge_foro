package challege.foro.controller;

import challege.foro.domain.topicos.DatosListadoTopicos;
import challege.foro.domain.topicos.Topicos;
import challege.foro.domain.topicos.TopicosRepository;
import challege.foro.domain.usuarios.DatosAutenticacionUsuario;
import challege.foro.domain.usuarios.Usuario;
import challege.foro.domain.usuarios.UsuarioRepository;
import challege.foro.infra.security.DatosJWTToken;
import challege.foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.function.Function;

@RestController
@RequestMapping("/login")
public class AutenticacionnController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }


}
