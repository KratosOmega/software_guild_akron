/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.olympiandidemo.test;

import com.sg.olympiandidemo.dto.SkiJumper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author softwareguild
 */
public class OlympianDIDemoTest {
    
    public OlympianDIDemoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void SkiJumperTest(){
        SkiJumper jumper = new SkiJumper();
        assertEquals(jumper.competeInEvent(),"SkiJump");
    }
    
    @Test
    public void SkiJumperBeanTest(){
        ApplicationContext ctx = new 
            ClassPathXmlApplicationContext("applicationContext.xml");
        SkiJumper sj = (SkiJumper) ctx.getBean("superSkiJumper");
        assertEquals(sj.competeInEvent(),"SkiJump");
    }
}
