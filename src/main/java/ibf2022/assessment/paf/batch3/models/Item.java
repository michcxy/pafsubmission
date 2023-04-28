package ibf2022.assessment.paf.batch3.models;

import jakarta.json.Json;
import jakarta.json.JsonValue;

public class Item {
    
    private Integer beerId;
    private Integer quantity;

    public Item(int beerId, int quantity){
        this.beerId = beerId;
        this.quantity = quantity;
    }
    public JsonValue toJson() {
        return Json.createObjectBuilder()
        .add("beerId", beerId)
        .add("quantity", quantity)
        .build();
    }
}

