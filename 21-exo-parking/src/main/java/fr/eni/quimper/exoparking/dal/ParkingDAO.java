package fr.eni.quimper.exoparking.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.quimper.exoparking.bo.Parking;

public interface ParkingDAO extends CrudRepository<Parking, Integer>{

}
