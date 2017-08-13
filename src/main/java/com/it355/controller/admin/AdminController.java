package com.it355.controller.admin;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.it355.entities.Film;
import com.it355.service.FilmService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
}
