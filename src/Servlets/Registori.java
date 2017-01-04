package Servlets;

import Servlets.Document;
import Servlets.Authorizable;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 Процес реєстрації.
 */
public class Registori extends HttpServlet{

    public static final Path path = Paths.get(Document.PATH.toString() + "/" + "RegistoriPerson/");
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    public Registori() {
        if (!path.toFile().exists()) {
            path.toFile().mkdirs();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

       executorService.execute(new RegistoriRun(req, resp.getOutputStream()));

    }

    class RegistoriRun implements Runnable {

        private  HttpServletRequest request;

        private ServletOutputStream servletOutputStream;
        private DataOutputStream dataOutputStream;

        private FileOutputStream fileOutputStream;
        private PrintWriter printWriter;


        public RegistoriRun(HttpServletRequest request, ServletOutputStream servletOutputStream) {
            this.request = request;
            this.servletOutputStream = servletOutputStream;

            dataOutputStream = new DataOutputStream(servletOutputStream);
        }

        @Override
        public void run() {
            String name, login, password;

            boolean is = true;

            try {
                name = request.getParameter("name");
                login = request.getParameter("login");
                password = request.getParameter("password");

                if (!Authorizable.isPerson(name)) {
                    fileOutputStream = new FileOutputStream(path.toString() + "/" + name);
                    printWriter = new PrintWriter(fileOutputStream);

                    printWriter.println(login);
                    printWriter.println(password);

                }else {
                    is = false;
                }

                dataOutputStream.writeBoolean(is);

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                close();
            }


        }

        private void close() {
            executorService.shutdown();
            try {
                servletOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            printWriter.close();
        }

    }
}
