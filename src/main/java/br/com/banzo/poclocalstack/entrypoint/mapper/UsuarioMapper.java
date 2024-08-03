package br.com.banzo.poclocalstack.entrypoint.mapper;

import br.com.banzo.poclocalstack.dataprovider.entity.UsuarioEntity;
import br.com.banzo.poclocalstack.entrypoint.model.request.UsuarioRequest;

public interface UsuarioMapper {

    UsuarioEntity usuarioRequestToUsuario(UsuarioRequest usuarioRequest);
}
