package com.server;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

public class Network_Server {
	public Server server;

	public Network_Server(int tcpPort, int udpPort) throws IOException {
		server = new Server();
		Kryo kryo = server.getKryo();
		kryo.register(PacketMessage.class);
		kryo.register(Userliste.class);
		kryo.register(Login.class);
		kryo.register(Registrationspaket.class);
		server.bind(tcpPort, udpPort);
		server.start();
		server.addListener(new NetServer());
		System.out.println("Server is open on Port " + tcpPort);
	}
	
	public Network_Server() throws IOException
	{
		server = new Server();
		Kryo kryo = server.getKryo();
		kryo.register(PacketMessage.class);
		kryo.register(Userliste.class);
		kryo.register(Login.class);
		kryo.register(Registrationspaket.class);
		server.bind(1034,1034);
		server.start();
		server.addListener(new NetServer());
		System.out.println("Server is open on Port 1034");
	}
}
