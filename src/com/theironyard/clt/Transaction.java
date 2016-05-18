package com.theironyard.clt;

/**
 * Created by Ben on 5/17/16.
 */
public class Transaction {
    TransactionType type;
    Integer id;
    int value;


    public Transaction(TransactionType type, int id, int value) {
        this.type = type;
        this.id = id;
        this.value = value;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public enum TransactionType {
        GROCERY,
        ONLINE_SHOPPING,
        GAS,
        UTILITIES,
        BILLS
    }
}
