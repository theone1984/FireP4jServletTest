/**
 * Copyright 2010 Thomas Endres
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package firep4jtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firep4j.FireP4j;
import firep4j.profile.*;

/**
 * This servlet is used for FireP4j test purposes.
 * 
 * @author Thomas Endres
 */
public class Test extends HttpServlet {
	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * FireP4j instance
	 */
	private FireP4j fireP4j = null;

	/**
	 * Dummy constructor
	 */
    public Test() {
    	// The parent constructor is called
        super();
        
        // The FireP4j language profile is set
        FireP4j.setProfile(new JavaProfile());
    }

	/**
	 * This method processes HTTP GET requests.
	 * 
	 * @param request HTTP request object
	 * @param request HTTP response object
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// FireP4j is tested
		testFireP4j(request, response);
		
		// Some HTML is output
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("	<head><title>FireP4j Test</title></head>");
		writer.println("	<body>");
		writer.println("		<h1>FireP4j Test</h1>");
		writer.println("	<body>");
		writer.println("</html>");
		writer.close();	
	}

	/**
	 * This method processes HTTP POST requests.
	 * 
	 * @param request HTTP request object
	 * @param request HTTP response object
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Nothing to do
	}
	
	/**
	 * This method tests FireP4j.
	 * 
	 * @param request HTTP request object
	 * @param request HTTP response object
	 */
	private void testFireP4j(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		// The FireP4j object is retrieved
		fireP4j = FireP4j.getInstance(request, response);
		// Logging to FirePHP is done
		fireP4j.log("Hello FirePHP!");
	}
}