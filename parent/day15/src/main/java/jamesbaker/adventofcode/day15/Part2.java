package jamesbaker.adventofcode.day15;

public class Part2 {
	private static final Ingredient A = new Ingredient("Frosting", 4, -2, 0, 0, 5);
	private static final Ingredient B = new Ingredient("Candy", 0, 5, -1, 0, 8);
	private static final Ingredient C = new Ingredient("Butterscotch", -1, 0, 5, 0, 6);
	private static final Ingredient D = new Ingredient("Sugar", 0, 0, -2, 2, 1);
	
	public static void main(String[] args) {
		Integer maxScore = 0;
		for(Integer a = 0; a <= 100; a++){
			for(Integer b = 0; b <= 100; b++){
				if(a + b > 100){
					break;
				}
				for(Integer c = 0; c <= 100; c++){
					if(a + b + c > 100){
						break;
					}
					for(Integer d = 0; d <= 100; d++){
						if(a + b + c + d > 100){
							break;
						}
						if(a + b + c + d != 100){
							continue;
						}
						if(a*A.getCalories() + b*B.getCalories() + c*C.getCalories() + d*D.getCalories() != 500){
							continue;
						}
						
						maxScore = Math.max(score(a, b, c, d), maxScore);
					}	
				}	
			}	
		}
		
		System.out.println(maxScore);
	}
	
	private static Integer score(Integer a, Integer b, Integer c, Integer d){
		Integer capacity = Math.max(0, a*A.getCapacity() + b*B.getCapacity() + c*C.getCapacity() + d*D.getCapacity());
		Integer durability = Math.max(0, a*A.getDurability() + b*B.getDurability() + c*C.getDurability() + d*D.getDurability());
		Integer flavor = Math.max(0, a*A.getFlavor() + b*B.getFlavor() + c*C.getFlavor() + d*D.getFlavor());
		Integer texture = Math.max(0, a*A.getTexture() + b*B.getTexture() + c*C.getTexture() + d*D.getTexture());
		
		return capacity*durability*flavor*texture;
	}

}
