package geekbrains.java_core_elementary.hw;

public class Cat extends Animal {
    public Cat(String name, int runningAbility, double jumpingAbility) {
        super(name, runningAbility, jumpingAbility);
    }

    @Override
    protected void say() {
        System.out.println(name + " says: meow!");
    }
}
