package sfp.java.stream.internal.and.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {

	public static void main(String[] args) {
		
		List<Dish> dishes = Arrays.asList(new Dish(10, "Dish1"), new Dish(20, "Dish2"), new Dish(30, "Dish3"), new Dish(40, "Dish4"));
		
		// test intermediate 
		Stream<String> stream = dishes.stream()
			  .filter(d -> d.getCalories() > 20)
			  .map(Dish::getName)
			  .limit(2);
			  
		// test terminal
			  stream.collect(Collectors.toList()).forEach(System.out::println);
	}
	
}
