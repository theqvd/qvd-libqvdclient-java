package com.theqvd.client.jni;
/*
 * libqvdclient-java TestSslClientVmList.java
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

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSslClientVmList {
	QvdclientWrapper qvd;
	private String user, password, bearer, host, client_cert, client_key;
	private int port;
	@Before
	public void setUp() throws Exception {
		Properties testprops = new Properties();
		InputStream in = getClass().getResourceAsStream("/testlocal.properties");
		try {
			testprops.load(in);
		} catch (IOException e) {
			in = getClass().getResourceAsStream("/test.properties");
			testprops.load(in);
		}
		in.close();
		host = testprops.getProperty("test.sslhost");
		port = Integer.parseInt(testprops.getProperty("test.sslport"));
		user = testprops.getProperty("test.ssluser");
		password = testprops.getProperty("test.sslpassword");
		bearer = testprops.getProperty("test.sslbearer");
		client_cert = testprops.getProperty("test.sslcertfile");
		client_key = testprops.getProperty("test.sslcertkey");
		qvd = new QvdclientWrapper();
		qvd.qvd_init(host, port, user, password, bearer);
	}
	
	@After
	public void tearDown() throws Exception {
		qvd.qvd_free();
	}
	@Test
	public void test() throws QvdException, QvdPaymentException {
		assertNotNull("Library loaded", qvd);
		Qvdclient q = qvd.getQvdclient();
		assertNotNull("Qvdclient is not null", q);
		try {
			qvd.qvd_list_of_vm();
			fail("It should not be possible to get the vm list, a certifiate is required");
		} catch (QvdException e) {
			assertTrue("SSL without certs did not work. That is how it should be", true);
		} finally {
			qvd.qvd_free();
			
		}

		System.err.println("Cert files are: " + client_cert + " and " + client_key);
		qvd = new QvdclientWrapper();
		qvd.qvd_init(host, port, user, password, bearer);
		qvd.qvd_set_cert_files(client_cert, client_key);
		qvd.qvd_set_no_cert_check();
		System.err.println("qvd is "+qvd);
		System.err.println("Cert files are: " + client_cert + " and " + client_key);
		qvd.qvd_list_of_vm();
		System.err.println("after qvd_list_vm");
		q = qvd.getQvdclient();
		System.err.println("print qvdclient "+q);
		assertTrue("Ssl with certs worked", true);
	}

}

