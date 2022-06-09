package web.dao;
import org.springframework.stereotype.Repository;
import web.models.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



@Repository
public class CarDAOImpl implements CarDAO {
    private AtomicInteger AUTO_ID = new AtomicInteger(1);
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(AUTO_ID.getAndIncrement(), "HONDA", "2012"));
        cars.add(new Car(AUTO_ID.getAndIncrement(), "PONTIAC", "2002"));
        cars.add(new Car(AUTO_ID.getAndIncrement(), "MERCEDES", "2022"));
        cars.add(new Car(AUTO_ID.getAndIncrement(), "BMW", "2011"));
        cars.add(new Car(AUTO_ID.getAndIncrement(), "HYUNDAI", "2021"));

    }

    @Override
    public List<Car> getCars(int count) {

        if(count >= 5){
            return cars;
        }else{
            return cars.stream().limit(count).toList();
        }

    }
}
