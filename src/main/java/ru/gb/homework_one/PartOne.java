package ru.gb.homework_one;

public class PartOne {
    public static void main(String[] args) {
        Person person = Person.createPerson()
                .setFirstName("Ivan")
                .setMiddleName("Ivanovich")
                .setLastName("Ivanov")
                .setAge(28)
                .setCountry("Belarus")
                .setAddress("Minsk")
                .setPhone("+123456789")
                .setGender("Male")
                .build();
        System.out.println(person);
    }
}
class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    private Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    public static PersonBuilder createPerson(){
        return new PersonBuilder(new Person());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    static class PersonBuilder {
        private Person person;

        public PersonBuilder(Person person) {
            this.person = person;
        }

        public PersonBuilder setFirstName(String firstName) {
            person.firstName = firstName;
            return this;
        }
        public PersonBuilder setLastName(String lastName){
            person.lastName = lastName;
            return this;
        }
        public PersonBuilder setMiddleName(String middleName){
            person.middleName = middleName;
            return this;
        }
        public PersonBuilder setCountry(String country){
            person.country = country;
            return this;
        }
        public PersonBuilder setAddress(String address){
            person.address = address;
            return this;
        }
        public PersonBuilder setPhone(String phone){
            person.phone = phone;
            return this;
        }
        public PersonBuilder setAge(int age){
            person.age = age;
            return this;
        }
        public PersonBuilder setGender(String gender){
            person.gender = gender;
            return this;
        }
        public Person build(){
            return person;
        }
    }
}
