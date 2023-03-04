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
public class Card extends  BaseModel {
    private String CardNumber;
    private int balance;
    private String ExpiryDate;
    private UUID userId;


    @Override
    public String toString() {
        return "Card{" +
                "CardNumber='" + CardNumber + '\'' +
                ", balance=" + balance +
                ", ExpiryDate='" + ExpiryDate + '\'' +
                '}';
    }
}
