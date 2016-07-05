package rali;

public class Road {
	
	public static void main(String[] argv){
		
		Car car = new Car();
		
		car.fill(100);
		car.showGas();
		car.drive(10);
		car.showGas();
		
		Road.gasStation(car);
		car.showGas();
		
	}
	
	public static void gasStation(Car car){
		car.fill(100);
	}
}