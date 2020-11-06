package geekbrains.java_core_elementary.hw;

import java.util.Random;

public abstract class Animal {
    protected final String name;
    protected final int runningAbility;
    protected final double jumpingAbility;

    Random rand = new Random();

    public Animal(String name, int runningAbility, double jumpingAbility) {
        this.name = name;
        this.runningAbility = rand.nextBoolean()
                ? runningAbility + rand.nextInt(runningAbility / 5)
                : runningAbility - rand.nextInt(runningAbility / 5); // Value scatter is +- 20%
        this.jumpingAbility = rand.nextBoolean()
                ? (double) Math.round((jumpingAbility + rand.nextDouble() * jumpingAbility / 5d) * 1000d) / 1000d
                : (double) Math.round((jumpingAbility - rand.nextDouble() * jumpingAbility / 5d) * 1000d) / 1000d;
    }

    public void run(int range) {
        if (runningAbility >= range)
            System.out.println(name + " has run!");
        else
            System.out.println(name + " has not run :(");
    }

    public void jump(int range) {
        if (jumpingAbility >= range)
            System.out.println(name + " has jumped!");
        else
            System.out.println(name + " has not jumped :(");
    }

    public String getFullInfo() {
        return  "Name: " + name + "; Can run: " + runningAbility + "m; " +
                "Can jump: " + jumpingAbility + "m";
    }

    protected abstract void say();
}
