package br.com.banzo.poclocalstack.usecase.service;

import br.com.banzo.poclocalstack.dataprovider.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioUseCase {

    void salvarUsuario(UsuarioEntity usuarioEntity);

    List<UsuarioEntity> listarUsuarioPorNome(String nome);

    UsuarioEntity buscarUsuarioPorNomeEIdUsuario(String nome, String idUsuario);

    UsuarioEntity atualizarUsuarioPorNomeEIdUsuario(String nome, String idUsuario, UsuarioEntity usuarioEntity);

    UsuarioEntity deletarUsuarioPorNomeEIdUsuario(String nome, String idUsuario);
}
