package Servlets;

import MyClass.Person;
import Servlets.Config.AbstractHTML;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 Надає локументацію про запитану особу.
 */
public interface Document {

    Path PATH = Paths.get("U:/");


    /*Запит на особу*/
    Person requestPerson(String name);

   /* Запит на сторінку особи*/
    AbstractHTML requestHTML(Person person);



}
