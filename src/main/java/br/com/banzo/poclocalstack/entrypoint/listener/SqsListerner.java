package br.com.banzo.poclocalstack.entrypoint.listener;

import br.com.banzo.poclocalstack.dataprovider.entity.UsuarioEntity;
import br.com.banzo.poclocalstack.entrypoint.mapper.UsuarioMapper;
import br.com.banzo.poclocalstack.entrypoint.model.request.UsuarioRequest;
import br.com.banzo.poclocalstack.usecase.service.UsuarioUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsListerner {


    private final ObjectMapper objectMapper;

    private final UsuarioMapper usuarioMapper;

    private final UsuarioUseCase usuarioUseCase;

    public SqsListerner(ObjectMapper objectMapper, UsuarioMapper usuarioMapper, UsuarioUseCase usuarioUseCase) {
        this.objectMapper = objectMapper;
        this.usuarioMapper = usuarioMapper;
        this.usuarioUseCase = usuarioUseCase;
    }


    @SqsListener(value = "${sqs.queue-name}")
    public void receiverMessage(final String message) throws JsonProcessingException {
        try {
            UsuarioRequest usuarioRequest = objectMapper.readValue(message, UsuarioRequest.class);
            final UsuarioEntity usuario = usuarioMapper.usuarioRequestToUsuario(usuarioRequest);
            usuarioUseCase.salvarUsuario(usuario);
            log.info(message);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
