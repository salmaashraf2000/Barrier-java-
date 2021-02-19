/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.barrier;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.util.Random; 
public class Barrier_sem extends Barrier implements Runnable
{
    private final Semaphore mutex;
    private final Semaphore blockerSemaphore;
    
    public Barrier_sem(int waitingCount)
    {
        super(waitingCount);
        mutex = new Semaphore(1);
        blockerSemaphore = new Semaphore(0);
    }
    
    public void barrierPoint()
    {
        if(this.noOfWatingThreads==this.maxWaiting)
        {
               this.blockerSemaphore.release();
               System.out.printf("All threads reached the barrier,barrier is opened\n");
        }
    }
    
    @Override
    public void run()
    {
        try {
           synchronized(this)
           {
              mutex.acquire();
              this.noOfWatingThreads++;
              System.out.printf("The thread is waiting ,number of threads waiting %d\n",this.noOfWatingThreads);
              Random rand = new Random(); 
              int random = rand.nextInt(50); 
           
              for(int i=0;i<random;i++)
              {
                 Thread.sleep(100);    
              }
              mutex.release();
              this.barrierPoint();
           }
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
    
}