package eg.com.tm.java8.features.lambda2.mthdRefs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static java.lang.System.out;

public class DefaultMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<VehicleInterface> cars = Arrays.asList(new Car("Mazda 3", "Mazda", 1600, 2008),
                                                    new Car("Mazda 6", "Mazda", 2500, 2009),
                                                    new Car("Mazda 2", "Mazda", 1400, 2008),
                                                    new Car("Mazda X5", "Mazda", 3600, 2014));

        Predicate<VehicleInterface> pred = (v) -> v.getCC() > 1900
                & v.getMakeYear() <= 2009;
        cars.forEach(c -> {
            if (pred.test(c)) {
//                String info = c.getName() 
//                              + ", of Model [" + c.getModel() + "], with "
//                              + c.getCC() + " (litter), manufactured at "
//                              + c.getMakeYear();
                out.println(c.getInfo());
            }
        });
    }
}