package com.iktpreobuka.t4.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MultipartException.class)
	public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
		return "redirect:/uploadStatus";
	}
}
