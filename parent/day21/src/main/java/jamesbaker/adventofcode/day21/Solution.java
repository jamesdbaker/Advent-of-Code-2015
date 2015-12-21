package jamesbaker.adventofcode.day21;

public class Solution {

	public static void main(String[] args) {
		Item[] weapons = new Item[]{
			new Item(8, 4, 0),		//Dagger
			new Item(10, 5, 0),		//Shortsword
			new Item(25, 6, 0),		//Warhammer
			new Item(40, 7, 0),		//Longsword
			new Item(74, 8, 0)		//Greataxe
		};
		
		Item[] armor = new Item[]{
			new Item(0, 0, 0),		//No armor
			new Item(13, 0, 1),		//Leather
			new Item(31, 0, 2),		//Chainmail
			new Item(53, 0, 3),		//Splintmail
			new Item(75, 0, 4),		//Bandedmail
			new Item(102, 0, 5)		//Platemail
		};
		
		Item[] rings = new Item[]{
			new Item(0, 0, 0),		//No ring (left hand)
			new Item(0, 0, 0),		//No ring (right hand)
			new Item(25, 1, 0),		//Damage 1
			new Item(50, 2, 0),		//Damage 2
			new Item(100, 3, 0),	//Damage 3
			new Item(20, 0, 1),		//Defence 1
			new Item(40, 0, 2),		//Defence 2
			new Item(80, 0, 3)		//Defence 3
		};
		
		Integer lowestWinningCost = Integer.MAX_VALUE;
		Integer highestLosingCost = Integer.MIN_VALUE;
		
		for(Item w : weapons){
			for(Item a : armor){
				for(Item r1 : rings){
					for(Item r2 : rings){
						if(r1 == r2)
							continue;
						
						Character boss = new Character(100, 8, 2);
						
						Character player = new Character(100, 0, 0);
						player.setWeapon(w);
						player.setArmor(a);
						player.setRing1(r1);
						player.setRing2(r2);
						
						if(doBattle(player, boss)){
							if(w.getCost() + a.getCost() + r1.getCost() + r2.getCost() < lowestWinningCost)
								lowestWinningCost = w.getCost() + a.getCost() + r1.getCost() + r2.getCost();
						}else{
							if(w.getCost() + a.getCost() + r1.getCost() + r2.getCost() > highestLosingCost)
								highestLosingCost = w.getCost() + a.getCost() + r1.getCost() + r2.getCost();
						}
					}
				}
			}
		}
		
		System.out.println("Part 1: " + lowestWinningCost);
		System.out.println("Part 2: " + highestLosingCost);
	}
	
	private static boolean doBattle(Character player, Character enemy){
		boolean playersTurn = true;
		while(!player.isDead() && !enemy.isDead()){
			if(playersTurn){
				enemy.doDamage(Math.max(1, player.getDamageScore() - enemy.getArmorScore()));
			}else{
				player.doDamage(Math.max(1, enemy.getDamageScore() - player.getArmorScore()));
			}
			playersTurn = !playersTurn;
		}
		
		return enemy.isDead();
	}

}
