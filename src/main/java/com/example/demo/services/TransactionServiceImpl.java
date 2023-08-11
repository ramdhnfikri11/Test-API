package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Transaction;
import com.example.demo.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    
    @Override
    public List<Transaction> Get() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction Get(Integer id) {
        return transactionRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Transaction model) {
        transactionRepository.save(model);
        return transactionRepository.findById(model.getTransaction_id()).isPresent();
    }
    
    @Override
    public Boolean Delete(Integer id) {
        transactionRepository.deleteById(id);
        return !transactionRepository.findById(id).isPresent();
    }
    
}
