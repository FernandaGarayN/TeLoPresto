package cl.duoc.newrentacar.repository;


import cl.duoc.newrentacar.endpoint.model.Car;
import java.util.ArrayList;
import java.util.List;

public class DataBaseCars {

    public static List<Car> cars;

    private static void generateCarList(){
        cars = new ArrayList<>();
        Car carOne = new Car();
        carOne.setId(1);
        carOne.setBrand("Chevrolet");
        carOne.setModel("Sail");
        carOne.setPlateCode("BBCC-00");
        carOne.setColor("Blanco");
        carOne.setYear(2021);
        carOne.setCapacity(5);
        carOne.setCost(30000);
        cars.add(carOne);


        Car carTwo = new Car();
        carTwo.setId(2);
        carTwo.setBrand("Chevrolet");
        carTwo.setModel("Aveo");
        carTwo.setPlateCode("GG-EE-12");
        carTwo.setColor("Gris");
        carTwo.setYear(2021);
        carTwo.setCapacity(5);
        carTwo.setCost(28000);
        cars.add(carTwo);



        Car carThree = new Car();
        carThree.setId(3);
        carThree.setBrand("Opel");
        carThree.setModel("Astra");
        carThree.setPlateCode("QQ-RR-77");
        carThree.setColor("Negro");
        carThree.setYear(1982);
        carThree.setCapacity(4);
        carThree.setCost(40000);
        cars.add(carThree);




        Car carFour = new Car();
        carFour.setId(4);
        carFour.setBrand("Ford");
        carFour.setModel("Focus");
        carFour.setPlateCode("BH-TT-77");
        carFour.setColor("Blanco");
        carFour.setYear(2022);
        carFour.setCapacity(4);
        carFour.setCost(34000);
        cars.add(carFour);
    }

    public static List<Car> getAllCars(){
        if(cars == null){
            generateCarList();
        }
        return cars;
    }
}