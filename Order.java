/**
 * Represents a customer order containing up to three menu items.
 * @author Nick Banzon
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
    }

    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return false;
        } else if (item1 == null) {
            item1 = item;
            itemCount++;
            return true;
        } else if (item2 == null) {
            item2 = item;
            itemCount++;
            return true;
        } else if (item3 == null) {
            item3 = item;
            itemCount++;
            return true;
        } else {
            System.out.println("Order is full. Cannot add "
                    + item.getName() + " ["
                    + item.getItemCode() + "].");
            return false;
        }
    }

    public double computeSubtotal() {
        double subtotal = 0.0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {
        double subtotal = computeSubtotal();

        if (customer != null && customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        } else {
            return subtotal;
        }
    }

    public double computeTotal(double voucher) {
        double total = computeTotal();

        if (voucher < 0) {
            System.out.println("Error: voucher cannot be negative.");
            voucher = 0;
        }

        total -= voucher;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    public void printReceipt() {
        printReceiptDetails(0.0, false);
    }

    public void printReceipt(double voucher) {
        printReceiptDetails(voucher, true);
    }

    private void printReceiptDetails(double voucher, boolean useVoucher) {
        double subtotal = computeSubtotal();
        double discount = 0.0;

        if (customer != null && customer.isStudent()) {
            discount = subtotal * 0.10;
        }

        double total;

        if (useVoucher) {
            total = computeTotal(voucher);
        } else {
            total = computeTotal();
        }

        System.out.println("Order #" + orderId + " — "
                + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        printItem(item1);
        printItem(item2);
        printItem(item3);

        System.out.printf("  Subtotal: %.2f%n", subtotal);

        if (discount > 0) {
            System.out.printf(
                    "  Student discount (10%%): -%.2f%n", discount);
        }

        if (useVoucher && voucher > 0) {
            System.out.printf(
                    "  Voucher: -%.2f%n",
                    Math.min(voucher, Math.max(0, subtotal - discount)));
        }

        System.out.printf("  TOTAL: %.2f%n", total);

        customer.addPoints(total);

        System.out.println("  Loyalty points: "
                + customer.getLoyaltyPoints());

        System.out.println();
    }

    private void printItem(MenuItem item) {
        if (item != null) {
            System.out.printf("  %-48s %.2f%n",
                    item.getDescription(), item.computePrice());
        }
    }
}