/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverinventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ServerInventoryListExample {
    
    public static void main (String[] args) {
        // We'll hold our server objects in an ArrayList for this example
        List<Server> servers = new Stack<>();

        // Create several server objects and add them to our list
        Server one = new Server();
        one.setName("web01");
        one.setIp("192.168.1.1");
        one.setMake("Dell");
        one.setRam("8GB");
        one.setNumProcessors("9");
        one.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
        one.setName("db01");
        one.setIp("192.168.3.45");
        one.setMake("HP");
        one.setRam("16GB");
        one.setNumProcessors("24");
        one.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
        one.setName("hr124");
        one.setIp("192.168.32.111");
        one.setMake("IBM");
        one.setRam("16GB");
        one.setNumProcessors("12");
        one.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
        one.setName("eng16");
        one.setIp("192.168.32.56");
        one.setMake("HP");
        one.setRam("4GB");
        one.setNumProcessors("8");
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
        one.setName("eng64");
        one.setIp("192.168.34.56");
        one.setMake("HP");
        one.setRam("8GB");
        one.setNumProcessors("16");
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);
        
        // example - find all servers for given make
        // note we are ignoring case when we compare make
        String make = "dElL";
        System.out.println("All " + make + " servers in inventory: ");
        servers
                .stream()
                .filter(s -> s.getMake().equalsIgnoreCase(make))
                .forEach(e -> System.out.println(e.getName()));

        // example - print all server names older than a given age
        long testAge = 3;
        System.out.println("All servers older than " + testAge + " years in inventory:");
        servers
                .stream()
                .filter(s -> s.getServerAge() > testAge)
                .forEach(e -> System.out.println(e.getName()));

        // get a list of all servers older than a given age
        List<Server> oldServers
                = servers
                .stream()
                .filter(s -> s.getServerAge() > testAge)
                .collect(Collectors.toList());
        
        // print the size of our list
        System.out.println(oldServers.size());
        
        // print out the name of each server in the list
        oldServers.forEach(s -> System.out.println(s.getName()));

        // example - calculate the average age of servers in inventory
        float averageAge = (float) servers
                .stream()
                .mapToLong(Server::getServerAge)
                .average()
                .getAsDouble();
        System.out.println("Average age of servers is " + averageAge + " years.");
    }    
}
