package Servlets.Config;

import MyClass.Person;
import Servlets.Document;

import java.awt.event.AdjustmentListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Динамічне створення HTML сторінок на запити.
 */
public abstract class AbstractHTML {
    protected String heading;
    protected ArrayList<String> listOpus = new ArrayList<>(100);
    protected ArrayList<String> listStatus = new ArrayList<>(50);
    protected Path pathImage;
    public static final Path path = Paths.get(Document.PATH.toString() + "/" + "TimeDiteFile/");
    protected Person person;
    protected ArrayList<String> listHTML = new ArrayList<>(1000);


    public AbstractHTML(String heading, Path pathImage, Person person) {
        this.heading = heading;
        this.pathImage = pathImage;
        this.person = person;
    }

    public void listOpus() {

    }

    public void listStatus() {

    }

    public void setListHTML() {

    }


}
