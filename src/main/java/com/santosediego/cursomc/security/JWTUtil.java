package com.santosediego.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//Deve ser declarada como component para que seja injetada nas outras classes como um componente;
@Component
public class JWTUtil {
//Essa classe será utilizada para gerar o token;

	// Informado no application.properties;
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	// Para gerar o token, segue função;
	public String generateToken(String username) {
		// Da dependência jsonwebtoken;
		return Jwts.builder() //O cara que gera o token pra gente, segue os objetos dele;
				.setSubject(username)// O usuário;
				//vai receber o tempo de expiração, que é a data atual mais o tempo de expiração já definido;
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())// Modo que assinará (algoritmo) o token, o HS512 segudno o professor é "superpoderoso"
				// a chave deve ser enviada por bytes;
				.compact();
	}
}

/*
 * Implementando autenticação e geração do token JWT, checklist: Criar uma
 * classe JWTUtil (@Component) com a operação String generateToken(String
 * username).
 */