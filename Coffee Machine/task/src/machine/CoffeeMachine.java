package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        ActionManager actionManager = new ActionManager(400, 540, 120, 9, 550);
        actionManager.mainMenu();
    }
}

class ActionManager {

    public enum Coffee {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        private final int water;
        private final int milk;
        private final int beans;
        private final int money;

        Coffee(int water, int milk, int beans, int money) {
            this.water = water;
            this.milk = milk;
            this.beans = beans;
            this.money = money;
        }

        public int getWater() {
            return water;
        }

        public int getMilk() {
            return milk;
        }

        public int getBeans() {
            return beans;
        }

        public int getMoney() {
            return money;
        }
    }
    public static Scanner scanner = new Scanner(System.in);
    //Stock List
    private int waterStock;
    private int milkStock;
    private int coffeeStock;
    private int cupStock;
    private int money;

    public ActionManager(int waterStock, int milkStock, int coffeeStock, int cupStock, int money) {
        this.waterStock = waterStock;
        this.milkStock = milkStock;
        this.coffeeStock = coffeeStock;
        this.cupStock = cupStock;
        this.money = money;
    }

    public int getWaterStock() {
        return waterStock;
    }

    public void setWaterStock(int waterStock) {
        this.waterStock = waterStock;
    }

    public int getMilkStock() {
        return milkStock;
    }

    public void setMilkStock(int milkStock) {
        this.milkStock = milkStock;
    }

    public int getCoffeeStock() {
        return coffeeStock;
    }

    public void setCoffeeStock(int coffeeStock) {
        this.coffeeStock = coffeeStock;
    }

    public int getCupStock() {
        return cupStock;
    }

    public void setCupStock(int cupStock) {
        this.cupStock = cupStock;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void mainMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.print("\nWrite action (buy, fill, take, remaining, exit): ");
            String option = scanner.next();

            switch (option) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    stockIngredients();
                    break;
                case "take":
                    takeMachineBalance();
                    break;
                case "remaining":
                    printSummary();
                    break;
                case "exit":
                    exit = true;
            }
        }
    }

    private void takeMachineBalance() {
        System.out.println("I gave you $" + money);
        setMoney(0);
    }

    private void stockIngredients() {
        System.out.print("Write how many ml of water you want to add: ");
        setWaterStock(getWaterStock() + scanner.nextInt());
        System.out.print("Write how many ml of milk you want to add: ");
        setMilkStock(getMilkStock() + scanner.nextInt());
        System.out.print("Write how many grams of coffee beans you want to add: ");
        setCoffeeStock(getCoffeeStock() + scanner.nextInt());
        System.out.print("Write how many disposable cups of coffee you want to add: ");
        setCupStock(getCupStock() + scanner.nextInt());
    }

    private void buyCoffee() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String drinkOrder = scanner.next();

        switch (drinkOrder) {
            case "1":
                buyEspresso();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappuccino();
                break;
            case "back":
                break;
            default:
                System.out.println("Incorrect number! Please try again.");
                buyCoffee();
                break;
        }
    }

    private void buyEspresso() {
        if (getWaterStock() >= Coffee.ESPRESSO.getWater() && getCoffeeStock() >= Coffee.ESPRESSO.getBeans() && getCupStock() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            setWaterStock(getWaterStock() - Coffee.ESPRESSO.getWater());
            setCoffeeStock(getCoffeeStock() - Coffee.ESPRESSO.getBeans());
            setMoney(getMoney() + Coffee.ESPRESSO.getMoney());
            setCupStock(getCupStock() - 1);
        } else if (getWaterStock() < Coffee.ESPRESSO.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (getCoffeeStock() < Coffee.ESPRESSO.getBeans()) {
            System.out.println("Sorry, not enough beans!");
        } else if (getCupStock() < 1) {
            System.out.println("Sorry, not enough cups!");
        }
    }

    private void buyLatte() {
        if (getWaterStock() >= Coffee.LATTE.getWater() && getMilkStock() >= Coffee.LATTE.getMilk() && getCoffeeStock() >= Coffee.LATTE.getBeans() && getCupStock() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            setWaterStock(getWaterStock() - Coffee.LATTE.getWater());
            setMilkStock(getMilkStock() - Coffee.LATTE.getMilk());
            setCoffeeStock(getCoffeeStock() - Coffee.LATTE.getBeans());
            setMoney(getMoney() + Coffee.LATTE.getMoney());
            setCupStock(getCupStock() - 1);
        } else if (getWaterStock() < Coffee.LATTE.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (getCoffeeStock() < Coffee.LATTE.getBeans()) {
            System.out.println("Sorry, not enough beans!");
        } else if (getCupStock() < 1) {
            System.out.println("Sorry, not enough cups!");
        } else if (getMilkStock() < Coffee.LATTE.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        }
    }

    private void buyCappuccino() {
        if (getWaterStock() >= Coffee.CAPPUCCINO.getWater() && getMilkStock() >= Coffee.CAPPUCCINO.getMilk() && getCoffeeStock() >= Coffee.CAPPUCCINO.getBeans() && getCupStock() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            setWaterStock(getWaterStock() - Coffee.CAPPUCCINO.getWater());
            setMilkStock(getMilkStock() - Coffee.CAPPUCCINO.getMilk());
            setCoffeeStock(getCoffeeStock() - Coffee.CAPPUCCINO.getBeans());
            setMoney(getMoney() + Coffee.CAPPUCCINO.getMoney());
            setCupStock(getCupStock() - 1);
        } else if (getWaterStock() < Coffee.CAPPUCCINO.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (getCoffeeStock() < Coffee.CAPPUCCINO.getBeans()) {
            System.out.println("Sorry, not enough beans!");
        } else if (cupStock < 1) {
            System.out.println("Sorry, not enough cups!");
        } else if (getMilkStock() < Coffee.CAPPUCCINO.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        }
    }

    private void printSummary() {
        System.out.printf("The coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n", getWaterStock(), getMilkStock(), getCoffeeStock(), getCupStock(), getMoney());
    }
}
