package Servlets;

import MyClass.Person;
import MyClass.Student;
import Servlets.Config.StudentHTML;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 Надає локументацію про студента.
 */
public class DocumentStudent extends HttpServlet implements  Document{
    public static final Path path = Paths.get(PATH.toString() + "/" + "DocumentStudent/");

    public DocumentStudent() {
        if (!path.toFile().exists()) {
            path.toFile().mkdirs();
        }
    }

    @Override
    public Student requestPerson(String name) {
        return null;
    }

    @Override
    public StudentHTML requestHTML(Person person) {
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
