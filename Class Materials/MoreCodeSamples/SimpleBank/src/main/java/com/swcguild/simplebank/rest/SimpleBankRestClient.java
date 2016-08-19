/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplebank.rest;

import com.swcguild.simplebank.domain.AccountHolder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author eric
 */
public class SimpleBankRestClient {

    public static void main(String[] args) {
//        AccountHolder holder = getAccountHolder(1);
//        holder.setName("Johnny REST");
//        updateAccountHolder(holder);
//        AccountHolder newHolder = getAccountHolder(holder.getId());
//        System.out.println(newHolder.getName());
        AccountHolder holder = new AccountHolder();
        holder.setName("Resty REST");
        AccountHolder newHolder = createAccountHolder(holder);
        System.out.println(newHolder.getId());
        System.out.println(newHolder.getName());
    }

    public @ResponseBody
    static AccountHolder getAccountHolder(int id) {
        RestTemplate rt = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        //converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new MappingJacksonHttpMessageConverter());
        rt.setMessageConverters(converters);
        AccountHolder holder = rt.getForObject("http://localhost:8080/SimpleBank/accountHolder/rest/{id}", AccountHolder.class, id);
        return holder;
    }

    public @ResponseBody
    static void updateAccountHolder(AccountHolder holder) {
        RestTemplate rt = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        //converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new MappingJacksonHttpMessageConverter());
        //converters.add(new StringHttpMessageConverter());
        rt.setMessageConverters(converters);
        String url = "http://localhost:8080/SimpleBank/accountHolder/rest/" + holder.getId();
        rt.put("http://localhost:8080/SimpleBank/accountHolder/rest/{id}", holder, holder.getId());
        //rt.put(url, holder);

    }
    
    public @ResponseBody
    static AccountHolder createAccountHolder(AccountHolder holder) {
        RestTemplate rt = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        //converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new MappingJacksonHttpMessageConverter());
        //converters.add(new StringHttpMessageConverter());
        rt.setMessageConverters(converters);
        String url = "http://localhost:8080/SimpleBank/accountHolder/rest/";
        return rt.postForObject("http://localhost:8080/SimpleBank/accountHolder/rest", holder, AccountHolder.class);
        
    } 
}
