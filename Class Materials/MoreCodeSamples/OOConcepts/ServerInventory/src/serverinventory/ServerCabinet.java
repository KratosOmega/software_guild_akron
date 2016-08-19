/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverinventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ServerCabinet {
    
    public static final String CABINET_FILE = "servers.txt";
    public static final String DELIMITER = "::";
    
    private HashMap<String, Server> servers = new HashMap<>();
    
    public int count() {
        return servers.size();
    }
    
    public void add(Server server) {
        servers.put(server.getName(), server);
    }
    
    public Server remove(String serverName) {
        return servers.remove(serverName);
    }
    
    public Server get(String serverName) {
        return servers.get(serverName);
    }
    
    public void loadCabinet() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(CABINET_FILE)));
        String currentLine;
        String[] currentTokens;
        
        while(sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Server currentServer = new Server();
            currentServer.setName(currentTokens[0]);
            currentServer.setIp(currentTokens[1]);
            currentServer.setMake(currentTokens[2]);
            currentServer.setRam(currentTokens[3]);
            currentServer.setNumProcessors(currentTokens[4]);
            
            servers.put(currentServer.getName(), currentServer);
        }
        sc.close();
    }
    
    public void writeCabinet() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(CABINET_FILE));
        
        Collection<Server> vals = servers.values();
        Iterator<Server> iter = vals.iterator();
        while(iter.hasNext()) {
            Server currentServer = iter.next();
            out.println(currentServer.getName() + DELIMITER + 
                    currentServer.getIp() + DELIMITER +
                    currentServer.getMake() + DELIMITER + 
                    currentServer.getRam() + DELIMITER + 
                    currentServer.getNumProcessors());
            out.flush();
        }
        out.close();  
    }
    
}
