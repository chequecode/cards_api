package DTO;

import entities.Card;
import enums.TransactionTypes;

import java.time.LocalDateTime;

public class TransactionDTO {
    private Long id;
    private Long amount;
    private String description;
    private LocalDateTime timestamp;
    private TransactionTypes types;
    private Card card;

    public TransactionDTO() {}

    public TransactionDTO(Long id, Long amount, String description, LocalDateTime timestamp, TransactionTypes types, Card card) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.types = types;
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionTypes getType() {
        return types;
    }

    public void setType(TransactionTypes types) {
        this.types = types;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
