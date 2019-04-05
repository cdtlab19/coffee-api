package com.cdtlab.coffeeapi.services;

import org.springframework.beans.factory.annotation.Autowired;

public class CoffeeService {

    @Autowired
    private BlockchainRepository repo;

    String chainCodeName = "cc-account";

    public void createCoffee() { //passando o café como parâmetro
        repo.invoke();
    }

    public void updateCoffee() {
        repo.invoke();
    }

    public void deleteCoffee(Integer coffeeId) {
        repo.invoke();
    }

    public void getCoffee(Integer coffeeId) {
        repo.invoke();
    }

    public void allCoffee(Integer coffeeId, Integer userId) {
        repo.invoke();
    }

    public void userCoffee() {
        repo.invoke();
    }

}