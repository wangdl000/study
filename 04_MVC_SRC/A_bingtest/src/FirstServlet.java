import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	/**
	 * aa处理请求的方法
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, java.io.IOException {

		// aa数据发送给客户端—>控制台方式输出

		// System.out.println("Hello Servlet");

		// aa数据发送给客户端—>HTML页面输出

		resp.setContentType("text/html");

		resp.getWriter().print("<html>");

		resp.getWriter().print("<head>");

		resp.getWriter().print("</head>");

		resp.getWriter().print("<body>");

		resp.getWriter().print("Hello World");

		resp.getWriter().print("</body>");

		resp.getWriter().print("</html>");

	}

}