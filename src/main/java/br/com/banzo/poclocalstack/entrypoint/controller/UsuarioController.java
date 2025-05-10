package br.com.banzo.poclocalstack.entrypoint.controller;

import br.com.banzo.poclocalstack.dataprovider.entity.UsuarioEntity;
import br.com.banzo.poclocalstack.entrypoint.mapper.UsuarioMapper;
import br.com.banzo.poclocalstack.entrypoint.model.request.UsuarioRequest;
import br.com.banzo.poclocalstack.usecase.service.UsuarioUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {


    private final UsuarioUseCase usuarioUseCase;

    private final UsuarioMapper usuarioMapper;


    public UsuarioController(UsuarioUseCase usuarioUseCase, UsuarioMapper usuarioMapper) {
        this.usuarioUseCase = usuarioUseCase;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioEntity usuario = usuarioMapper.usuarioRequestToUsuario(usuarioRequest);
        usuarioUseCase.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity< List<UsuarioEntity>> listarUsuarioPorNome(@PathVariable(value = "nome") String nome){
        List<UsuarioEntity> usuarioResponse = usuarioUseCase.listarUsuarioPorNome(nome);
        return ResponseEntity.ok(usuarioResponse);
    }

    @GetMapping("nome/{nome}/id_usuario/{id_usuario}")
    public ResponseEntity< UsuarioEntity> buscarUsuarioPorNomeEIdUsuario(
            @PathVariable(value = "nome") String nome,
            @PathVariable(value = "id_usuario") String id_usuario){
        UsuarioEntity usuarioResponse = usuarioUseCase.buscarUsuarioPorNomeEIdUsuario(nome, id_usuario);
        return usuarioResponse == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(usuarioResponse);
    }

    @PutMapping("nome/{nome}/id_usuario/{id_usuario}")
    public ResponseEntity<Void> atualizarUsuarioPorNomeEIdUsuario(
            @PathVariable(value = "nome") String nome,
            @PathVariable(value = "id_usuario") String id_usuario,
            @RequestBody UsuarioRequest usuarioRequest){
        UsuarioEntity usuario = usuarioMapper.usuarioRequestToUsuario(usuarioRequest);
        UsuarioEntity usuarioAtualizado = usuarioUseCase.atualizarUsuarioPorNomeEIdUsuario(nome, id_usuario, usuario);
        return usuarioAtualizado == null ? ResponseEntity.notFound().build() : ResponseEntity.noContent().build();
    }

    @DeleteMapping("nome/{nome}/id_usuario/{id_usuario}")
    public ResponseEntity<Void> deletarUsuarioPorNomeEIdUsuario(
            @PathVariable(value = "nome") String nome,
            @PathVariable(value = "id_usuario") String id_usuario){
        UsuarioEntity usuarioAtualizado = usuarioUseCase.deletarUsuarioPorNomeEIdUsuario(nome, id_usuario);
        return ResponseEntity.ok().build();
    }

}
