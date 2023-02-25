public class PersonBuilder {
    private String name;
    private String surname;
    private int age = 0;
    private String address = "";

    public PersonBuilder() {

    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Невозможно создать объект типа Person - не правльно задано имя!");
        } else if (surname == null || surname.equals("")) {
            throw new IllegalArgumentException("Невозможно создать объект типа Person - не правильно задана фамилия!");
        } else if (address == null) {
            throw new IllegalArgumentException("Невозможно создать объект типа Person - в поле address передан null!");
        } else if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Невозможно создать объект типа Person - в поле age передан некорректный возраст!");
        } else {
            Person person = new Person(this.name, this.surname);
            person.age = this.age;
            person.address = this.address;
            return person;
        }
    }
}