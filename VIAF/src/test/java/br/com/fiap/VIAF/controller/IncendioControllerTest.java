package br.com.fiap.VIAF.controller;

import br.com.fiap.VIAF.DomainModel.Incendio;
import br.com.fiap.VIAF.Dto.IncendioDTO;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Mapper.IncendioMapper;
import br.com.fiap.VIAF.service.IncendioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import java.util.Arrays;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = IncendioController.class)
@ActiveProfiles("test")
class IncendioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IncendioService service;

    @MockBean
    private IncendioMapper mapper;

    private Incendio inc1;
    private IncendioDTO incDto1;

    @BeforeEach
    void setUp() {
        inc1 = new Incendio();
        inc1.setId(1L);
        inc1.setNome("TesteAPI");
        inc1.setDataDescoberta(LocalDate.of(2025, 5, 29));
        inc1.setDataControle(LocalDate.of(2025, 5, 30));
        inc1.setEstado("SP");

        incDto1 = new IncendioDTO();
        incDto1.setId(1L);
        incDto1.setNome("TesteAPI");
        incDto1.setDataDescoberta(LocalDate.of(2025, 5, 29));
        incDto1.setDataControle(LocalDate.of(2025, 5, 30));
        incDto1.setEstado("SP");
        incDto1.setCausaId(null);
        incDto1.setClasseId(null);
    }

    @Test
    @WithMockUser
    void getAll_ShouldReturnListOfIncendios() throws Exception {
        when(service.findAll()).thenReturn(Arrays.asList(inc1));
        when(mapper.toDTO(inc1)).thenReturn(incDto1);

        mockMvc.perform(get("/api/incendios")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(1)))
                .andExpect(jsonPath("$[0].nome", is("TesteAPI")));

        verify(service, times(1)).findAll();
        verify(mapper, times(1)).toDTO(inc1);
    }

    @Test
    @WithMockUser
    void getById_ShouldReturnIncendio_WhenExists() throws Exception {
        when(service.findById(1L)).thenReturn(inc1);
        when(mapper.toDTO(inc1)).thenReturn(incDto1);

        mockMvc.perform(get("/api/incendios/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("TesteAPI")))
                .andExpect(jsonPath("$.id", is(1)));

        verify(service, times(1)).findById(1L);
        verify(mapper, times(1)).toDTO(inc1);
    }

    @Test
    @WithMockUser
    void getById_ShouldReturn404_WhenNotExists() throws Exception {
        when(service.findById(99L))
                .thenThrow(new ResourceNotFoundException("Incêndio", 99L));

        mockMvc.perform(get("/api/incendios/99")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status", is(404)))
                .andExpect(jsonPath("$.message", containsString("Incêndio com id 99 não foi encontrado")));

        verify(service, times(1)).findById(99L);
        verify(mapper, never()).toDTO(any(Incendio.class));
    }

    @Test
    @WithMockUser
    void deveCriarIncendioQuandoDtoForValido() throws Exception {
        IncendioDTO dtoEntrada = new IncendioDTO();
        dtoEntrada.setNome("Novo Incendio Valido");
        dtoEntrada.setDataDescoberta(LocalDate.of(2025, 6, 1));
        dtoEntrada.setEstado("RJ");
        dtoEntrada.setCausaId(1L);
        dtoEntrada.setClasseId("A");

        Incendio entidadeParaSalvar = new Incendio();
        entidadeParaSalvar.setNome(dtoEntrada.getNome());
        entidadeParaSalvar.setDataDescoberta(dtoEntrada.getDataDescoberta());
        entidadeParaSalvar.setEstado(dtoEntrada.getEstado());


        Incendio entidadeSalva = new Incendio();
        entidadeSalva.setId(2L);
        entidadeSalva.setNome(dtoEntrada.getNome());
        entidadeSalva.setDataDescoberta(dtoEntrada.getDataDescoberta());
        entidadeSalva.setEstado(dtoEntrada.getEstado());


        IncendioDTO dtoResposta = new IncendioDTO();
        dtoResposta.setId(entidadeSalva.getId());
        dtoResposta.setNome(entidadeSalva.getNome());
        dtoResposta.setDataDescoberta(entidadeSalva.getDataDescoberta());
        dtoResposta.setEstado(entidadeSalva.getEstado());
        dtoResposta.setCausaId(dtoEntrada.getCausaId());
        dtoResposta.setClasseId(dtoEntrada.getClasseId());

        when(mapper.toEntity(any(IncendioDTO.class))).thenReturn(entidadeParaSalvar);
        when(service.save(any(Incendio.class))).thenReturn(entidadeSalva);
        when(mapper.toDTO(any(Incendio.class))).thenReturn(dtoResposta);

        mockMvc.perform(post("/api/incendios")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoEntrada)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.nome").value("Novo Incendio Valido"))
                .andExpect(jsonPath("$.causaId").value(1L))
                .andExpect(jsonPath("$.classeId").value("A"));

        verify(mapper, times(1)).toEntity(any(IncendioDTO.class));
        verify(service, times(1)).save(any(Incendio.class));
        verify(mapper, times(1)).toDTO(any(Incendio.class));
    }


    @Test
    @WithMockUser
    void create_ShouldReturn400_WhenDtoInvalid() throws Exception {
        IncendioDTO dtoInvalido = new IncendioDTO();
        mockMvc.perform(post("/api/incendios")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoInvalido)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.error", is("Bad Request")));


        verify(service, never()).save(any(Incendio.class));
        verify(mapper, never()).toEntity(any(IncendioDTO.class));
        verify(mapper, never()).toDTO(any(Incendio.class));
    }
}
