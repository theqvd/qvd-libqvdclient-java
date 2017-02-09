package com.theqvd.client.jni;
/*
 * libqvdclient-java TestVmList.java
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

public class TestVmList {
	QvdclientWrapper qvd;
	private String user, password, host, bearer;
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
		host = testprops.getProperty("test.host");
		port = Integer.parseInt(testprops.getProperty("test.port"));
		user = testprops.getProperty("test.user");
		password = testprops.getProperty("test.password");
//		bearer = testprops.getProperty("test.bearer");
		qvd = new QvdclientWrapper();
		qvd.qvd_init(host, port, user, password, bearer);
		qvd.qvd_set_no_cert_check();
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
		qvd.qvd_list_of_vm();
		System.err.println("q:"+q);
//		assertTrue("The list of vms is 0", q.getVmlist().length == 0);
	}

}

