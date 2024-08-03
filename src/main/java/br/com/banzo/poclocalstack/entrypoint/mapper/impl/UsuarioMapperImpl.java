package br.com.banzo.poclocalstack.entrypoint.mapper.impl;

import br.com.banzo.poclocalstack.dataprovider.entity.UsuarioEntity;
import br.com.banzo.poclocalstack.entrypoint.mapper.UsuarioMapper;
import br.com.banzo.poclocalstack.entrypoint.model.request.UsuarioRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {
    @Override
    public UsuarioEntity usuarioRequestToUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setEmail(usuarioRequest.getEmail());
        usuarioEntity.setNome(usuarioRequest.getNome());
        usuarioEntity.setIdUsuario(UUID.randomUUID());
        return usuarioEntity;

    }
}
