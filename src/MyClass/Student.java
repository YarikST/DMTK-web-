package MyClass;

import java.util.HashMap;

/**
 * Являє студента.
 */
public  class Student extends Person {
    enum Spesufik{
        PK,BO,DB;
    }

    protected int course;
    protected String grup;
    protected Spesufik spesufik;
    protected HashMap<String,Integer> setEvaluation = new HashMap<>();

    public Student(String name, String address, String m_Tel, int age, int course, String grup, HashMap<String, Integer> setEvaluation,Spesufik spesufik) {
        super(name, address, m_Tel, age);
        this.course = course;
        this.grup = grup;
        this.setEvaluation = setEvaluation;
        this.spesufik = spesufik;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public HashMap<String, Integer> getSetEvaluation() {
        return setEvaluation;
    }

    public void setSetEvaluation(HashMap<String, Integer> setEvaluation) {
        this.setEvaluation = setEvaluation;
    }

    @Override
    public String toString() {
        return "Студент "+name +" Дрогобицького механіко Технологічного Колежду."+
                "Навчаюся на " + course +" курсі"+
                ", у групі ='" + grup +" на спеціальність " +spesufik+".";
    }
}
