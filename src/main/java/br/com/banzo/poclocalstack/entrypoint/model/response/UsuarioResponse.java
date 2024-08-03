package br.com.banzo.poclocalstack.entrypoint.model.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponse {

    private String nome;
    private UUID usuarioId;
    private String email;
}
