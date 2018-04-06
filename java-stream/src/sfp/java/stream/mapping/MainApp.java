package sfp.java.stream.mapping;

import java.util.Arrays;
import java.util.List;

import sfp.java.stream.Dish;

public class MainApp {

	public static void main(String[] args) {
		
		List<Dish> dishes = Arrays.asList(
				new Dish(10, "Vege1", true), 
				new Dish(10, "Vege2", true), 
				new Dish(10, "Vege3", true), 
				new Dish(30, "Meat1", false), 
				new Dish(30, "Meat2", false), 
				new Dish(30, "Meat3", false), 
				new Dish(40, "Fist1", false));

		// map the name of each dish
		// mapping a single field of an object
		// it is like 
		// in sql selecting a specific column value a for all rows
		dishes.stream()
		.map(Dish::getName)
		.forEach(d -> System.out.println("mapped-name terminal : " + d));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>..>>>>>>>>>>>> ");
		System.out.println();
		
		// map the length of the name of each dish
		dishes.stream()
		.map(Dish::getName)
		.map(String::length)
		.forEach(d -> System.out.println("mapped-name-length terminal : " + d));

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>..>>>>>>>>>>>> ");
		System.out.println();
		

		// incorrect way 
		// incorrect way 
		// map the distinct letters of all String
		Arrays.asList("Hello", "world").stream()
		.map(s->s.split(""))
		.distinct()
		.forEach(d -> System.out.println("flattening-string terminal : " + d));

	}
}
