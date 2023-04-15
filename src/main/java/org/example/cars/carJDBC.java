package org.example.cars;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class carJDBC implements carDAO{
    private Connection connection;

    public carJDBC(String url, String user, String password)throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(url, user, password);
    }
    @Override
    public void addCar(modules car) throws SQLException {
        String sql = "insert into car(id,model, year, milleage)"
                + "values (?,?,?,?)";
        PreparedStatement ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, car.getId());
        ps.setString(2, car.getModel());
        ps.setInt(3, car.getYear());
        ps.setInt(4, car.getMilleage());

        ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            car.setId(generatedKeys.getInt(1));
        }

    }

    @Override
    public void removeCar(modules car) throws SQLException {
        String sql = "delete from car where id = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, car.getId());
        ps.executeUpdate();

    }


    @Override
    public modules getCar(String model) throws SQLException {
        ArrayList<modules> array = getAllCars();
        for (modules car : array) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;

    }

    @Override
    public ArrayList<modules> getAllCars() throws SQLException {
        ArrayList<modules> array = new ArrayList<modules>();
        ResultSet result = this.connection.prepareStatement("select * from car").executeQuery();
        while (result.next()) {
            modules car = new modules();
            car.setModel(result.getString("model"));
            car.setYear(result.getInt("year"));
            car.setMilleage(result.getInt("milleage"));
            array.add(car);
        }
        result.close();
        return array;
    }


}
