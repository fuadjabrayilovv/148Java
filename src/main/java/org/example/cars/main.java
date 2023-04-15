package org.example.cars;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/solution";
        String username = "postgres";
        String password = "fuadfuad";
        carJDBC cjdbc = new carJDBC(url,username,password);


       modules car = new modules();

        car.setId(10);
        car.setModel("Mercedes A-Class");
        car.setYear(2018);
        car.setMilleage(190000);
        cjdbc.addCar(car);



/*        ArrayList<modules> array = cjdbc.getAllCars();

        for (modules i : array) {
            System.out.println("car model: " + i.getModel() +
                    ",year: " + i.getYear() + "mileage:" + i.getMilleage());
        }

 */
//        System.out.println(cjdbc.getCar("Corolla").getYear());
//        cjdbc.removeCar(car);



    }

}
