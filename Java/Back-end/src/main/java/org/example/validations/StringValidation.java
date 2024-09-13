package org.example.validations;

import org.example.exceptions.FieldStringInvalidException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * Classe responsável pela validação de campos do tipo String.
 * Fornece um método estático para verificar se uma String é válida.
 */
@Component
public class StringValidation {

    private static final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public static void validatePassword ( String password, String messageError ) {
        if ( ! Pattern.matches( REGEX, password ) ) {
            throw new BadCredentialsException( messageError );
        }
    }

    /**
     * Valida se a String fornecida não está vazia e não é nula.
     * Se a String for nula ou vazia, lança uma exceção com a mensagem de erro fornecida.
     *
     * @param string       a String a ser validada
     * @param messageError a mensagem de erro a ser lançada em caso de falha na validação
     * @throws FieldStringInvalidException se a String for nula ou vazia
     */
    public static void validate ( String string, String messageError ) throws FieldStringInvalidException {
        if ( string.isBlank() || string == null ) {
            throw new FieldStringInvalidException( messageError );
        }
    }
}