package com.swcguild.simplebank.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountHolder implements Serializable {
	private int id;
	private String name;
	
	public AccountHolder() {
            
        }
        
        public AccountHolder(String name) {
            this.name = name;
        }
        
        public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	
        public int getId() {
		return id;
	}
}
