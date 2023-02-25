import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    //...

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAge(this.age);
        child.setAddress(this.address);
        return child;
    }

    public boolean hasAge() {
        if (this.age != 0) {
            return true;
        }

        return false;
    }

    public boolean hasAddress() {
        if (address != null && address.length() != 0) {
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        }
        return null;
    }

    public String getAddress() {
        if (hasAddress()) {
            return address;
        }

        return null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age += 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(surname + " " + name).append(". Возраст: " + age).append(". Проживающий по адресу: " + address);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 32;

        result = 32 * result + name.hashCode();
        result = 32 * result + surname.hashCode();
        result = 32 * result + age;
        result = 32 * result + (address == null ? 0 : address.hashCode());
        return result;
    }
}