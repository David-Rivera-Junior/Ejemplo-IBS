package com.ibs.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibs.proyecto.repository.IClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	IClienteRepository cr;
	
}
