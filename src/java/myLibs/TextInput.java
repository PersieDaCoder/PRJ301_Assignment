/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myLibs;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TextInput {

    public static String StringRegex(String requireText, String regex, String error) {
        Scanner sc = new Scanner(System.in);
        try {
            boolean pass = false;
            while (!pass) {
                System.out.print(requireText);
                String input = sc.nextLine();
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        } catch (Exception e) {
            System.out.println("cac");
        }
        return null;
    }

    public static int IntergerRegex(String requireText, String error, int min, int max) {
        Scanner sc = new Scanner(System.in);
        try {
            boolean pass = false;
            while (!pass) {
                System.out.print(requireText);
                int input = Integer.parseInt(sc.nextLine());
                if (min <= input && input <= max) {
                    return input;
                }
                else System.out.println(error);
            }
        } catch (Exception e) {
            System.out.println("!! Error !!");
        }
        return -1;
    }
    
    public static boolean isTextMatchRegex(String text, String regex){
        if(text.matches(regex)) return true;
        return false;
    }
}
