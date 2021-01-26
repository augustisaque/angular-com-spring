package com.senior.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senior.desafio.model.Usuario;
import com.senior.desafio.service.UsuarioService;

@RestController
@RequestMapping("/desafio")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario){
		return ResponseEntity.ok().body(usuarioService.save(usuario));
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @Valid @RequestBody Usuario usuarioDetalhes){
		Usuario usuario = usuarioService.findByIdUsuario(id);
		if(usuario == null)
			return ResponseEntity.notFound().build();
		BeanUtils.copyProperties(usuarioDetalhes, usuario, "idUsuario");
		Usuario attUsuario = usuarioService.save(usuario);
		return ResponseEntity.ok().body(attUsuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable Long id) {
		
		Usuario usuario = usuarioService.findByIdUsuario(id);
		
		if(usuarioService == null)
			return ResponseEntity.notFound().build();
		
		usuarioService.deleteById(usuario.getIdUsuario());
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok().body(usuarioService.findAll());
	}

}
