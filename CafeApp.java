/**
 * Runs the Campus Cafe Ordering System.
 * @author Nick Banzon
 * @version 1.0
 */
public class CafeApp {

    public static void main(String[] args) {

        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        Beverage icedLatte = new Beverage(
                "Iced Latte", 95.00, "B-01", "L");

        Pastry ensaymada = new Pastry(
                "Ensaymada", 45.00, "P-01", true);

        Meal chickenAdobo = new Meal(
                "Chicken Adobo", 110.00, "M-01", true, 1);

        Order order1 = new Order("1001", ana);

        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);

        Pastry cookie = new Pastry(
                "Cookie", 25.00, "P-02", false);

        order1.addItem(cookie);

        order1.printReceipt();

        Beverage hotChocolate = new Beverage();

        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal();

        beefTapa.setName("Beef Tapa");
        beefTapa.setBasePrice(130);
        beefTapa.setItemCode("M-02");
        beefTapa.setUpsized(false);
        beefTapa.setExtraSides(0);

        Pastry plainBread = new Pastry();

        plainBread.setName("Plain Bread");
        plainBread.setBasePrice(30);
        plainBread.setItemCode("P-03");
        plainBread.setWarmed(false);

        Order order2 = new Order("1002", ben);

        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);

        order2.printReceipt(20.00);
    }
}