package com.test.controller;

import java.util.HashMap;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class TestController {
    
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Object> countword(@Valid @RequestBody String sentence) {
		
		sentence=sentence.replaceAll("sentence", "");
		
		HashMap<Character, Integer > Contador = new HashMap<>(27 * 2);
		String cadena = sentence;
		if (cadena != null && !cadena.trim().isEmpty()) {
		    for (char current : cadena.toCharArray()) {
		        if (Character.isLetter(current) && ((current >= 'a' && current <= 'z') || (current >= 'A' && current <= 'Z'))) {
		            
		            Contador.put(current, Contador.getOrDefault(current, 0) + 1);
		        }
		    }
		} else {
		    return null;
		}		
	   
        return new ResponseEntity<Object> (Contador.toString(), HttpStatus.CREATED);
    }

}
