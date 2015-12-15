package jamesbaker.adventofcode.day15;

public class Ingredient {
	private final String name;
	private final Integer capacity;
	private final Integer durability;
	private final Integer flavor;
	private final Integer texture;
	private final Integer calories;
	
	public Ingredient(String name, Integer capacity, Integer durability, Integer flavor, Integer texture, Integer calories){
		this.name = name;
		this.capacity = capacity;
		this.durability = durability;
		this.flavor = flavor;
		this.texture = texture;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public Integer getDurability() {
		return durability;
	}

	public Integer getFlavor() {
		return flavor;
	}

	public Integer getTexture() {
		return texture;
	}

	public Integer getCalories() {
		return calories;
	}
}
