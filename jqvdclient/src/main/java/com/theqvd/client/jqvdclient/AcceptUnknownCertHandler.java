package com.theqvd.client.jqvdclient;
/*
 * libqvdclient-java AcceptUnkownCertHandler.java
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.theqvd.client.jni.QvdUnknownCertificateHandler;

/*
 * 
 */
public class AcceptUnknownCertHandler implements QvdUnknownCertificateHandler {

	//@Override
	public boolean certificate_verification(String cert_description,
			String cert_pem_data) {
		String response;
		InputStreamReader inp = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inp);
		System.out.println("Unknown certificate\n"+cert_description+"\nDo you want to accept it?");
		try {
			response = br.readLine();
		} catch (IOException e) {
			System.err.print(e);
			return false;
		}
		if (response.contentEquals("y") || response.contentEquals("Y") || 
				response.contentEquals("Yes") || response.contentEquals("YES")) {
			return true;
		}
		return false;
	}

}
