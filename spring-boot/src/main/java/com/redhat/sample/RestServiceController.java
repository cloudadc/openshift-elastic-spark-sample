package com.redhat.sample;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.sample.model.Success;



/**
 * 
 * @author kylin
 *
 */
@RestController
public class RestServiceController {
	
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/rest/ping")
    public Success greeting() {
        return new Success(counter.getAndIncrement(), "Success!");
    }
	
	
	


	
	
}
