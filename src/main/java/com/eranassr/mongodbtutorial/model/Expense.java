package com.eranassr.mongodbtutorial.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("expense")
public class Expense {

    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;
    @Field(name = "category")
    private ExpenseCategory category;
    @Field(name = "amount")
    private BigDecimal expenseAmount;

    public Expense(String id, String expenseName, ExpenseCategory category, BigDecimal expenseAmount) {
        this.id = id;
        this.expenseName = expenseName;
        this.category = category;
        this.expenseAmount = expenseAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", expenseName='" + expenseName + '\'' +
                ", category=" + category +
                ", expenseAmount=" + expenseAmount +
                '}';
    }

}
