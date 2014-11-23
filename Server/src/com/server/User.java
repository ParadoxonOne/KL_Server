package com.server;

import com.esotericsoftware.kryonet.Connection;

public class User {
	public int id;
	public Connection c;
	
	public User(int id, Connection c) {
		this.id = id;
		this.c = c;
	}
}
