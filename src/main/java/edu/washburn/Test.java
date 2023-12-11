package edu.washburn;

public class Test {
    public static void main(String[] args) {
        Query defaultQuery = new Query();
        System.out.println(defaultQuery.getPrice());
        defaultQuery.dumpHTML();
    }
}