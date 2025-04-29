package controllers;

import DTO.CardDTO;
import entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CardService;
import utils.ErrorMessage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Object> createCard(@RequestBody CardDTO cardDTO) {
        try {
            Card createdCard = cardService.createCard(convertToEntity(cardDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCard); //201
        } catch (DataIntegrityViolationException e) {
            ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage); //400
        } catch (Exception e) {
            ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage); //500
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getCardById(@PathVariable Long id) {
        Optional<Card> Card = cardService.getCardById(id);
        return Card.map(this::convertToDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CardDTO> getAllCards() {
        return cardService.getAllCards().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCard(@PathVariable Long id, @RequestBody CardDTO cardDTO) {
        try {
            Card updatedCard = cardService.updateCard(id, convertToEntity(cardDTO));
            return ResponseEntity.ok(updatedCard);
        } catch (DataIntegrityViolationException e) {
            ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        } catch (RuntimeException e) {
            ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (Exception e) {
            ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }

    private Card convertToEntity(CardDTO cardDTO) {
        Card card = new Card();
        card.setId(cardDTO.getId());
        card.setCardNumber(cardDTO.getCardNumber());
        card.setHolderName(cardDTO.getHolderName());
        card.setExpirationDate(cardDTO.getExpirationDate());
        card.setStatus(cardDTO.getStatus());
        card.setBalance(cardDTO.getBalance());
        card.setTransactions(cardDTO.getTransactions());
        return card;
    }

    private CardDTO convertToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setHolderName(card.getHolderName());
        cardDTO.setExpirationDate(card.getExpirationDate());
        cardDTO.setStatus(card.getStatus());
        cardDTO.setBalance(card.getBalance());
        cardDTO.setTransactions(card.getTransactions());
        return cardDTO;
    }
}