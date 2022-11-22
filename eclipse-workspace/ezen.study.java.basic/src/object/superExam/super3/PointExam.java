package object.superExam.super3;

class Point{
	int x, y;
	//Point(){}
	Point(int x, int y){
		this.x = x; this.y = y;
	}
	
	String getLocation() {
		return "x: " + x + ", y: " + y;
	}
}

class Point3D extends Point{
	int z;
	
	Point3D(int x, int y, int z){ //Object 클래스를 제외한 모든 크래스의 생성자 첫줄에는 생성자(같은 클래스의 다른 생성자 또는 조상의 생성자를 호출해야한다.
		super(x, y);
		this.x = x; this.y = y; this.z = z;
	}
	
	@Override
	String getLocation() {
		return "x: " + x + ", y: " + y + ", z: " + z;
	}
}

public class PointExam {

	public static void main(String[] args) {
		Point3D p3 = new Point3D(1, 2, 3);
		System.out.println(p3.getLocation());

	}

}
