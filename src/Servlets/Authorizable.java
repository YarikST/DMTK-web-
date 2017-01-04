package Servlets;

import MyClass.Person;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 Авторизація клієнта в системі.
 */
public class Authorizable extends HttpServlet {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

    executorService.execute(new AuthorizableRun(req,resp));
    }

    public static boolean isPerson(Person person) {
        return isPerson(person.getName());
    }

    public static boolean isPerson(String name) {
        return Paths.get(Registori.path.toString() + "/" + name).toFile().exists();
    }


    class AuthorizableRun implements Runnable{

        private Cookie cookie[];
        private ServletOutputStream servletOutputStream;
        private DataOutputStream dataOutputStream;
        private HttpServletResponse response;
        private HttpServletRequest request;

        private  String name, login, password;

        public AuthorizableRun(HttpServletRequest request,HttpServletResponse response) {
            this.cookie = request.getCookies();
            try {
                this.servletOutputStream = response.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.request = request;
            this.response = response;

            dataOutputStream = new DataOutputStream(servletOutputStream);

        }

        @Override
        public void run() {
            boolean is = true;

            if (cookie != null && cookie.length != 0) {

                name = cookie[0].getValue();
                login = cookie[1].getValue();
                password = cookie[2].getValue();

                if (!isPassword()) {
                    close();
                    is = false;
                }



            }else{


                    name = request.getParameter("name");
                    login = request.getParameter("login");
                    password = request.getParameter("password");

                if (!isPassword()) {
                    is = false;
                }

                Cookie cookieName = new Cookie("name", name);
                Cookie cookieLogin = new Cookie("login", login);
                Cookie cookiePass = new Cookie("password", password);

                response.addCookie(cookieName);
                response.addCookie(cookieLogin);
                response.addCookie(cookiePass);

            }

            try {
                dataOutputStream.writeBoolean(is);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                close();
            }

        }

        private boolean isPassword() {
            if(!isPerson(name)) return false;
            BufferedReader reader = null;
            try {
                 reader = new BufferedReader(new FileReader(Registori.path.toString() + "/" + name));

                if (!login.equals(reader.readLine())) {
                    return false;
                }

                if (!password.equals(reader.readLine())) {
                    return false;
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return true;
        }

        private void close() {
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
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
