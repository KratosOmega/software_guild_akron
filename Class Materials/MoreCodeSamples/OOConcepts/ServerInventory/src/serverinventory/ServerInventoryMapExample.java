/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverinventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ServerInventoryMapExample {
    
    public static void main(String[] args) {
        // Use a Map to hold our Server objects
        // Use server name as the key since servers must be unique on the 
        // network
        Map<String, Server> serverMap = new HashMap<>();

        // Create servers and add to our Map
        Server one = new Server();
        one.setName("web01");
        one.setIp("192.168.1.1");
        one.setMake("Dell");
        one.setRam("8GB");
        one.setNumProcessors("9");
        one.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        serverMap.put(one.getName(), one);

        one = new Server();
        one.setName("db01");
        one.setIp("192.168.3.45");
        one.setMake("HP");
        one.setRam("16GB");
        one.setNumProcessors("24");
        one.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

        serverMap.put(one.getName(), one);

        one = new Server();
        one.setName("hr124");
        one.setIp("192.168.32.111");
        one.setMake("IBM");
        one.setRam("16GB");
        one.setNumProcessors("12");
        one.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));

        serverMap.put(one.getName(), one);

        one = new Server();
        one.setName("eng16");
        one.setIp("192.168.32.56");
        one.setMake("HP");
        one.setRam("4GB");
        one.setNumProcessors("8");
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        serverMap.put(one.getName(), one);

        one = new Server();
        one.setName("eng64");
        one.setIp("192.168.34.56");
        one.setMake("HP");
        one.setRam("8GB");
        one.setNumProcessors("16");
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        serverMap.put(one.getName(), one);
        
        // Find all servers of a particular make (case insensitive)
        // Note that we use the Collection returned from values() as the
        // source of our stream
        String make = "dElL";
        System.out.println("All " + make + " servers in inventory: ");
        serverMap.values()
                .stream()
                .filter(s -> s.getMake().equalsIgnoreCase(make))
                .forEach(e -> System.out.println(e.getName()));

        // example - find all servers older than a given age
        int testAge = 3;
        System.out.println("All servers older than " + testAge + " years in inventory:");
        serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() > testAge)
                .forEach(e -> System.out.println(e.getName()));

        // get a list of all servers older than a given age
        Collection<Server> oldServers
                = serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() > testAge)
                .collect(Collectors.toList());

        System.out.println(oldServers.size());
        oldServers.forEach(s -> System.out.println(s.getName()));

        // example - calculate the average age of servers in inventory
        double averageAge = serverMap.values()
                .stream()
                .mapToLong(Server::getServerAge)
                .average()
                .getAsDouble();
        System.out.println("Average age of servers is " + averageAge + " years.");
        
    }
    
}
