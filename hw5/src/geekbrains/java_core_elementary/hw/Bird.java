package geekbrains.java_core_elementary.hw;

public class Bird extends Animal {
    public Bird(String name, int runningAbility, double jumpingAbility) {
        super(name, runningAbility, jumpingAbility);
    }

    @Override
    protected void say() {
        System.out.println(name + " says: sqqqrrrr");
    }
}
