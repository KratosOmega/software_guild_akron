/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.olympiandidemo;

import com.sg.olympiandidemo.dto.Event;
import com.sg.olympiandidemo.dto.Olympian;
import com.sg.olympiandidemo.dto.SkiJumpEvent;
import com.sg.olympiandidemo.dto.SkiJumper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author softwareguild
 */
public class OlympianApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new 
            ClassPathXmlApplicationContext("applicationContext.xml");
        
        /*
        SkiJumper sj = (SkiJumper) ctx.getBean("superSkiJumper");
        sj.competeInEvent();*/
        /*
        Event skiJumpEvent = new SkiJumpEvent();
        Olympian olympianSkiJumper = new Olympian(skiJumpEvent);
        olympianSkiJumper.competeInEvent();
        */
        
        Olympian usaSkiJumper = (Olympian) ctx.getBean("usaSkiJumper");
        usaSkiJumper.competeInEvent();
        
        Olympian usaSpeedSkater = (Olympian) ctx.getBean("usaSpeedSkater");
        usaSpeedSkater.competeInEvent();
        
        Olympian russianCrossCountrySkier = 
                (Olympian)ctx.getBean("russianCrossCountrySkier");
        russianCrossCountrySkier.competeInEvent();
    }
}
