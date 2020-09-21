package com.example.mypackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> tmpExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));

        tmpExit = new HashMap<>();
        tmpExit.put("W", 2);
        tmpExit.put("E", 3);
        tmpExit.put("S", 4);
        tmpExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of road before a small brick building",tmpExit));
        
        tmpExit = new HashMap<>();
        tmpExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of hill",tmpExit));
        
        tmpExit = new HashMap<>();
        tmpExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tmpExit));
        
        tmpExit = new HashMap<>();
        tmpExit.put("N", 1);
        tmpExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tmpExit));


        tmpExit = new HashMap<>();
        tmpExit.put("S", 1);
        tmpExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tmpExit));


        Map<String,String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            //tmpExit.remove("S");
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();

            if(direction.length()>1){
                String[]words = direction.split(" ");
                for (String word:words) {
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }


    }

}
