package br.com.banzo.poclocalstack.usecase.impl;

import br.com.banzo.poclocalstack.dataprovider.entity.UsuarioEntity;
import br.com.banzo.poclocalstack.entrypoint.model.response.UsuarioResponse;
import br.com.banzo.poclocalstack.usecase.service.UsuarioUseCase;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final DynamoDbTemplate dynamoDbTemplate;


    public UsuarioUseCaseImpl(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    @Override
    public void salvarUsuario(UsuarioEntity usuarioEntity) {
        dynamoDbTemplate.save(usuarioEntity);
    }

    @Override
    public List<UsuarioEntity> listarUsuarioPorNome(String nome) {
        Key key = Key.builder().partitionValue(nome).build();
        QueryConditional conditional = QueryConditional.keyEqualTo(key);
        QueryEnhancedRequest query = QueryEnhancedRequest
                .builder()
                .queryConditional(conditional)
                .build();
        PageIterable<UsuarioEntity> usuarioEntityPageIterable = dynamoDbTemplate.query(query, UsuarioEntity.class);
        return usuarioEntityPageIterable.items().stream().toList();
    }

    @Override
    public UsuarioEntity buscarUsuarioPorNomeEIdUsuario(String nome, String idUsuario) {
        final Key key = Key
                .builder()
                .partitionValue(nome)
                .sortValue(idUsuario)
                .build();
        return dynamoDbTemplate.load(key, UsuarioEntity.class);
    }

    @Override
    public UsuarioEntity atualizarUsuarioPorNomeEIdUsuario(String nome, String idUsuario, UsuarioEntity usuarioEntity) {
        final Key key = Key
                .builder()
                .partitionValue(nome)
                .sortValue(idUsuario)
                .build();
        UsuarioEntity usuarioAtualizado = dynamoDbTemplate.load(key, UsuarioEntity.class);
        if (usuarioAtualizado == null){
            return null;
        }
        usuarioAtualizado.setNome(usuarioEntity.getNome());
        usuarioAtualizado.setEmail(usuarioEntity.getEmail());
        dynamoDbTemplate.save(usuarioAtualizado);
        return usuarioAtualizado;
    }

    @Override
    public UsuarioEntity deletarUsuarioPorNomeEIdUsuario(String nome, String idUsuario) {
        final Key key = Key
                .builder()
                .partitionValue(nome)
                .sortValue(idUsuario)
                .build();
        UsuarioEntity usuarioASerDeletado = dynamoDbTemplate.load(key, UsuarioEntity.class);
        if (usuarioASerDeletado == null){
            return null;
        }
        dynamoDbTemplate.delete(usuarioASerDeletado);
        return usuarioASerDeletado;
    }
}
