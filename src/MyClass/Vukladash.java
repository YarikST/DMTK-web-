package MyClass;

import java.util.HashSet;

/**
 Являє викладача.
 */
public   class Vukladash extends  Person{
    protected int excperiense;
    protected String diploma;
    protected HashSet<String> setPredmet = new HashSet<>();

    public Vukladash(String name, String address, String m_Tel, int age, int excperiense, String diploma,HashSet setPredmet) {
        super(name, address, m_Tel, age);
        this.excperiense = excperiense;
        this.diploma = diploma;
        this.setPredmet = setPredmet;
    }

    public int getExcperiense() {
        return excperiense;
    }

    public void setExcperiense(int excperiense) {
        this.excperiense = excperiense;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public HashSet<String> getSetPredmet() {
        return setPredmet;
    }

    public void setSetPredmet(HashSet<String> setPredmet) {
        this.setPredmet = setPredmet;
    }

    @Override
    public String toString() {
        String str = "";

        for (String s : setPredmet) {
            str += s + "\n";
        }

        return "Викладач " +name +" Викладаю в Дрогобицькому Механічному Коледжі такі предмети : "+"\n"+str+ '.'+
                "Працьую уже " + excperiense +" роки"+
                ", маю диплом " + diploma + '.';
    }
}
