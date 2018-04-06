package sfp.java.stream.flattening;

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

		// incorrect way 
		// incorrect way 
		// map the distinct letters of all String
		Arrays.asList("Hello", "world").stream()
		.map(s-> { 
				System.out.println(s);
				return s.split("");
			})
		.distinct()
		.forEach(d -> System.out.println("incorrect1 terminal : " + d));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>..");
		System.out.println();
		
		// incorrect way 
		// incorrect way 
		// map the distinct letters of all String
		Arrays.asList("Hello", "world").stream()
		.map(s-> { 
				System.out.println(s);
				return s.split("");
			})
		.map(Arrays::stream)
		.distinct()
		.forEach(d -> System.out.println("incorrect2 terminal : " + d));

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>..");
		System.out.println();

		// correct way 
		// correct way 
		// map the distinct letters of all String
		Arrays.asList("Hello", "world").stream()
		
		.map(s-> s.split(""))    // this will make Stream<String[]>
		
		.flatMap(Arrays::stream) // this will make Stream<String>
								 // flatten each generated stream into one stream
		.distinct()
		.forEach(d -> System.out.println("flat-map terminal : " + d));
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>..");
		System.out.println();
		
		// advanced 
		// make pair from two list of numbers 
		// input: [1,2,3] and [5,6]
		// output: [[1,2], [1,5], [2,5], [2,6], [3,5], [3,6]]
		List<Integer> numberGroup1 = Arrays.asList(1, 2, 3);
		List<Integer> numberGroup2 = Arrays.asList(5, 6);
		
		numberGroup1.stream()
					.flatMap(i -> numberGroup2.stream()
											  .map(j -> new int[] {i,j}))
					.forEach(arr -> System.out.println(arr[0] + "  " + arr[1]));
		
		// advanced 
		// make pair from two list of numbers and 
		// filter the pair where i+j%2 ==0  
		// input: [1,2,3] and [5,6]
		// output: [[1,5], [2,6], [3,5]]
		
		numberGroup1.stream()
					.flatMap(i -> numberGroup2.stream()
											  .filter(j -> (i+j) %2 == 0)	
											  .map(j -> new int[] {i,j}))
					.forEach(arr -> System.out.println(arr[0] + "  " + arr[1]));		

	}
}
