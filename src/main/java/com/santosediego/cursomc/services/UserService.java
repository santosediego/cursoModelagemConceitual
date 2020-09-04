package com.santosediego.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.santosediego.cursomc.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			//Retorna o usuário logado no sistema;
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) {
			return null;
		}
		
	}
}
