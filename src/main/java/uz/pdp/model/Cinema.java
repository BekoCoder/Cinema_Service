package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cinema  extends  BaseModel{
    private String name;
    private int price;


    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
