package jamesbaker.adventofcode.day14;

public class Reindeer {
	private final Integer speed;
	private final Integer flightTime;
	private final Integer restTime;
	
	private Integer time = 0;
	private Integer distance = 0;
	
	public Reindeer(Integer speed, Integer flightTime, Integer restTime){
		this.speed = speed;
		this.flightTime = flightTime;
		this.restTime = restTime;
	}

	public Integer getSpeed() {
		return speed;
	}

	public Integer getFlightTime() {
		return flightTime;
	}

	public Integer getRestTime() {
		return restTime;
	}
	
	public Integer getDistance(){
		return distance;
	}
	
	public void nextSecond(){
		time++;

		Integer mod = time % (flightTime + restTime);
		if(mod <= flightTime && mod > 0){
			distance += speed;
		}
	}
}
