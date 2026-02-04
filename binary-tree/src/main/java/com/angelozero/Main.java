package com.angelozero;

import java.util.Random;


public class Main {
    static void main() {

        BinaryTreeService service = new BinaryTreeService();

        service.insert(new Node(4));
        service.insert(new Node(2));
        service.insert(new Node(7));
        service.insert(new Node(1));
        service.insert(new Node(3));
//        service.insert(new Node(2));
//        service.insert(new Node(6));
//        service.insert(new Node(9));
//        service.insert(new Node(8));

//        service.remove(5);
//
//        System.out.println();
//        System.out.println(service.getNodesList());
//        System.out.println(service.getReverseNodesList());
//        System.out.println();
//
//        var randomValue = getRandomNumber();
//        System.out.println(service.search(randomValue) ?
//                "Number " + randomValue + " was found!"
//                : "Number " + randomValue + " wasn't found!");

        service.search(2);
        System.out.println(service.getOriginalNodesList());
        System.out.println(service.getSearchNodesList());

        service.getOriginalNodesList().forEach(System.out::println);


    }

    private static Integer getRandomNumber(){
        Random random = new Random();
        return random.nextInt(20);
    }
}
