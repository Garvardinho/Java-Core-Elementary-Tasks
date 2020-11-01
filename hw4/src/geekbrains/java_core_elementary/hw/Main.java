package geekbrains.java_core_elementary.hw;

import java.util.ArrayList;

public class Main {

    public static class Employee {
        private String name;
        private String position;
        private String phoneNumber;
        private int salary;
        private int age;
        private int id;
        private static short idStatic = 0;

        public Employee(String name, String position, String phoneNumber, int salary, int age) {
            this.name = name;
            this.position = position;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
            this.age = age;
            this.id = idStatic;
            idStatic++;
        }

        public String getName() { return this.name; }
        public String getPosition() { return this.position; }
        public String getPhoneNumber() { return this.phoneNumber; }
        public int getSalary() { return this.salary; }
        public int getAge() { return this.age; }

        public void print() {
            System.out.println("ФИО: " + this.name);
            System.out.println("Должность: " + this.position);
            System.out.println("Номер телефона: " + this.phoneNumber);
            System.out.println("Зарплата: " + this.salary);
            System.out.println("Возраст: " + this.age);
            System.out.println("ID: " + this.id);
            System.out.println();
        }

        public void riseSalary() {
            if (this.age > 45)
                this.salary += 5000;
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>(5);

        employees.add(new Employee(
                "Олег",
                "Директор",
                "+79534656565",
                160000,
                42));

        employees.add(new Employee(
                "Елена",
                "Заместитель директора",
                "+79789547800",
                93000,
                31));

        employees.add(new Employee(
                "Степан",
                "Начальник отдела качества",
                "+79689856230",
                75000,
                48));

        employees.add(new Employee(
                "Светлана",
                "Работник отдела качества",
                "+79966122340",
                50000,
                29));

        employees.add(new Employee(
                "Мария",
                "Работник отдела кадров",
                "+79116547878",
                48000,
                26));

        System.out.println("Task 4");
        for (Employee em : employees)
            System.out.println("ФИО: " + em.getName() + "\nДолжность: " + em.getPosition() + "\n");

        System.out.println("Task 5");
        for (Employee em : employees)
            if (em.getAge() > 40)
                em.print();

        System.out.println("Task 6");
        for (Employee em: employees) {
            em.riseSalary();
            em.print();
        }
    }
}
