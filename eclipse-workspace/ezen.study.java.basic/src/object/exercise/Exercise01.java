package object.exercise;

//-----------------------------------------------------------------------------------------------------------
// class Student
//-----------------------------------------------------------------------------------------------------------
class Student {
	String	name; 	// 학생이름
	int		ban;	// 반
	int		no;		// 번호
	int 	kor;	// 국어점수
	int		eng;	// 영어점수
	int		mat;	// 수학점수
	
	int getTotal() {	// 총점을 구하는 메서드
		return kor + eng + mat;
	}
	int getAverage() {	// 평균을 구하는 메서드
		return (kor + eng + mat) / 3;
	}
	
} // End - class Student
//-----------------------------------------------------------------------------------------------------------
// public class Exercise01
//-----------------------------------------------------------------------------------------------------------
public class Exercise01 {

	public static void main(String[] args) {
		Student s = new Student();
		
		s.name	= "향단이";
		s.ban	= 1;
		s.no	= 35;
		s.kor	= 100;
		s.eng	= 65;
		s.mat	= 80;
		
		System.out.println("이름 : " + s.name);
		System.out.println("총점 : " + s.getTotal());
		System.out.println("평균 : " + s.getAverage());
	}

} // End - public class Exercise01






