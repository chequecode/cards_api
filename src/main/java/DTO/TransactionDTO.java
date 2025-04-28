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
}
