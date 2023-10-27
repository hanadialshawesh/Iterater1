package org.example;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please Choose   1.double linkedlist  2. single linkedlist ");
        int n =sc.nextInt();
            if(n==1) {
            Double<Integer> nodes = new Double<>();
            System.out.print("Please enter the size of the node ");
             int size  = sc.nextInt();

              System.out.print("Enter a numbers  : ");
              for (int i = 0; i < size; i++)
                nodes.addLast( sc.nextInt());

            Iterator<Integer> iter = nodes.iterator();

            do {
                System.out.println(iter.next() / 2);
            } while (iter.hasNext());


            } else if (n==2) {

             Linkedlist<Integer> nodes = new Linkedlist<>();
             System.out.print("Please enter the size of the node ");
              int size  = sc.nextInt();

              System.out.print("Enter a numbers  : ");
              for (int m = 0; m < size; m++)
                nodes.addLast( sc.nextInt());

            Iterator<Integer> iterater = nodes.iterator();

            do {
                System.out.println(iterater.next() * 2);
            } while (iterater.hasNext());
        }
    }
}