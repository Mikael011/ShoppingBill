public class ShoppingBillModel {

    static class Game {
        // properties
        private int Id;
        private String name;

        private String dezvoltator;
        private int quantity;
        private double price;
        private double totalPrice;

        public Game(int Id, String name, String dezvoltator, int quantity, double price, double totalPrice) {
            this.Id=Id;
            this.name = name;
            this.dezvoltator = dezvoltator;
            this.quantity = quantity;
            this.price = price;
            this.totalPrice = totalPrice;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            this.Id = Id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDezvoltator() {
            return dezvoltator;
        }

        public void setDezvoltator(String dezvoltator) {
            this.dezvoltator = dezvoltator;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice() {
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "id='" + Id + '\'' +
                    ", name='" + name + '\'' +
                    ", dezvoltator='" + dezvoltator + '\'' +
                    ", stock=" + quantity +
                    ", price=" + price +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
        //displayFormat
        public static void displayFormat()
        {
            System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("\nProduct ID \t\t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");
            System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
        }

        // display
        public void display()
        {
            System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n" ,Id, name,dezvoltator, quantity, price, totalPrice);
        }
    }
}

