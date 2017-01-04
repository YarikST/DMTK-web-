package Servlets.Config;

import MyClass.Student;

import java.nio.file.Path;

/**
 Створення динамічної сторінки студента
 */
public class StudentHTML extends AbstractHTML {
    public StudentHTML(String heading, Path pathImage, Student person) {
        super(heading, pathImage, person);
    }

}
