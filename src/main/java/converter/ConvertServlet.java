package converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/converter-temperatures")
public class ConvertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String tC = req.getParameter("tC");
        String tF = req.getParameter("tF");
        String tK = req.getParameter("tK");

        ConverterRequest request = new ConverterRequest(tC, tF, tK);
        req.setAttribute("temperature", request);

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
