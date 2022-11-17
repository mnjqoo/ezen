package object.card.extend;

import javax.swing.JFrame;
import java.awt.Graphics;

//-----------------------------------------------------------------------------------------------------------
// 좌표 클래스
//-----------------------------------------------------------------------------------------------------------
class Point {
	int	x, y;
	Point(int x, int y) {	// 매개변수가 있는 생성자.
		this.x	= x;
		this.y	= y;
	}
	Point()	{	// 기본 생성자
		this(0, 0);
	}
} // End - class Point
//-----------------------------------------------------------------------------------------------------------
// 원 클래스
//-----------------------------------------------------------------------------------------------------------
class Circle {
	Point		center;	// 원의 원점좌표
	int			r;		// 반지름
	
	Circle() {
		this(new Point(0, 0), 100);
	}
	Circle(Point center, int r) {
		this.center	= center;
		this.r		= r;
	}
} // End - class Circle
//-----------------------------------------------------------------------------------------------------------
// 삼각형 클래스
//-----------------------------------------------------------------------------------------------------------
class Triangle	{
	Point[] p	= new Point[3];
	
	Triangle(Point[] p) {
		this.p = p;
	}
	Triangle(Point p1, Point p2, Point p3) {
		p[0] = p1; p[1] = p2; p[2] = p3;
	}
} // End - class Triangle
//-----------------------------------------------------------------------------------------------------------
// public class DrawShapeExam
//-----------------------------------------------------------------------------------------------------------
public class DrawShapeExam extends JFrame {

	public static void main(String[] args) {
		DrawShapeExam win = new DrawShapeExam("도형 그리기");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	DrawShapeExam(String title) {
		setTitle(title);		// 프레임 상단에 제목을 넣어준다.
		setLocation(300, 200);	// 프레임이 나타날 위치(x, y)
		setSize(600, 400);		// 프레임의 크기(width, height)
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		Point[] p = {
			new Point(100, 100),
			new Point(400, 200),
			new Point(200, 100)
		};
		Triangle	t	= new Triangle(p);
		
		// 직선 3개로 삼각형을 그린다.
		g.drawLine(t.p[0].x, t.p[0].y, t.p[1].x, t.p[1].y);
		g.drawLine(t.p[1].x, t.p[1].y, t.p[2].x, t.p[2].y);
		g.drawLine(t.p[2].x, t.p[2].y, t.p[0].x, t.p[0].y);
		
		Circle		c	= new Circle(new Point(300, 200), 100);
		// 원을 그린다.
		g.drawOval(c.center.x, c.center.y, c.r, c.r);
		
	} // End - public void paint(Graphics g)

} // End - public class DrawShapeExam









