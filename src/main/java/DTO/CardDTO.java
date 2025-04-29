package DTO;

import entities.Transaction;
import enums.CardStatus;

import java.time.LocalDate;
import java.util.List;

public class CardDTO {
    private Long id;
    private String cardNumber;
    private String holderName;
    private LocalDate expirationDate;
    private CardStatus status;
    private int balance;
    private List<Transaction> transactions;

    public CardDTO() {}

    public CardDTO(Long id, String cardNumber, String holderName, LocalDate expirationDate, CardStatus status, int balance, List<Transaction> transactions) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.expirationDate = expirationDate;
        this.status = status;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
