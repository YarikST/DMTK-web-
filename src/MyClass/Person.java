package MyClass;

import java.io.Serializable;

/**
 Являє особу
 */
public abstract class Person implements Serializable {
    protected String name,address,m_Tel;
    protected int age;

    public Person(String name, String address, String m_Tel, int age) {
        this.name = name;
        this.address = address;
        this.m_Tel = m_Tel;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getM_Tel() {
        return m_Tel;
    }

    public void setM_Tel(String m_Tel) {
        this.m_Tel = m_Tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (address != null ? !address.equals(person.address) : person.address != null) return false;
        return m_Tel != null ? m_Tel.equals(person.m_Tel) : person.m_Tel == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (m_Tel != null ? m_Tel.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
