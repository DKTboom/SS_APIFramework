package api.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class Listener implements Filter{
	
	private static final Logger logger = LogManager.getLogger(Listener.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		Response response = ctx.next(requestSpec, responseSpec);
		logger.info("\n Method =>"+requestSpec.getMethod()+
				"\n URI =>"+requestSpec.getURI()+
				"\n Request body =>"+requestSpec.getBody()+
				"\n Response body =>"+response.getBody().prettyPrint());
		
		return response;
	}
	
	

}
