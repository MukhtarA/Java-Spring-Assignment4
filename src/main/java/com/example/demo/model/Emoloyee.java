package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Emoloyee {
    private final UUID id;
    private final String fullName;

    public Emoloyee(@JsonProperty("id") UUID id, @JsonProperty("name") String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}












