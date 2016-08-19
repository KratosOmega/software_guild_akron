/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.inheritancedemo.dto;

/**
 *
 * @author softwareguild
 */
public class Dog extends Animal {
    private String barkWord;
    
    @Override
    public void move(){
        // Run!!!
    }
    
    public Dog(String bark){
     this.barkWord = bark;   
    }

    /**
     * @return the barkWord
     */
    public String getBarkWord() {
        return barkWord;
    }

    /**
     * @param barkWord the barkWord to set
     */
    public void setBarkWord(String barkWord) {
        this.barkWord = barkWord;
    }
}
