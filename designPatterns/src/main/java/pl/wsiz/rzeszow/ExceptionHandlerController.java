package pl.wsiz.rzeszow;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public void applicationExceptionHandler(Exception e, HttpServletResponse response) throws IOException {
		
		JsonErrorResponse reponse = new JsonErrorResponse(e.getMessage());
		response.getWriter().write(new ObjectMapper().writeValueAsString(reponse));
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		response.setStatus(httpStatus.value());
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.flushBuffer();
	}
	

}
