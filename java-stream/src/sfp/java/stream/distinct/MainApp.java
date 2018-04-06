package sfp.java.stream.distinct;

import java.util.Arrays;
import java.util.List;

import sfp.java.stream.Dish;

public class MainApp {

	public static void main(String[] args) {
		
		List<Dish> dishes = Arrays.asList(new Dish(10, "Vege1", true), new Dish(10, "Vege2", true), new Dish(10, "Vege3", true), new Dish(30, "Meat1", false), new Dish(40, "Fist1", false));

		// filter the distinct 
		// distinct requires to 
		// overriding the hashCode() and equals() method
		dishes.stream()
		.filter(Dish::isVege)
		.distinct()
		.forEach(d -> System.out.println("terminal : " + d.getName()));
	}
}
