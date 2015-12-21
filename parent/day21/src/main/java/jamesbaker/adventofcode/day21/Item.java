package jamesbaker.adventofcode.day21;

public class Item {
	private final Integer cost;
	private final Integer damage;
	private final Integer armor;
	
	public Item(Integer cost, Integer damage, Integer armor){
		this.cost = cost;
		this.damage = damage;
		this.armor = armor;
	}

	public Integer getCost() {
		return cost;
	}

	public Integer getDamage() {
		return damage;
	}

	public Integer getArmor() {
		return armor;
	}
	
	@Override
	public String toString(){
		return "Cost: " + getCost() + ", Damage: " + getDamage() + ", Armor: " + getArmor();
	}
}
