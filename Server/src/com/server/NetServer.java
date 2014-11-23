package com.server;

import java.util.Vector;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetServer extends Listener {

	static sql_interaktion SQLSERVER;
	static Network_Server NetServer;
	static Algorithmen alg = new Algorithmen();
	static Logger SLogger = new Logger("C:\\Logger");
	static Vector<User> Userliste = new Vector<User>(100,20);
	
	public static void main(String[] args) throws Exception {
		SLogger.Info("Anwendung wird gestartet.");
		SQLSERVER = new sql_interaktion();
		if (SQLSERVER.start() == 1)
			System.exit(0);
		else
			SLogger.Info("SQL Server erfolgreich gestartet.");
			NetServer = new Network_Server();
			SLogger.Info("Netzwerkserver erfolgreich gestartet.");

	}

	public void connected(Connection c) 
	{
		
	}

	public void received(Connection c, Object p) {

		if (p instanceof Registrationspaket) {
			alg.Registration(SQLSERVER, c, p);
		}
		if (p instanceof Login) {
			Login log = alg.Connected(NetServer, SQLSERVER, c, p);
			if(log!=null)
			{
			User user = new User(log.id,c);
			Userliste.add(user);
			}
			else
			{
			c.close();
			}
		}
		
	}

	public void disconnected(Connection c) {
		System.out.println("A client disconnected!");
	}
}