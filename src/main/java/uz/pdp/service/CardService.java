package uz.pdp.service;

import uz.pdp.model.Card;
import uz.pdp.repository.CardRepository;

import java.util.ArrayList;
import java.util.UUID;

public class CardService implements CardRepository {
    public boolean checkCard(ArrayList<Card> cards, String cardNumber){
        for (Card card:getCardListFile() ) {
            if(card.getCardNumber().equals(cardNumber)){
                return true;
            }
        }
        return false;
    }


    public boolean addCard(Card card){
        ArrayList<Card> cardList=getCardListFile();
        if (checkCard(cardList, card.getCardNumber())){
            return false;
        }
        cardList.add(card);
        writoCardList(cardList);
        return true;
    }

    public boolean fillCard( String cardNumber, UUID userid,int balance){
        ArrayList<Card> cardList= getCardListFile();
        for (Card card: getCardListFile()) {
            if( card.getUserId().equals(userid) && card.getCardNumber().equals(cardNumber)){
                card.setBalance(card.getBalance()+balance);
                cardList.add(card);
                writoCardList(cardList);
                return true;
            }
        }
        return false;

    }
    public UUID getcardId(UUID id){
        for (Card card: getCardListFile()) {
            if(card.getId().equals(id)){
                return card.getId();
            }
        }
        return null;
    }

        public void myCardList(UUID userid){
            for (Card card: getCardListFile()) {
                if(card.getUserId().equals(userid)){
                    System.out.println(card);
                }
            }
        }


}
