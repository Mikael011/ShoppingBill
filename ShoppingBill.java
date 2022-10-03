import java.text.SimpleDateFormat;
import java.util.*;


public class ShoppingBill {
    public static void main(String[] args) {
        // variables
        int idNumber = 0;
        String gameName = null;
        String developer = null;
        int quantity = 0;
        double price = 0.0;
        double totalPrice = 0.0;
        double overAllPrice = 0.0;
        double cgst, sgst, subtotal = 0.0, discount = 0.0;
        char choice = '\0';

        GameRecord newGame = new GameRecord();

        ShoppingBillModel.Game game = new ShoppingBillModel.Game(idNumber, gameName, developer, quantity, price, totalPrice);

        game.setId(6862);
        game.setPrice(911);
        game.setName("Ankit");
        game.setDezvoltator("EA Sports");
        game.setQuantity(2);

        System.out.println("\t\t\t\t--------------------Invoice-----------------");
        System.out.println("\t\t\t\t\t " + "  " + "Metro Mart Grocery Shop");
        System.out.println("\t\t\t\t\t3/98 Mecrobertganj New Mumbai");
        System.out.println("\t\t\t\t\t" + "    " + "Opposite Metro Walk");
        System.out.println("GSTIN: 03AWBPP8756K592" + "\t\t\t\t\t\t\tContact: (+91) 9988776655");

        //format of date and time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        //prints current date and time
        System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1] + "\t\t\t\t\t\t (+91) 9998887770");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String customerName = scan.nextLine();

        //create Scanner class object
        //creating an ArrayList to store the product

        List<ShoppingBillModel.Game> games = new ArrayList<ShoppingBillModel.Game>();
        game.setId(6862);
        game.setPrice(911);
        game.setName("Ankit");
        game.setDezvoltator("EA Sports");
        game.setQuantity(2);
        games.add(game);

        int option = 0;

        do {
            menu();
            option = scan.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.print("What is the Game id Number ? ");
                    int id = scan.nextInt();

                    System.out.print("What is the Game Name ? ");
                    String nume = scan.nextLine();
                    scan.nextLine();

                    System.out.print("What is the Game price ? ");
                    double pret = scan.nextDouble();
                    scan.nextLine();

                    System.out.println("What is the Game Developer ? ");
                    String dezvoltator = scan.nextLine();
                    scan.nextLine();

                    System.out.print("What is the Game stock ? ");
                    int stoc = scan.nextInt();
                    scan.nextLine();

                    System.out.print("What is the Game data ? ");
                    String data = scan.nextLine();

                    System.out.println("Total price: ");
                    double pretTotal = pret * stoc;

                    game = new ShoppingBillModel.Game(idNumber, gameName, developer, (int) price, quantity, totalPrice);
                    newGame.add(game);
                    System.out.println(game.toString());
                }
                case 2 -> {
                    System.out.print("What is the Game id ? ");
                    int deleteGame = scan.nextInt();
                    newGame.delete(deleteGame);
                }
                case 3 -> {
                    System.out.print("What is the Game id ? ");
                    int updateGame = scan.nextInt();
                    newGame.update(updateGame, scan);
                }
                case 4 -> {
                    System.out.print("What is the Game id ? ");
                    int findGame = scan.nextInt();
                    if (!newGame.find(findGame)) {
                        System.out.println("Game id does not exist\n");
                    }
                }
                case 5 -> newGame.display();

                case 6 -> {
                    System.out.println("Enter the game details: ");
                    System.out.println("Game ID: ");
                    idNumber = scan.nextInt();
                    System.out.print("Game Name: ");
                    gameName = scan.nextLine();
                    System.out.println("Game Developer: ");
                    developer = scan.nextLine();
                    System.out.print("Quantity: ");
                    quantity = scan.nextInt();
                    System.out.print("Price (per unit): ");
                    price = scan.nextDouble();

                    //calculate total price for a particular product
                    totalPrice = price * quantity;

                    //calculates overall price
                    overAllPrice = overAllPrice + totalPrice;

                    //creates Product class object and add it to the List
                    games.add(new ShoppingBillModel.Game(idNumber, gameName, developer, quantity, price, totalPrice));

                    // ask for continue shopping?
                    System.out.print("Want to add more items? (y or n): ");

                    //reads a character Y or N
                    choice = scan.next().charAt(0);

                    //read remaining characters, don't store (no use)
                    scan.nextLine();
                    while (choice == 'y' || choice == 'Y') {
                        //display all product with its properties
                        ShoppingBillModel.Game.displayFormat();
                        for (
                                ShoppingBillModel.Game g : games) {
                            g.display();

                        }
                    }
//price calculation
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " + overAllPrice);

                    //calculating discount
                    discount = overAllPrice * 2 / 100;
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " + discount);

                    //total amount after discount
                    subtotal = overAllPrice - discount;
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal " + subtotal);

                    //calculating tax
                    sgst = overAllPrice * 12 / 100;
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) " + sgst);
                    cgst = overAllPrice * 12 / 100;
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) " + cgst);

                    //calculating amount to be paid by buyer
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " + (subtotal + cgst + sgst));
                    System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
                    System.out.println("\t\t\t\t                     Visit Again");
                }
                case 7 -> {
                    System.out.println("\nThank you for using the program. Goodbye!\n");
                    System.exit(0);
                }
                default -> System.out.println("\nInvalid input\n");
            }
        } while (option != 7);
    }

    public static void menu() {

        // Printing statements displaying menu on console
        System.out.println("MENU");
        System.out.println("1.Add Game");
        System.out.println("2: Delete Game");
        System.out.println("3: Update Game");
        System.out.println("4: Search Game");
        System.out.println("5: Display Game");
        System.out.println("6: Incasari");
        System.out.println("7: Exit program");
        System.out.print("Enter your selection : ");
    }
}

