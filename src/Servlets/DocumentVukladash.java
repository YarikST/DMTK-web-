package Servlets;

import MyClass.Person;
import MyClass.Vukladash;
import Servlets.Config.VukcladashHTML;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 Надає локументацію про викладача.
 */
public class DocumentVukladash extends HttpServlet implements Document{
    public static final Path path = Paths.get(Document.PATH.toString() + "/" + "DocumentVukladasha/");

    public DocumentVukladash() {
        if (!path.toFile().exists()) {
            path.toFile().mkdirs();
        }

}

    @Override
    public Vukladash requestPerson(String name) {
        return null;
    }

    @Override
    public VukcladashHTML requestHTML(Person person) {
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
