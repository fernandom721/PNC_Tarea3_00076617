package com.uca.capas.modelo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class MainController {

	@RequestMapping("/ingresar")
	public String index(){
		return "ingresar";
	}
	
	@RequestMapping("/resultado")
	public ModelAndView resultado(HttpServletRequest request) {
		String nombre 			= request.getParameter("nombre");
		String apellido 		= request.getParameter("apellido");
		String nacimiento 		= request.getParameter("nacimiento").toString();
		String fechanacimiento 	= request.getParameter("brithday");
		String instituto 		= request.getParameter("instituto");
		String movil 			= request.getParameter("movil").toString();
		String fijo 			= request.getParameter("fijo").toString();
		int annio =Integer.parseInt(fechanacimiento.substring(0,4));

		ModelAndView mav = new ModelAndView();
		List<String> error = new ArrayList<>();

		if(nombre.length()<1 || nombre.length()>25){
			error.add("Tu nombre debe ser entre 1 y 25 caracteres");
		}
		if(apellido.length()<1 || apellido.length()>25){
			error.add("Tu apellido debe ser entre 1 y 25 caracteres");
		}
		if(nacimiento.length()<1 || nacimiento.length()>25){
			error.add("Tu lugar de naciemiento debe ser entre 1 y 25 caracteres");
		}
		if(annio<2003){
			error.add("Tu año de nacimiento debe ser superior al 2003");
		}
		if(instituto.length()<1 || instituto.length()>100){
			error.add("Tu centro educativo debe ser superior al 2003");
		}
		if(movil.length()!= 8){
			error.add("Tu numero de celular tiene que ser de 8 numeros");
		}
		if(fijo.length()!= 8){
			error.add("Tu numero de telefono tiene que ser de 8 numeros");
		}
		for(String errores : error){
			System.out.println(errores);
		}
		if(error.size()==0){
			mav.setViewName("loginSucess");
		}else {
			mav.addObject("errores", error);
			mav.setViewName("LoginFailed");
		}

		return mav;
	}

}
