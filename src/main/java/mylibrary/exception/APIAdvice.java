package mylibrary.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class APIAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(APIAdvice.class);

//	@ResponseBody
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler
//	public Response exceptionHandler(BadRequestException e) {
//		return new Response(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), e.getMessage());
//	}

}
