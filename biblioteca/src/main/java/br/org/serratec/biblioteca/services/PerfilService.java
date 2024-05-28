package br.org.serratec.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.biblioteca.dtos.PerfilResumidoDto;
import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.repositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	EmailService emailService;

	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}

	public List<PerfilResumidoDto> findAllPerfilResumido() {
		List<Perfil> perfis = perfilRepository.findAll();
		List<PerfilResumidoDto> perfisDto = new ArrayList<>();

		for (Perfil perfil : perfis) {
			PerfilResumidoDto perfilDto = new PerfilResumidoDto();
			perfilDto.setNome(perfil.getNome());
			perfilDto.setDescricao(perfil.getDescricao());

			perfisDto.add(perfilDto);
		}

		return perfisDto;

		// return perfilRepository.findAll();
	}

	public Perfil findById(Integer id) {
		// return perfilRepository.findById(id).orElse(null);

		return perfilRepository.findById(id).get();
	}

	public PerfilResumidoDto findByIdResumido(Integer id) {
		Perfil perfil = perfilRepository.findById(id).orElse(null);
		PerfilResumidoDto perfilDto = null;
		// if (perfil != null)
		// try {
		perfilDto = modelMapper.map(perfil, PerfilResumidoDto.class);

		emailService.enviarEmail("bianco@email.com", "Cadastro de Perfil", perfilDto.toString());
		// } catch (IllegalArgumentException e) {
		// throw new IllegalArgumentException("Ocorreu uma exceção: " + e);
		// }

		return perfilDto;

	}

	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil update(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public void deletePerfilById(Integer id) {
		if (perfilRepository.existsById(id)) {
			perfilRepository.deleteById(id);
			ResponseEntity.noContent().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}

}
