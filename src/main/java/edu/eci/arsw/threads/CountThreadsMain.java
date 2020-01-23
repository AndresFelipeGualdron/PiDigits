/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {





    public static void main(String a[]){
        CountThread countThreadOne = new CountThread(0,99);
        CountThread countThreadTwo = new CountThread(100, 199);
        CountThread countThreadThree = new CountThread(200,299);

        Thread threadOne = new Thread(countThreadOne);
        Thread threadTwo = new Thread(countThreadTwo);
        Thread threadThree = new Thread(countThreadThree);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }

}
