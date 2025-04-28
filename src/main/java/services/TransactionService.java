package services;

import entities.Card;
import entities.Transaction;
import entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("transaction not found"));
        transaction.setAmount(transactionDetails.getAmount());
        transaction.setDescription(transactionDetails.getDescription());
        transaction.setTimestamp(transactionDetails.getTimestamp());
        transaction.setType(transactionDetails.getType());

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllCards() {
        return transactionRepository.findAll();
    }
    public Optional<Transaction> getCardById(Long id) {
        return transactionRepository.findById(id);
    }
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
        transactionRepository.delete(transaction);
    }  
}
