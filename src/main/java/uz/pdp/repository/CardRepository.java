package uz.pdp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import uz.pdp.model.Card;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static uz.pdp.util.FileUtil.cardPath;
import static uz.pdp.util.FileUtil.objectMapper;

public interface CardRepository {
    File file=new File(cardPath);

    default ArrayList<Card> getCardListFile(){
        try {
          return   objectMapper.readValue(file, new TypeReference<ArrayList<Card>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    default void writoCardList(ArrayList<Card> cardList){
        try {
            objectMapper.writeValue(file, cardList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
