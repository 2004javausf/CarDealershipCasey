package com.cardealer.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cardealer.beans.CarOwner;

public interface CarOwnerDAO {
	
	public void createCar() throws SQLException;	
	public ArrayList<CarOwner> getLot() throws SQLException;
	public ArrayList<CarOwner> getOwned(int userId) throws SQLException;
	public void removeCar(int carId) throws SQLException;

}
