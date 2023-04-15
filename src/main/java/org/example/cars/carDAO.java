package org.example.cars;


import java.sql.SQLException;
import java.util.ArrayList;

public interface carDAO {
    public void addCar(modules car) throws SQLException;


    void removeCar(modules car) throws SQLException;

    modules getCar(String model) throws SQLException;

    public ArrayList<modules> getAllCars() throws SQLException;



}
