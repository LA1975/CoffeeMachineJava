import java.util.Scanner;

public class CoffeeMachine {
    
    static private int money;
    static private int water;
    static private int milk;
    static private int coffeeBeans;
    static private int disposableCups;

    public CoffeeMachine(int money, int water, int milk, int coffeeBeans, int disposableCups) {
        CoffeeMachine.money = money;
        CoffeeMachine.water = water;
        CoffeeMachine.milk = milk;
        CoffeeMachine.coffeeBeans = coffeeBeans;
        CoffeeMachine.disposableCups = disposableCups;
    }

    static public void printState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of money\n", money);
        System.out.printf("%d of water\n", water);
        System.out.printf("%d of milk\n", milk);
        System.out.printf("%d of coffee beans\n", coffeeBeans);
        System.out.printf("%d of disposable cups\n", disposableCups);
    }

    public void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int price) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
            money += price;
        } else {
            System.out.println("Sorry, not enough water/milk/coffee beans/cups!");
        }
    }

    public void fill(Scanner scanner) {
        System.out.println("How many ml of water do you want to add?");
        int waterToAdd = scanner.nextInt();
        System.out.println("How many ml of milk do you want to add?");
        int milkToAdd = scanner.nextInt();
        System.out.println("How many grams of coffee beans do you want to add?");
        int coffeeBeansToAdd = scanner.nextInt();
        System.out.println("How many disposable cups do you want to add?");
        int cupsToAdd = scanner.nextInt();
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        disposableCups += cupsToAdd;
    }

    public void take() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(550, 400, 540, 120, 9);
        Scanner scanner = new Scanner(System.in);
        printState();
        while (true) {
            System.out.println("Write action (buy, fill, take, exit):");
            String action = scanner.nextLine();
            if (action.equals("buy")) {
                coffeeMachine.buy(scanner);

            } else if (action.equals("fill")) {
                coffeeMachine.fill(scanner);

            } else if (action.equals("take")) {
                coffeeMachine.take();

            } else if (action.equals("remaining")) {
                printState();

            } else if (action.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid action");
            }
            printState();

        }
        scanner.close();
    }
}
