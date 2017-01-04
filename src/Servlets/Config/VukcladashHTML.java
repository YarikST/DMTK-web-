package Servlets.Config;

import MyClass.Vukladash;

import java.nio.file.Path;

/**
 Створення динамічної сторінки викладача.
 */
public class VukcladashHTML extends AbstractHTML {
    public VukcladashHTML(String heading, Path pathImage, Vukladash person) {
        super(heading, pathImage, person);
    }
}
