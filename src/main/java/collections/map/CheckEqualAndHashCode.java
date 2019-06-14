package Practice;
import java.util.HashMap;
class Car {
	String name;
	
	Car(String name ){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public boolean equals(Object o) {
		if((o instanceof Car)&& this.getName() == ((Car)o).getName())
		return true;
		else
		return false;
		
	}
	public int hashCode(){
		int hash=0;
		for (int i=0;i<name.length();i++) {
			hash=hash+(int)name.charAt(i);
		}
		return (hash+name.length())*17;
	}
}

public class CheckEqualAndHashCode {
	public static void main(String[] args) {
		Car car1 = new Car("Maruti");
		System.out.println("car 1 name is "+car1.getName()+" hash code is " + car1.hashCode());
		Car car3 = new Car("BMW");
		System.out.println("car 3 name is "+car3.getName()+" hash code is " + car3.hashCode());
		Car car5 = new Car ("MWB");
		System.out.println("car 5 name is "+car5.getName()+" hash code is " + car5.hashCode());
		Car car4 = new Car("BMW");
		System.out.println("car 4 name is "+car4.getName()+" hash code is " + car4.hashCode());
		Car car2 = new Car("Maruti");
		System.out.println("car 2 hash code is " + car2.hashCode());
		System.out.println(car1.equals(car2));
		HashMap hm = new HashMap();
		hm.put(car1, "Maruti");
		hm.put(car3, "BMW");
		System.out.println("HashMap is "+hm);
		System.out.println("Getting car1 with car2 "+hm.get(car2));
		System.out.println("Getting car3 with car4 "+hm.get(car4));
		System.out.println("Getting car3 with car5 "+hm.get(car5));
	}
}
