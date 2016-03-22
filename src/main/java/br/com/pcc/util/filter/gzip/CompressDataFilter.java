package br.com.pcc.util.filter.gzip;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;

import br.com.pcc.util.enums.UtilContants;

/**
 * 
 */

//Este filtro poderia ser definido no container, porém, por questões de conhecimento, foi montado desta maneira.
public class CompressDataFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String acceptEncoding = httpRequest.getHeader(HttpHeaders.ACCEPT_ENCODING);
		
		boolean containsGzip = false;
		if(acceptEncoding != null) {
			containsGzip = (acceptEncoding.toLowerCase()).contains(UtilContants.GZIP);	
		}
		
		if (containsGzip) {
			httpResponse.addHeader(HttpHeaders.CONTENT_ENCODING, UtilContants.GZIP);
			GZipResponseWrapper gzipResponse = new GZipResponseWrapper(httpResponse);
			chain.doFilter(request, gzipResponse);
			gzipResponse.close();
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {}
}