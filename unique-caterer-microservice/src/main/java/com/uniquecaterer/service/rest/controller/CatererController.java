package com.uniquecaterer.service.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniquecaterer.service.rest.constant.Constants;
import com.uniquecaterer.service.rest.data.APIResponse;
import com.uniquecaterer.service.rest.data.CatererDto;
import com.uniquecaterer.service.rest.service.CatererService;

@RestController
@RequestMapping(value = Constants.API_COMMON_ENDPOINT_PREFIX)
public class CatererController {
	
	@Autowired
	CatererService catererService;
	
	@Autowired
	RequestBodyParamValidator requestBodyParamValidator;
	
	@PostMapping(value = Constants.API_SAVE_CATERER_ENDPOINT, produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<APIResponse> saveCatererEntity(@Valid @RequestBody CatererDto caterer) {
		
		ResponseEntity<APIResponse> response;
		CatererDto catererResponse = null;
		APIResponse apiResponse = new APIResponse();
		
		RequestBodyParamValidator.ValidationResult result = requestBodyParamValidator.validate(caterer) ;
		
		if (result.getStatusCode()==HttpStatus.ACCEPTED.value()) {
			catererResponse =catererService.saveCaterer(caterer);
		} else {
			apiResponse.setStatus(result);
			return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.BAD_REQUEST);
		}
				
		if (catererResponse!=null) {
			apiResponse.setCaterer(catererResponse);
			response = new ResponseEntity<APIResponse>(apiResponse,HttpStatus.CREATED);
		} else {
			apiResponse.setCaterer(catererResponse);
			response = new ResponseEntity<APIResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
		
	}
	
	@GetMapping(value = Constants.API_FIND_CATERER_ENDPOINT , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CatererDto> findCatererById(@PathVariable(name = "id") String id) {
		
		ResponseEntity<CatererDto> response;
		
		CatererDto catererResponse = catererService.findById(id);
		
		if (catererResponse!=null) {
			response = new ResponseEntity<CatererDto>(catererResponse,HttpStatus.OK);
		} else {
			response = new ResponseEntity<CatererDto>(catererResponse,HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@GetMapping(value = Constants.API_FINDBYCITYNAME_CATERER_ENDPOINT , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CatererDto>> findCatererByCityName(@RequestParam(name = "cityName") String cityName) {
		
		ResponseEntity<List<CatererDto>> response;
		
		List<CatererDto> catererResponse = catererService.findByCityName(cityName);
		
		if (catererResponse!=null) {
			response = new ResponseEntity<List<CatererDto>>(catererResponse,HttpStatus.OK);
		} else {
			response = new ResponseEntity<List<CatererDto>>(catererResponse,HttpStatus.NOT_FOUND);
		}
		
		return response;
	}


}
