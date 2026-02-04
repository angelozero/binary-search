package com.angelozero;

import java.util.Random;


public class Main {
    static void main() {

        BinaryTreeService service = new BinaryTreeService();

        service.insert(new Node(4));
        service.insert(new Node(5));
        service.insert(new Node(7));
        service.insert(new Node(1));
        service.insert(new Node(3));
        service.insert(new Node(2));
        service.insert(new Node(6));
        service.insert(new Node(9));
        service.insert(new Node(8));

        //service.remove(5);

        System.out.println();
        System.out.println("crescent list:   " + service.getNodesList());
        System.out.println("decreasing list: " + service.getReverseNodesList());
        System.out.println("original list:   " + service.getOriginalNodesList());
        System.out.println();

        var randomValue = getRandomNumber();
        System.out.println(service.search(randomValue) ?
                "Number " + randomValue + " was found!"
                : "Number " + randomValue + " wasn't found!");

        System.out.println("searched list:   " + service.getSearchNodesList());
        System.out.println();
    }

    private static Integer getRandomNumber() {
        Random random = new Random();
        return random.nextInt(12);
    }
}
