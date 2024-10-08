package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.RegisterForAdminDTO;
import org.example.routes.Routes;
import org.example.service.CustomUserDetailsService;
import org.example.utils.Notice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável por operações administrativas relacionadas a usuários.
 * <p>
 * Este controlador permite a criação de novos usuários com privilégios de administrador.
 * </p>
 */
@RestController
@RequestMapping( Routes.ADMIN_ROUTE )
public class AdminController {

    private final CustomUserDetailsService customUserDetailsService;

    /**
     * Construtor da classe {@code AdminController}.
     * <p>
     * Injeta o serviço {@link CustomUserDetailsService} para lidar com a lógica de criação e gerenciamento de usuários.
     * </p>
     *
     * @param customUserDetailsService serviço responsável por criar e gerenciar usuários.
     */
    public AdminController ( CustomUserDetailsService customUserDetailsService ) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Endpoint para criar um novo usuário com privilégios administrativos.
     * <p>
     * Recebe os dados do novo usuário em formato JSON, valida esses dados e utiliza o serviço {@link CustomUserDetailsService}
     * para processar a criação do usuário.
     * </p>
     *
     * @param userData objeto {@link RegisterForAdminDTO} contendo os detalhes do novo usuário.
     * @return uma {@link ResponseEntity} com uma mensagem de sucesso e status HTTP 200 (OK).
     */
    @PostMapping( Routes.CREATE_ROUTE )
    public ResponseEntity<String> createAdmin ( @RequestBody @Valid RegisterForAdminDTO userData ) {
        customUserDetailsService.createForAdmin( userData.username(), userData.email(), userData.password(), userData.role() );
        return ResponseEntity.ok( Notice.USER_CREATED );
    }
}