package geekbrains.java_core_elementary.hw;

public class Main {

    public static void main(String[] args) {
        Animal[] zoo = {
                new Bird("Sweetie", 5, 0.2),
                new Cat("Felix", 200, 2),
                new Dog("Rex", 500, 0.5, 10),
                new Horse("Pete", 1500, 3, 100)
        };

        for (int i = 0; i < zoo.length; i++) {
            System.out.println(zoo[i].getClass().getSimpleName());
            System.out.println(zoo[i].getFullInfo());
            zoo[i].say();
            zoo[i].run(230);
            zoo[i].jump(1);
            if (zoo[i] instanceof Dog)
                ((Dog)zoo[i]).swim(10);

            if (zoo[i] instanceof Horse)
                ((Horse)zoo[i]).swim(100);

            System.out.println();
        }
    }
}
