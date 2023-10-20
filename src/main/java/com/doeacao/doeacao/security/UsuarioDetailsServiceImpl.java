package com.doeacao.doeacao.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.doeacao.doeacao.model.Usuario;
import com.doeacao.doeacao.repository.UsuarioRepository;


@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuario> user = usuarioRepository.findByUsuario(userName);
		
		if(user.isPresent())
			return new UsuarioDetailsImpl(user.get());
		else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
			
	}

	}



