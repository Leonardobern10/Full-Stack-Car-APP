package org.example.service.SearchInteger;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.service.strategies.StrategyGetCarsForYear;
import org.example.validations.IntegerValidation;

import java.util.List;

public class SearchByNewerYear implements StrategyGetCarsForYear {

    private final CarsRepository carsRepository;

    public SearchByNewerYear ( CarsRepository carsRepository ) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Cars> search ( Integer year ) {
        IntegerValidation.validate( year );
        return carsRepository.findNewerThanYear( year );
    }
}