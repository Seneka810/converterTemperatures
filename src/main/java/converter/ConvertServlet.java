package converter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/converter-temperatures")
public class ConvertServlet extends HttpServlet {

    public ConvertServlet() throws IllegalAccessException, InstantiationException {
    }

    @Override public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String tC = req.getParameter("tC");
        String tF = req.getParameter("tF");
        String tK = req.getParameter("tK");

        String res = new ConverterRequest().convert(tC, tF, tK);

        ConverterRequest request = new ConverterRequest(tC, tF, tK, res);
        req.setAttribute("temperature", request);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }

}
