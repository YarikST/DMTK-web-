package Applets;

import MyClass.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Created by 2 on 14.05.2016.
 */
public abstract class AbstractPoshuk extends JApplet implements Poshuk,ActionListener {

    protected JPanel panelTabel;
    protected JPanel panelFunction;
    protected JLabel labelText;
    protected JTextField textField ;
    protected JButton buttonPoshuk;

    protected InputStream inputStream;
    protected BufferedReader bufferedReader;

    public AbstractPoshuk() throws HeadlessException {

    }

    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void poshuk(Person person) {

    }
}
