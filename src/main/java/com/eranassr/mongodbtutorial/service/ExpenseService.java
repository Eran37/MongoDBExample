package com.eranassr.mongodbtutorial.service;

import com.eranassr.mongodbtutorial.model.Expense;
import com.eranassr.mongodbtutorial.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.repository = expenseRepository;
    }


    public void addExpense(Expense expense) {
        repository.insert(expense);
    }

    public void updateExpense(Expense expense) {
        Expense savedExpense = repository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense By ID %s", expense.getId())
                ));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setCategory(expense.getCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        repository.save(savedExpense);
    }

    @GetMapping
    public List<Expense> getAllExpense() {
        return repository.findAll();
    }


    public Expense getExpenseByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense By Name %s", name)
                ));
    }


    public void deleteExpense(String id) {
        repository.deleteById(id);
    }

}
