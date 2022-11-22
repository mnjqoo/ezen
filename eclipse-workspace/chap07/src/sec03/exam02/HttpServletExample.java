package sec03.exam02;

public class HttpServletExample {
	public static void method(HttpServlet sevlet) {
		sevlet.service();
	}
	public static void main(String[] args) {
		method(new LoginServlet());
		method(new FileDownloadServlet());

	}

}
