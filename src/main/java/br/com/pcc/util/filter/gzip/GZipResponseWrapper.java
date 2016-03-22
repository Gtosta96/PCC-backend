package br.com.pcc.util.filter.gzip;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipResponseWrapper extends HttpServletResponseWrapper {

	  private ServletOutputStream stream = null;

	  public GZipResponseWrapper(HttpServletResponse response) {
	    super(response);
	  }

	  public ServletOutputStream createOutputStream() throws IOException {
		return this.stream;
	}
	  
	  public void close(){
		  this.stream = null;
	  }
}