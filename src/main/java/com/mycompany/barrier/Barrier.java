/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.barrier;

public abstract class Barrier
{
    protected volatile int noOfWatingThreads;
    protected final int maxWaiting;

    public Barrier(int maxWaiting) 
    {
        this.maxWaiting = maxWaiting;
        noOfWatingThreads=0;
    }
    
    public abstract void barrierPoint();        
}