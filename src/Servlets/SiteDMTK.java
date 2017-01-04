package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by 2 on 13.05.2016.
 */
public class SiteDMTK extends HttpServlet {

    private URI siteURL;
    protected ArrayList<String> list = new ArrayList<>(10000);

    public SiteDMTK() {

    }

    protected ArrayList<String> getList() {
        return list;
    }

    protected void list() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
