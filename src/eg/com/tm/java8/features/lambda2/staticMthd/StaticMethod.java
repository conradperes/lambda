package eg.com.tm.java8.features.lambda2.staticMthd;

import static eg.com.tm.java8.features.lambda2.mthdRefs.VehicleInterface.getVehicleInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static java.lang.System.out;
import eg.com.tm.java8.features.lambda2.mthdRefs.Car;

public class StaticMethod {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		List<Car> cars = new ArrayList<>(4);

		cars.add(new Car("Mazda 3", "Mazda", 1600, 2008));
		cars.add(new Car("Mazda 6", "Mazda", 2500, 2009));
		cars.add(new Car("Mazda 2", "Mazda", 1400, 2008));
		cars.add(new Car("Mazda X5", "Mazda", 3600, 2014));

		Predicate<Car> pred = (v) -> v.getCC() > 1900 & v.getMakeYear() <= 2009;
		cars.forEach((Car c) -> {
			if (pred.test(c)) {
				// String info = c.getName()
				// + ", of Model [" + c.getModel() + "], with "
				// + c.getCC() + " (litter), manufactured at "
				// + c.getMakeYear();
				out.println(getVehicleInfo(c));
			}
		});
	}
}