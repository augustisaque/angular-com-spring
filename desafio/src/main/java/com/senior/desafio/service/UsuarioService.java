package com.senior.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.desafio.model.Usuario;
import com.senior.desafio.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario findByIdUsuario(Long id) {
		return usuarioRepository.findByIdUsuario(id);
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

}
