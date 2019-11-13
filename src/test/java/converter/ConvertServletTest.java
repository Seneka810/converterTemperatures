package converter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConvertServletTest {

    @Spy
    ConvertServlet convertServlet;
    @Mock
    ServletConfig config;

    @Test
    public void createInit() throws ServletException {
        convertServlet.init(config);
    }

    @Test
    public void createRequest() throws ServletException, IOException, InstantiationException, IllegalAccessException {
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);

        RequestDispatcher rd = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(eq("/index.jsp"))).thenReturn(rd);

        convertServlet.doPost(request, response);

    }

}