package geekbrains.java_core_elementary.hw;

import java.util.Random;

public class Horse extends Animal {
    private final int swimmingAbility;

    Random rand = new Random();

    public Horse(String name, int runningAbility, double jumpingAbility, int swimmingAbility) {
        super(name, runningAbility, jumpingAbility);
        this.swimmingAbility = rand.nextBoolean()
                ? swimmingAbility + rand.nextInt(swimmingAbility / 5)
                : swimmingAbility - rand.nextInt(swimmingAbility / 5);
    }

    @Override
    protected void say() {
        System.out.println(name + " says: neigh!");
    }

    @Override
    public String getFullInfo() {
        return super.getFullInfo() + "; Can swim: " + swimmingAbility + "m";
    }

    public void swim(int range) {
        if (swimmingAbility >= range)
            System.out.println(name + " has swum!");
        else
            System.out.println(name + " has not swum :(");
    }
}
