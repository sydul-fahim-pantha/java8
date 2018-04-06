package sfp.java.stream.limit.and.skip;

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

		// limit to 3 element 
		dishes.stream()
		.limit(3)
		.forEach(d -> System.out.println("limit terminal : " + d.getName()));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> ");
		System.out.println();
		
		// skip first three  
		// no vege will be shown
		dishes.stream()
		.skip(3)
		.forEach(d -> System.out.println("skip terminal : " + d.getName()));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> ");
		System.out.println();
		
		// skip first three and select 2  
		// it's like the database sql 
		// offset 3 and limit 2 
		dishes.stream()
		.skip(3)
		.limit(2)
		.forEach(d -> System.out.println("skip-limit terminal : " + d.getName()));
	}
}
