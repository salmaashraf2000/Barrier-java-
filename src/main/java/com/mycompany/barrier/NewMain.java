/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.barrier;


public class NewMain 
{

   
    public static void main(String[] args) 
    {
        
        int No_Threads=6;
        Barrier_sem b = new Barrier_sem(No_Threads);
        
        for(int i=0;i<No_Threads;i++)
        {
            Thread T = new Thread(b);
            T.start();
        }
    }
    
}