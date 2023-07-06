package com.eranassr.mongodbtutorial.controller;

import com.eranassr.mongodbtutorial.model.Expense;
import com.eranassr.mongodbtutorial.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        service.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense) {
        service.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense() {
        return ResponseEntity.ok(service.getAllExpense());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        service.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
