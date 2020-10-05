package br.com.solo.teste.service;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.solo.avaliacao.Application;
import br.com.solo.avaliacao.model.Acceleration;
import br.com.solo.avaliacao.model.Challenge;
import br.com.solo.avaliacao.model.User;
import br.com.solo.avaliacao.repository.UserRepository;
import br.com.solo.avaliacao.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	UserService userService;

	@Mock
	UserRepository mockUserRepository;

	@Mock
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		objectMapper.registerModule(new ProblemModule());
		objectMapper.registerModule(new ConstraintViolationProblemModule());
	}

	@Test
	public void deve_burcar_usuario_por_id() throws Exception {
		
		// cenario
		final Long userId = 1L;
		final User user = new User(1L, "patinhas 001", "patinhas@tms.com.br", "patinhas", new Date());
		
		// acao
		given(userService.findById(userId)).willReturn(Optional.of(user));
		this.mockMvc.perform(get("/api/users/{id}", userId)).andExpect(status().isOk()).andExpect(jsonPath("$.email", is(user.getEmail())));
	}
	
    @Test
	public void criar_um_usuario_na_base_de_dados() throws Exception {

		// cenario
		final User user = new User(null, "patinhas 001", "patinhas@tms.com.br", "patinhas", new Date());

		// acao
		given(userService.save(user)).willReturn(user);
		this.mockMvc.perform(post("/api/users")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(user)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(jsonPath("$.fullName", is(user.getFullName())))
				.andExpect(jsonPath("$.email", is(user.getEmail())))
				.andExpect(jsonPath("$.nickName", is(user.getNickName())));

	}
    
    @Test
    public void alterar_um_usuario_na_base_de_dados() throws Exception {
        Long userId = 1L;
        User user = new User(userId, "Tio Patilhas", "patinhas@tms.com.br", "patinhas", new Date());
        given(userService.findById(userId)).willReturn(Optional.of(user));
        given(userService.updateUser(any(User.class))).willAnswer((invocation) -> invocation.getArgument(0));

        this.mockMvc.perform(put("/api/users/{id}", user.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is(user.getFullName())))
				.andExpect(jsonPath("$.email", is(user.getEmail())))
				.andExpect(jsonPath("$.nickName", is(user.getNickName())));

    }
    
    @Test
    public void busca_candidatos_pelo_nome_da_aceleracao() throws Exception {
    	
    	final Challenge challenge = new Challenge(1L, "RESTful Web Service", "5 dias", new Date());
    	
    	// cenario
    	final Acceleration acceleration = new Acceleration(1L, "React native", "2 meses", challenge, new Date());
    	
    	// acao

    	
    }

}
