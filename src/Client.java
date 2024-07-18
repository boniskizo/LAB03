public class Client {
    public static void main(String[] args) {
        Order order = new Order();
        OrderObserver priceObserver = new PriceObserver();
        OrderObserver quantityObserver = new QuantityObserver();

        order.attach(priceObserver);
        order.attach(quantityObserver);

        order.addItem(100);
        order.addItem(150);
        order.addItem(50);
        order.addItem(30);
        order.addItem(20);
        order.addItem(10);

        System.out.println(order);
        //Change for commit

        if (order.getTotalPrice() > 200) {
            System.out.println("$20 Discount provided !");
        }

        if (order.getCount() > 5) {
            System.out.println("No shipping cost");
        } else {
            System.out.println("$10 shipping cost");
        }
    }
}
