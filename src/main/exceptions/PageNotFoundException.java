package main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Armando on 11/19/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Invalid URL")
public class PageNotFoundException extends RuntimeException {

    public PageNotFoundException(String e, String g){

    }
}
