import java.util.Scanner;

public final class Main {

    private static final int WALKING = 1;
    private static final int HORSE_RIDING = 2;
    private static final int FLYING = 3;
    private static final int EXIT = 0;

    public static void main(String[] args) {
        System.out.println("My Hero strategies");

        Hero hero = new Hero(new WalkStrategy());

        try (Scanner input = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("""
                        1 - Walk
                        2 - Horse
                        3 - Fly
                        0 - Exit
                        """);

                if (!input.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    input.next();
                    continue;
                }

                switch (input.nextInt()) {
                    case WALKING -> {
                        hero.setMoveStrategy(new WalkStrategy());
                        hero.move();
                    }
                    case HORSE_RIDING -> {
                        hero.setMoveStrategy(new HorseRideStrategy());
                        hero.move();
                    }
                    case FLYING -> {
                        hero.setMoveStrategy(new FlyStrategy());
                        hero.move();
                    }
                    case EXIT -> {
                        exit = true;
                        System.out.println("Exiting");
                    }
                    default -> System.out.println("Unsupported number. Try again!");
                }
            }
        }
    }
}
