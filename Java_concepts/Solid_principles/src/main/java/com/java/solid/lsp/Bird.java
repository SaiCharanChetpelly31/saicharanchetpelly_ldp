package com.java.solid.lsp;

class Bird extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Chirp");
    }
}