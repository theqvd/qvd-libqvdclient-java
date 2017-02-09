package com.theqvd.client.jni;
/*
 * libqvdclient-java TestLibraryLoad.java
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

import org.junit.Before;
import org.junit.Test;

public class TestLibraryLoad {
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
	}

	@Test
	public void testLibraryLoad() {
		QvdclientWrapper qvd = new QvdclientWrapper();
		assertNotNull("Library load test", qvd);
	}

	@Test
	public void testinitfree() throws QvdException {
		QvdclientWrapper qvd = new QvdclientWrapper();
		qvd.qvd_init(host, port, user, password, bearer);
		try {
			qvd.qvd_init(host, port, user, password, bearer);
			fail("two consecutive calls to qvd_init fail");
		} catch (QvdException e) {
			assertTrue("Two consecutive qvd_init should fail", true);

		}
		assertNotNull("qvd init worked", qvd.getQvdclient());
		qvd.qvd_free();
		try {
			qvd.qvd_free();
			fail("two consecutive calls to qvd_free fail");
		} catch (QvdException e) {
			assertTrue("Two consecutive qvd_free should fail", true);

		}
		// Run another load
		qvd.qvd_init(host, port, user, password, bearer);
		assertNotNull("qvd init worked", qvd.getQvdclient());
		qvd.qvd_set_useragent("QVD/3.1 test useragent");
		qvd.qvd_set_home("/tmp");
		qvd.qvd_set_display(":0");
		qvd.qvd_set_os("Linux");
		qvd.qvd_set_geometry(1024,768);
		qvd.qvd_set_link("adsl");
		qvd.qvd_payment_required();
		qvd.qvd_free();

	}
}
