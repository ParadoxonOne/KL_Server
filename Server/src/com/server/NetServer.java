package com.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetServer extends Listener {

	static sql_interaktion SQLSERVER;
	static Network_Server NetServer;
	static Algorithmen alg = new Algorithmen();

	public static void main(String[] args) throws Exception {
		SQLSERVER = new sql_interaktion();

		if (SQLSERVER.start() == 1)
			System.exit(0);
		else
			NetServer = new Network_Server();

	}

	public void connected(Connection c) {
		Login Lr = new Login();
		Lr.x = 1;
		c.sendTCP(Lr);
	}

	public void received(Connection c, Object p) {

		if (p instanceof Registrationspaket) {
			alg.Registration(SQLSERVER, c, p);
		}
		
	}

	public void disconnected(Connection c) {
		System.out.println("A client disconnected!");
	}
}