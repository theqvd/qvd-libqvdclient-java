package com.theqvd.client.jni;
/*
 * libqvdclient-java Vm.java
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
 * Represents a Virtual machine in QVD
 * 
 * @author nito
 *
 */
public class Vm {
	private int id;
	private String name;
	private String state;
	private int blocked;
	
	public Vm(int id, String name, String state, int blocked) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.blocked = blocked;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getBlocked() {
		return blocked;
	}
	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}
	@Override
	public String toString() {
		return "vm:id="+id+";name="+name+";state="+state+";blocked="+blocked;
	}
}
