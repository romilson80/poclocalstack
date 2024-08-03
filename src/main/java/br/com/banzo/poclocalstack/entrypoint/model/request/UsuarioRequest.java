package br.com.banzo.poclocalstack.entrypoint.model.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequest {

    private String nome;
    private UUID usuarioId;
    private String email;
}
