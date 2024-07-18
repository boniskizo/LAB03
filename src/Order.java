import java.util.ArrayList;
import java.util.List;

public class Order {
    private double totalPrice;
    private int itemCount;
    private double shippingCost = 10;
    private List<OrderObserver> observers = new ArrayList<>();

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getCount() {
        return itemCount;
    }

    public void addItem(double price) {
        totalPrice += price;
        itemCount++;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Total Price : $" + totalPrice + "\nNumber of Items : " + itemCount + "\nShipping cost : $" + shippingCost;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
}
