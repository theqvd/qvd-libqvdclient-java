package com.theqvd.client.jni;
/*
 * libqvdclient-java Qvdclient.java
 *
 * Copyright (C) 2016  theqvd.com trade mark of Qindel Formacion y Servicios SL
 *
 * libqvdclient is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * 
 * Represents a QVD client object
 * 
 * @author nito
 *
 */
public class Qvdclient {
	private String username;
	private String password;
	private String host;
	private int port;
	private Vm vmlist[];
	
	public Qvdclient(String username, String password, String host, int port) {
		this.username = username;
		this.password = password;
		this.host = host;
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Vm[] getVmlist() {
		return vmlist;
	}
	public void setVmlist(Vm vmlist[]) {
		this.vmlist = vmlist;
	}
	@Override
	public String toString() {
		String s = "host:"+host+";port="+port+";user="+username+";pass=****;vmlist=";
		int i = 0;
		for(i=0; i < vmlist.length; ++i) {
			s+="["+i+"]="+vmlist[i]+";";
		}
		return s;
	}
}

