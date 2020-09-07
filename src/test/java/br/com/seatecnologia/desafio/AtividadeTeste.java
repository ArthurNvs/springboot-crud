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

import br.com.seatecnologia.desafio.models.Atividade;

@SpringBootTest(properties = "spring.profiles.active=teste")
@AutoConfigureMockMvc
public class AtividadeTeste {

	@Autowired
	private MockMvc mockMvc;

	// Implementar a criação de registros a serem utilizados no teste
	@Before(value = "")
	public void setup() {

	}

	@Test
	public void atividadeTesteGet() throws Exception {
		this.mockMvc.perform(get("/atividade")).andDo(print()).andExpect(status().isOk());

	}

	// Necessário refatorar pois a aplicação quebra na ausência de funcionário
	@Test
	public void atividadeTestePost() throws Exception {

		Atividade atividade = new Atividade("atividade teste");

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/atividade")
				.content(asJsonString(atividade))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andDo(print());

	}

	@Test
	public void processoTestePut() throws Exception {

		Atividade atividade2 = new Atividade("atividade2");

		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/atividade/{id}", 15).content(asJsonString(atividade2))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("atividade2"))
				.andDo(print());
	}

	@Test
	public void processoTesteDelete() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/atividade/{id}", 10)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
