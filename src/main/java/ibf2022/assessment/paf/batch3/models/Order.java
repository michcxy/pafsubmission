package ibf2022.assessment.paf.batch3.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

public class Order {

    private String orderId;
    private LocalDate orderDate;
    private String breweryId;
    private List<Item> orders = new ArrayList<>();

    public Order() {
    }

    public Order(String orderId, LocalDate orderDate, String breweryId, List<Item> orders) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.breweryId = breweryId;
        this.orders = orders;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(String breweryId) {
        this.breweryId = breweryId;
    }

    public List<Item> getOrders() {
        return orders;
    }

    public void setOrders(List<Item> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", breweryId=" + breweryId + ", orders="
                + orders + "]";
    }

    public JsonObject toJSON(){

        JsonArrayBuilder orderArr = Json.createArrayBuilder();
        for(Item i : getOrders()) {
            orderArr.add(i.toJson());
        }

        return Json.createObjectBuilder()
            .add("orderId", this.getOrderId())
            .add("date", this.getOrderDate().toString())
            .add("breweryId", this.getBreweryId())
            .add("orders", orderArr)
            .build();
    }


    
}
