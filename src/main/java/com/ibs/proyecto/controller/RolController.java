package com.ibs.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibs.proyecto.model.Role;
import com.ibs.proyecto.repository.IRolRepository;

@Controller
@RequestMapping("/rol")
public class RolController {
	
	@Autowired
	IRolRepository rr;
	
	@GetMapping("/index")
	public String listarRol(Model m /*ModelMap mp*/) {
		m.addAttribute("items", rr.findAll());
		//mp.put("items", rr.findAll());

		return "vistas/Rol/ListarRol";
	}
	
	@GetMapping("/agregar")
	public String vistaAgregar() {
		return "vistas/Rol/AgregarRol";
	}
	
	@PostMapping("/agregar")
	public String agregarRol(@RequestParam(value = "nombreRol", required = false) String nombreRol) {
		//System.out.println(nombreRol);
		Role r = new Role(nombreRol);
		
		rr.save(r);
		return "redirect:/rol/index";
	}
	
	@PostMapping("/vistaEliminar")
	public String eliminarRol(@RequestParam(value = "idRol", required = false) Long idRol, 
			@RequestParam(value = "nombreRol", required = false) String nombreRol, Model m) {
			m.addAttribute("idRol", idRol);
			m.addAttribute("nombreRol", nombreRol);
		return "vistas/Rol/EliminarRol";
	}
	
	@PostMapping("/eliminar")
	public String eliminarRol(@RequestParam(value = "idRol", required = false)Long idRol) {
		
		rr.deleteById(idRol);
		
		return "redirect:/rol/index";
	}
	
}
