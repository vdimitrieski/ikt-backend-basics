package com.iktpreobuka.uploadexample.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iktpreobuka.uploadexample.services.FileHandler;

@Controller
@RequestMapping(path = "/")
public class UploadController {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
    private FileHandler fileHandler; 

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "upload";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

    	String result = null;
        try {
			 result = fileHandler.singleFileUpload(file, redirectAttributes);
			 logger.debug("This is a debug message");
		     logger.info("This is an info message");
		     logger.warn("This is a warn message");
		     logger.error("This is an error message");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}
