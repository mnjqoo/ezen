package object.casting.casting2;

//-----------------------------------------------------------------------------------------------------------
class Car {}
//-----------------------------------------------------------------------------------------------------------
class FireTruck extends Car {}
//-----------------------------------------------------------------------------------------------------------
// public class InstanceofExam
//-----------------------------------------------------------------------------------------------------------
public class InstanceofExam {
	public static void main(String[] args) {
		FireTruck	ft	= new FireTruck();
		
		if(ft instanceof FireTruck)
			System.out.println("This is a FireTruck instance.");
		if(ft instanceof Car)
			System.out.println("This is a Car instance.");
		if(ft instanceof Object)
			System.out.println("This is an Object instance.");
	}
} // ENd - public class InstanceofExam









