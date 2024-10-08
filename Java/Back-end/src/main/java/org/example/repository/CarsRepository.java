package org.example.repository;

import org.example.exceptions.FieldDoubleInvalidException;
import org.example.exceptions.FieldIntegerInvalidException;
import org.example.exceptions.FieldStringInvalidException;
import org.example.exceptions.ResourceNotFoundException;
import org.example.model.Cars;
import org.example.utils.QueryMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações CRUD e consultas personalizadas relacionadas a carros.
 * <p>
 * Este repositório fornece métodos para consultar carros com base em diversos critérios, como modelo, valor, ano de produção, fabricante, tipo de motor, etc.
 * </p>
 */
@Repository
public interface CarsRepository extends MongoRepository<Cars, String>, PagingAndSortingRepository<Cars, String> {

    /**
     * Verifica se o modelo pesquisado existe e retorna o carro correspondente.
     *
     * @param model O modelo do carro.
     * @return O carro com o modelo correspondente.
     * @throws ResourceNotFoundException Se o modelo não for encontrado.
     */
    @Query( QueryMongo.FIND_BY_MODEL )
    Cars findByModel ( String model ); // Concluido

    /**
     * Retorna uma lista de carros cujo valor é menor do que o valor pesquisado.
     *
     * @param value O valor a ser comparado.
     * @return Uma lista de carros com valor menor que o valor fornecido.
     * @throws ResourceNotFoundException Se nenhum carro for encontrado.
     */
    @Query( QueryMongo.FIND_BY_LESS_VALUE )
    List<Cars> findByLessThanValue ( Double value ); // Concluido

    /**
     * Retorna uma lista de carros cujo valor é igual ao valor fornecido.
     *
     * @param value O valor a ser comparado.
     * @return Uma lista de carros com valor igual ao fornecido.
     * @throws ResourceNotFoundException   Se nenhum carro for encontrado.
     * @throws FieldDoubleInvalidException Se o valor fornecido for inválido.
     */
    @Query( QueryMongo.FIND_BY_VALUE )
    List<Cars> findByValue ( Double value ); // Concluido

    /**
     * Retorna uma lista de carros cujo valor é maior que o valor fornecido.
     *
     * @param value O valor a ser comparado.
     * @return Uma lista de carros com valor maior que o valor fornecido.
     * @throws ResourceNotFoundException   Se nenhum carro for encontrado.
     * @throws FieldDoubleInvalidException Se o valor fornecido for inválido.
     */
    @Query( QueryMongo.FIND_BY_BIGGER_VALUE )
    List<Cars> findBiggerThanValue ( Double value ); // Concluido

    /**
     * Retorna uma lista de carros com o ano correspondente ao ano fornecido.
     *
     * @param year O ano a ser comparado.
     * @return Uma lista de carros com o ano correspondente.
     * @throws ResourceNotFoundException    Se nenhum carro for encontrado.
     * @throws FieldIntegerInvalidException Se o ano fornecido for inválido.
     */
    @Query( QueryMongo.FIND_BY_YEAR )
    List<Cars> findByYear ( Integer year ); // Concluido

    /**
     * Retorna uma lista de carros cujo ano é mais recente que o ano fornecido.
     *
     * @param year O ano a ser comparado.
     * @return Uma lista de carros mais novos que o ano fornecido.
     * @throws ResourceNotFoundException    Se nenhum carro for encontrado.
     * @throws FieldIntegerInvalidException Se o ano fornecido for inválido.
     */
    @Query( QueryMongo.FIND_BY_NEWER_YEAR )
    List<Cars> findNewerThanYear ( Integer year ); // Concluido

    /**
     * Retorna uma lista de carros cujo ano é mais antigo que o ano fornecido.
     *
     * @param year O ano a ser comparado.
     * @return Uma lista de carros mais antigos que o ano fornecido.
     * @throws ResourceNotFoundException    Se nenhum carro for encontrado.
     * @throws FieldIntegerInvalidException Se o ano fornecido for inválido.
     */
    @Query( QueryMongo.FIND_BY_OLDER_YEAR )
    List<Cars> findOlderThanYear ( Integer year ); // Concluido

    /**
     * Retorna uma lista de carros produzidos pela fabricante fornecida.
     *
     * @param producedBy O nome da fabricante.
     * @return Uma lista de carros produzidos pela fabricante fornecida.
     * @throws ResourceNotFoundException   Se nenhum carro for encontrado.
     * @throws FieldStringInvalidException Se o nome da fabricante for inválido.
     */
    @Query( QueryMongo.FIND_BY_PRODUCEDBY )
    List<Cars> findProducedBy ( String producedBy );

    /**
     * Retorna uma lista de carros com o tipo de motor fornecido.
     *
     * @param engineType O tipo de motor.
     * @return Uma lista de carros com o tipo de motor fornecido.
     * @throws ResourceNotFoundException   Se nenhum carro for encontrado.
     * @throws FieldStringInvalidException Se o tipo de motor for inválido.
     */
    @Query( QueryMongo.FIND_BY_ENGINE_TYPE )
    List<Cars> findByEngineType ( String engineType );

    /**
     * Retorna uma lista de carros cuja velocidade máxima contém o número fornecido.
     *
     * @param topSpeed A velocidade máxima a ser verificada.
     * @return Uma lista de carros com a velocidade máxima contendo o número fornecido.
     * @throws ResourceNotFoundException   Se nenhum carro for encontrado.
     * @throws FieldStringInvalidException Se a velocidade fornecida for inválida.
     */
    @Query( QueryMongo.FIND_BY_TOP_SPEED )
    List<Cars> findByTopSpeed ( String topSpeed );

    /**
     * Retorna uma lista de carros com a feature fornecida.
     *
     * @param features A feature a ser verificada.
     * @return Uma lista de carros com a feature fornecida.
     * @throws ResourceNotFoundException   Se nenhuma feature correspondente for encontrada.
     * @throws FieldStringInvalidException Se a feature fornecida for inválida.
     */
    @Query( QueryMongo.FIND_BY_FEATURE )
    List<Cars> findByFeature ( String features );
}

