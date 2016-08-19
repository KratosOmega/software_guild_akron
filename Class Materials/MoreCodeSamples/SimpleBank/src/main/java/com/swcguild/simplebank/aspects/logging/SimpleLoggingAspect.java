/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplebank.aspects.logging;

import com.swcguild.simplebank.domain.Account;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author eric
 */
// TODO - add real logging...

public class SimpleLoggingAspect implements Serializable {
    
    public Map<String, Map<String, Long>> stats = new HashMap<String, Map<String, Long>>();
    
    public Map getStats() {
        return stats;
    }
    
    public Object timeMethod(ProceedingJoinPoint jp) {
        Object ret = null;
        Map<String, Long> ms = stats.get(jp.getSignature().getName());
        if (ms == null) {
            ms = new HashMap<String, Long>();
            ms.put("count", new Long(0));
            stats.put(jp.getSignature().getName(), ms);
        }
        try {
            long start = System.currentTimeMillis();
            ret = jp.proceed();
            long end = System.currentTimeMillis();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(jp.getSignature().getName() + " took " + (end - start) + " ms");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            
            ms.put("lastCallTime", new Long(end - start));
            Long count = ms.get("count");
            count++;
            ms.put("count", count);
        } catch (Throwable ex) {
            System.out.println("Exception in SimpleLoggingAspect.timeMethod()");
        }       
        return ret;
    }
    
    public void logEntry(JoinPoint jp) {
        System.out.println("SIMPLE LOGGER:  Entering " + jp.getSignature().getName());
        
    }
    
    public void logExit(JoinPoint jp) {
        System.out.println("Exiting " + jp.getSignature().getName());
    }
    
    public void logException(JoinPoint jp) {
        System.out.println("Exception in " + jp.getSignature().getName());
    }
    
    public void logTransfer(Account toAcct, Account fromAcct, double amount) {
        System.out.println("To Account      = " + toAcct.getId() + "\n" +
                           "From Account    = " + fromAcct.getId() + "\n" + 
                           "Transfer Amount = " + amount);
    }
    
    public void clearStats() {
        stats.clear();
    }
    
}
