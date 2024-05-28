package br.org.serratec.biblioteca.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.biblioteca.record.GetASingleUser;

@Service
public class ConsumoApi {

	public GetASingleUser consultaUser(String id) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://fakestoreapi.com/users/{id}";

		Map<String, String> params = new HashMap<String, String>();

		params.put("id", id);

		GetASingleUser dto = restTemplate.getForObject(uri, GetASingleUser.class, params);

		return dto;
	}

}
