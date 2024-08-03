package br.com.banzo.poclocalstack.dataprovider.entity;

import br.com.banzo.poclocalstack.entrypoint.model.request.UsuarioRequest;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.UUID;

@DynamoDbBean
public class UsuarioEntity {


    private UUID idUsuario;

    private String nome;

    private String email;

    @DynamoDbSortKey
    @DynamoDbAttribute("id_usuario")
    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @DynamoDbAttribute("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
