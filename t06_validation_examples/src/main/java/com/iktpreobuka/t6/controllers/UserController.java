package com.iktpreobuka.t6.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.t6.entities.UserEntity;
import com.iktpreobuka.t6.repositories.UserRepository;
import com.iktpreobuka.t6.utils.UserCustomValidator;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserCustomValidator userCustomValidator;

	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		binder.addValidators(userCustomValidator);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = "";
			String errorMessage = "";
			if (error instanceof FieldError) {
				fieldName = ((FieldError) error).getField();
				errorMessage = error.getDefaultMessage();
			} else if (error instanceof ObjectError) {
				fieldName = ((ObjectError) error).getObjectName();
				errorMessage = error.getDefaultMessage();
			}
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@Valid @RequestBody UserEntity newUser) { // BindingResult result
//		if (result.hasErrors()) {
//			return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
//		}

		// store user in DB
		userRepository.save(newUser);
		// return 201 Created
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	private String createErrorMessage(BindingResult result) {
		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining("\n"));
	}

}
