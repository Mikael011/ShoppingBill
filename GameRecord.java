import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class GameRecord {
    // Creating an empty LinkedList
    ArrayList<ShoppingBillModel.Game> list = new ArrayList<ShoppingBillModel.Game>();

    // Default Constructor
    public void GameRecordManagement(ShoppingBillModel.Game game) {
        list = new ArrayList<>();
        list.add(game);
    }
    public void add(ShoppingBillModel.Game game) {

        if (!find(game.getId())) {
            list.add(game);
        } else {
            System.out.println(
                    "Game already exists in the Game list");
        }
    }

    // Method 2
    // Searching Game
    public boolean find(int idNumber) {

        for (ShoppingBillModel.Game l : list) {

            if (l.getId() == (idNumber)) {

                System.out.println(l);
                return true;
            }
        }
        return false;
    }

    // Method 3
    // Delete Game
    public void delete(int GameIdNumber) {
        ShoppingBillModel.Game GameDelete = null;

        for (ShoppingBillModel.Game ll : list) {

            if (ll.getId()==(GameIdNumber)) {
                GameDelete = ll;
            }
        }

        if (GameDelete == null) {
            System.out.println("Invalid game Id");
        } else {
            list.remove(GameDelete);
            System.out.println(
                    "Successfully removed game from the list");
        }
    }

    // Method 4
    // Finding Game
    public ShoppingBillModel.Game findGame(int idNumber) {

        for (ShoppingBillModel.Game l : list) {
            if (l.getId()==(idNumber)) {
                return l;
            }
        }
        return null;
    }

    // Method 5
    // Update Game
    public void update(int id, Scanner input) {

        if (find(id)) {
            ShoppingBillModel.Game game = findGame(id);

            System.out.print(
                    "What is the new Game id ? ");
            int idNumber = input.nextInt();

            System.out.print("What is the new Game name ? ");
            String name = input.nextLine();
            input.nextLine();

            System.out.print("What is the new Game developer ? ");
            String nameDev = input.nextLine();

            System.out.print("What is the new Game date ? ");
            String date = input.nextLine();
            input.nextLine();

            System.out.println("What is the new Game price ?");
            Float price = input.nextFloat();
            input.nextLine();

            System.out.println("What is the new Game stock ?");
            int stock = input.nextInt();

            game.setId(idNumber);
            game.setName(name);
            game.setDezvoltator(nameDev);
            game.setPrice(price);
            game.setQuantity(stock);
            game.setTotalPrice();
            System.out.println("Game Updated Successfully");
        } else {

            // Print statement
            System.out.println("Record Not Found in the Game list");
        }
    }

    // Method 6
    // Display Games
    public void display() {
        if (list.isEmpty()) {
            System.out.println("The list has no games\n");
        }
        // Iterating Record list
        // using for each loop
        for (ShoppingBillModel.Game game : list) {
            System.out.println(game.toString());
        }
    }
}
