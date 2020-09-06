package br.com.seatecnologia.desafio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DesafioTestes {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void atestadoTest() throws Exception {
		this.mockMvc.perform(get("/atestado")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void atividadeTest() throws Exception {
		this.mockMvc.perform(get("/atividade")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void funcionarioTest() throws Exception {
		this.mockMvc.perform(get("/epi")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void epiTest() throws Exception {
		this.mockMvc.perform(get("/funcionario")).andDo(print()).andExpect(status().isOk());
	}

	@Test
    public void processoTest() throws Exception {
        this.mockMvc.perform(get("/processo")).andDo(print()).andExpect(status().isOk());
    }
	
	@Test
	public void tarefaTest() throws Exception {
		this.mockMvc.perform(get("/tarefa")).andDo(print()).andExpect(status().isOk());
	}
}