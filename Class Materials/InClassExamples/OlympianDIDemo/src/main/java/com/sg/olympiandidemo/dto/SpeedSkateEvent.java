/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.olympiandidemo.dto;

/**
 *
 * @author softwareguild
 */
public class SpeedSkateEvent implements Event {
    public String compete(){
        System.out.println("Skating SUPER FAST!");
        return "SpeedSkate";
    }
}
