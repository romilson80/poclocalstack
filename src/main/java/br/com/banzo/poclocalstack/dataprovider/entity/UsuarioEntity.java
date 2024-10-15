package br.com.banzo.poclocalstack.dataprovider.entity;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.UUID;

@Setter
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

    @DynamoDbPartitionKey
    @DynamoDbAttribute("nome")
    public String getNome() {
        return nome;
    }

    @DynamoDbAttribute("email")
    public String getEmail() {
        return email;
    }

}
