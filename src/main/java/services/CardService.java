package services;

import entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Card cardUpdate(Long id, Card cardDetails) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("card not found"));
        card.setCardNumber(card.getCardNumber());
        card.setHolderName(card.getHolderName());
        card.setExpirationDate(card.getExpirationDate());
        card.setStatus(card.getStatus());
        card.setBalance(card.getBalance());
        card.setTransactions(card.getTransactions());

        return cardRepository.save(card);
    }

    public List<Card> getAllCards() {return cardRepository.findAll();}
    public Optional<Card> getCardById(Long id) {return cardRepository.findById(id);}
    public Card createCard(Card card) {return cardRepository.save(card);}
    public void deleteCard(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("card not found"));
        cardRepository.delete(card);
    }
}
