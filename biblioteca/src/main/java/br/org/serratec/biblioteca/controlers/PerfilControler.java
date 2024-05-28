package br.org.serratec.biblioteca.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.biblioteca.dtos.PerfilResumidoDto;
import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.services.PerfilService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfis")
public class PerfilControler {

	@Autowired
	PerfilService perfilService;

	@GetMapping
	public ResponseEntity<List<Perfil>> findAll() {
		return new ResponseEntity<>(perfilService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/perfil-resumido")
	public ResponseEntity<List<PerfilResumidoDto>> findAllPerfilResumido() {
		return new ResponseEntity<>(perfilService.findAllPerfilResumido(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Perfil> findById(@PathVariable Integer id) {
		Perfil perfil = perfilService.findById(id);

		return new ResponseEntity<>(perfil, HttpStatus.OK);
	}

	@GetMapping("/perfil-resumido/{id}")
	public ResponseEntity<?> findByIdResuimido(@PathVariable Integer id) {
		PerfilResumidoDto perfilDto = null;
		// try {
		perfilDto = perfilService.findByIdResumido(id);
		// } catch (IllegalArgumentException e) {
		// throw new IllegalArgumentException("Ocorreu uma exceção: " + e);
		// }

		if (perfilDto == null) {
			return new ResponseEntity<>(perfilDto, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(perfilDto, HttpStatus.OK);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Perfil> save(@RequestBody @Valid Perfil perfil) {
		return new ResponseEntity<>(perfilService.save(perfil), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Perfil> update(@RequestBody Perfil perfil) {
		return new ResponseEntity<>(perfilService.update(perfil), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteProfile(@PathVariable Integer id) {
		perfilService.deletePerfilById(id);
	}
	
	/*
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
		
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				"Ocorreu um erro: '" + exception.getLocalizedMessage());
		pd.setType(URI.create("http://localhost:8080/errors/internal-server-error"));
		pd.setTitle("Erro Interno");
		pd.setProperty("hostname", "localhost");
		
		return ResponseEntity.status(500).body(pd);
	}*/
}
