package br.com.seatecnologia.desafio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.seatecnologia.desafio.models.Processo;

@SpringBootTest(properties = "spring.profiles.active=teste")
@AutoConfigureMockMvc
public class ProcessoTeste {

	@Autowired
	private MockMvc mockMvc;
	
	//Implementar a criação de registros a serem utilizados no teste
	@Before(value = "")
	public void setup() {
		
	}
	
	
	@Test
	public void processoTesteGet() throws Exception {
		this.mockMvc.perform(get("/processo")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void processoTestePost() throws Exception {
		
		Processo processo = new Processo("Processo de teste!");
		
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/processo").content(asJsonString(processo))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andDo(print());
	}

	@Test
	public void processoTestePut() throws Exception {

		Processo processo2 = new Processo("processo 2");

		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/processo/{id}", 32).content(asJsonString(processo2))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("processo 2"))
				.andDo(print());
	}
	

	@Test
	public void processoTesteDelete() throws Exception {
		this.mockMvc
			.perform( MockMvcRequestBuilders.delete("/processo/{id}", 43) )
	        .andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}