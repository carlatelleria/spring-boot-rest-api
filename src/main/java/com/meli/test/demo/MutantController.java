package com.meli.test.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    @RequestMapping(value = "/mutant", method = RequestMethod.POST)
    public ResponseEntity<String> isMutant(@RequestBody String json) throws JSONException {
    	JSONObject dna = new JSONObject(json);
    	System.out.println(dna.get("dna"));
    	
    	Mutant mutant = new Mutant();
		boolean res = mutant.isMutant((JSONArray) dna.get("dna"));
		
		if (res)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
