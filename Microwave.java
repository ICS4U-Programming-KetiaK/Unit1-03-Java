import java.util.Scanner;

/**
 * This microwave program asks the user the food they want to eat
 * and the its amount and displays the time it takes to heat the food.
 *
 * @author Ketia Gaelle Kaze
 * @version 1.3
 * @since 2022-02-27
 *
 */

final class Microwave {
    /**
     * Declaring constants.
     */
    private static final int A_MIN = 60;
    /**
     * Declaring constants.
     */
    private static final int SINGLE_FOOD = 1;
    /**
     * Declaring constants.
     */
    private static final int DOUBLE_FOOD = 2;
    /**
     * Declaring constants.
     */
    private static final int TRIPLE_FOOD = 3;
    /**
     * Declaring constants.
     */
    private static final double SINGLE_SOUP = 105;
    /**
     * Declaring constants.
     */
    private static final double SINGLE_PIZZA = 45;
    /**
     * Declaring constants.
     */
    private static final double SINGLE_SUB = 60;
    /**
     * Declaring constants.
     */
    private static final String SOUP_USER = "SOUP";
    /**
     * Declaring constants.
     */
    private static final String PIZZA_USER = "PIZZA";
    /**
     * Declaring constants.
     */
    private static final String SUB_USER = "SUB";
    /**
     * Declaring constants.
     */
    private static final double ONE_HALF = 1.5;

    /**
     * Display result to the console.
     *
     * @param args passed in
     */
    public static void main(String[]args) {
        // declaring variable
        double time = 0;
        // create Scanner
        final Scanner sc = new Scanner(System.in);
        // get user input
        System.out.print("What would you like to heat?: ");
        final String foodLower = sc.nextLine();
        // change user input to upppercase
        final String foodUpper = foodLower.toUpperCase();

        // calculate time to heat the food
        if (SOUP_USER.equals(foodUpper)) {
            time = SINGLE_SOUP;
        } else if (PIZZA_USER.equals(foodUpper)) {
            time = SINGLE_PIZZA;
        } else if (SUB_USER.equals(foodUpper)) {
            time = SINGLE_SUB;
        } else {
            // display error input message
            System.out.print("Invalid food!");
        }

        if (SOUP_USER.equals(foodUpper) || PIZZA_USER.equals(foodUpper)
            || SUB_USER.equals(foodUpper)) {
            // get input from user
            System.out.print("How many " + foodUpper
                             + " are you cooking(max 3)?: ");
            final String amountString = sc.nextLine();

            try {
                // convert user input to int
                final int amountInt = Integer.parseInt(amountString);
                // convert time into seconds
                if (amountInt == SINGLE_FOOD) {
                    time = time;
                } else if (amountInt == DOUBLE_FOOD) {
                    time = time * ONE_HALF;
                } else if (amountInt == TRIPLE_FOOD) {
                    time = time * 2;
                } else {
                    // display error input message
                    System.out.print("Quantity should be between 1 and 3");
                    System.exit(0);
                }

                // calculate minutes and seconds taken to heat the food
                final int minutes = (int) time / A_MIN;
                final double seconds = time % A_MIN;

                // display result to the user
                System.out.println("The time to heat your food is "
                                   + minutes + " minutes and "
                                   + seconds + "seconds.");
            } catch (IllegalArgumentException exception) {
                // identify invalid inputs
                System.out.println("Your input is not valid.");
            }
        }
    }
}
