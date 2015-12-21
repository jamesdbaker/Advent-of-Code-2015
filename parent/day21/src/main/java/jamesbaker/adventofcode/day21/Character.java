package jamesbaker.adventofcode.day21;

public class Character {
	private Integer hitPoints;
	private Integer initialDamage;
	private Integer initialArmor;
	
	private Item weapon = null;
	private Item armor = null;
	private Item ring1 = null;
	private Item ring2 = null;
	
	public Character(Integer hitPoints, Integer damage, Integer armor){
		this.hitPoints = hitPoints;
		this.initialDamage = damage;
		this.initialArmor = armor;
	}

	public Integer getHitPoints() {
		return hitPoints;
	}

	public void doDamage(Integer damage) {
		hitPoints -= damage;
	}
	
	public boolean isDead(){
		return hitPoints <= 0;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing1() {
		return ring1;
	}

	public void setRing1(Item ring1) {
		this.ring1 = ring1;
	}

	public Item getRing2() {
		return ring2;
	}

	public void setRing2(Item ring2) {
		this.ring2 = ring2;
	}
	
	public Integer getDamageScore(){
		Integer damage = initialDamage;
		
		if(weapon != null)
			damage += weapon.getDamage();
		
		if(armor != null)
			damage += armor.getDamage();
		
		if(ring1 != null)
			damage += ring1.getDamage();
		
		if(ring2 != null)
			damage += ring2.getDamage();
		
		return damage;
	}
	
	public Integer getArmorScore(){
		Integer armorScore = initialArmor;
		
		if(weapon != null)
			armorScore += weapon.getArmor();
		
		if(armor != null)
			armorScore += armor.getArmor();
		
		if(ring1 != null)
			armorScore += ring1.getArmor();
		
		if(ring2 != null)
			armorScore += ring2.getArmor();
		
		return armorScore;
	}
}
