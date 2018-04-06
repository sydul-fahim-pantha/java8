package sfp.java.stream.limit.and.skip;

public class Dish {
	
	private int calories;
	private String name;
	private boolean vege;
	
	public Dish(int calories, String name, boolean vege) {
		this.calories = calories;
		this.name = name;
		this.vege = vege;
	}
	
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isVege() {
		return vege;
	}

	public void setVege(boolean vege) {
		this.vege = vege;
	}
	
	@Override
	public int hashCode() {
		System.out.println(">>>>>>>.hashCode called for   " + this.getName());
		return calories;
	}
	
	@Override
	public boolean equals(Object obj) {
		Dish d = (Dish)obj;
		System.out.println(">>>>>>>. equals called for " + this.getName());
		System.out.println(">>>>>>>. equals other d " + d.getName());
		return name.equals(((Dish)obj).getName()) && calories == obj.hashCode();
	}
}
