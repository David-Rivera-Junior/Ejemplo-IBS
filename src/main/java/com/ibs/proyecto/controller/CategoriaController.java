package com.ibs.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibs.proyecto.model.Categoria;
import com.ibs.proyecto.repository.ICategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	ICategoriaRepository cr;
	
	@GetMapping("/index")
	public String listarCategoria(Model m) {
		m.addAttribute("items", cr.findAll());
		return "vistas/Categoria/ListarCategoria";
	}
	
	@GetMapping("/agregar")
	public String vistaAgregar() {
		return "vistas/Rol/AgregarRol";
	}
	
	@PostMapping("/agregar")
	public String agregarCategoria(@RequestParam String nombreCategoria) {
		
		Categoria c = new Categoria(nombreCategoria);
		cr.save(c);
		
		return "redirect: /categoria/index";
	}
	
}
