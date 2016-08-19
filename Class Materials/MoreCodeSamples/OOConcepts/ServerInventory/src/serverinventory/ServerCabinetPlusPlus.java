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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ServerCabinetPlusPlus {

    public static final String CABINET_FILE = "servers.txt";
    public static final String DELIMITER = "::";

    private List<Server> servers = new ArrayList<>();
    
    public void addServer(Server server) {
        servers.add(server);
    }
    
    public List<Server> getServersByManufacturer(String manufacturer) {
        return servers
                .stream()
                .filter(s -> s.getMake().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public List<Server> getServersOlderThan(int ageInYears) {
        return servers
                .stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.toList());
    }
    
    public Map<String, List<Server>> getServersOlderThanGroupByMake(int ageInYears) {
        return servers
                .stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.groupingBy(Server::getMake));        
    }

    public double getAverageServerAge() {
        return servers
                .stream()
                .mapToLong(Server::getServerAge)
                .average()
                .getAsDouble();
    }

    public void loadCabinet() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(CABINET_FILE)));
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Server currentServer = new Server();
            currentServer.setName(currentTokens[0]);
            currentServer.setIp(currentTokens[1]);
            currentServer.setMake(currentTokens[2]);
            currentServer.setRam(currentTokens[3]);
            currentServer.setNumProcessors(currentTokens[4]);
            currentServer.setPurchaseDate(LocalDate.parse(currentTokens[5], DateTimeFormatter.ISO_DATE));

            servers.add(currentServer);
        }
        sc.close();
    }

    public void writeCabinet() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(CABINET_FILE));

        Iterator<Server> iter = servers.iterator();
        while (iter.hasNext()) {
            Server currentServer = iter.next();
            out.println(currentServer.getName() + DELIMITER
                    + currentServer.getIp() + DELIMITER
                    + currentServer.getMake() + DELIMITER
                    + currentServer.getRam() + DELIMITER
                    + currentServer.getNumProcessors() + DELIMITER
                    + currentServer.getPurchaseDate().format(DateTimeFormatter.ISO_DATE));
            out.flush();
        }
        out.close();
    }

}
