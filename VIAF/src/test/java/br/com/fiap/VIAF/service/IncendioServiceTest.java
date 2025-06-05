package br.com.fiap.VIAF.service;

import br.com.fiap.VIAF.DomainModel.Incendio;
import br.com.fiap.VIAF.Exception.BadRequestException;
import br.com.fiap.VIAF.Exception.ResourceNotFoundException;
import br.com.fiap.VIAF.Repository.IncendioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IncendioServiceTest {

    @Mock
    private IncendioRepository repository;

    @InjectMocks
    private IncendioService service;

    @Test
    void findById_ShouldReturnIncendio_WhenExists() {
        Long id = 1L;
        Incendio mockInc = new Incendio();
        mockInc.setId(id);
        mockInc.setNome("TesteFogo");
        mockInc.setDataDescoberta(LocalDate.of(2025, 5, 29));
        when(repository.findById(id)).thenReturn(Optional.of(mockInc));
        Incendio resultado = service.findById(id);
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("TesteFogo", resultado.getNome());
        verify(repository, times(1)).findById(id);
    }

    @Test
    void findById_ShouldThrowResourceNotFound_WhenNotExists() {
        Long id = 99L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        ResourceNotFoundException ex = assertThrows(
                ResourceNotFoundException.class,
                () -> service.findById(id)
        );
        assertTrue(ex.getMessage().contains("Incêndio com id 99 não foi encontrado"));
        verify(repository, times(1)).findById(id);
    }

    @Test
    void save_ShouldThrowBadRequest_WhenDataControleBeforeDescoberta() {
        Incendio inc = new Incendio();
        inc.setDataDescoberta(LocalDate.of(2025, 5, 29));
        inc.setDataControle(LocalDate.of(2025, 5, 28)); // anterior
        BadRequestException ex = assertThrows(
                BadRequestException.class,
                () -> service.save(inc)
        );
        assertEquals("Data de controle não pode ser anterior à data de descoberta", ex.getMessage());
        verify(repository, never()).save(any(Incendio.class));
    }

    @Test
    void save_ShouldPersist_WhenDataControleValid() {
        Incendio inc = new Incendio();
        inc.setDataDescoberta(LocalDate.of(2025, 5, 29));
        inc.setDataControle(LocalDate.of(2025, 5, 30)); // data de controle válida
        inc.setNome("ValidTest");
        when(repository.save(inc)).thenReturn(inc);
        Incendio salvo = service.save(inc);
        assertNotNull(salvo);
        assertEquals("ValidTest", salvo.getNome());
        verify(repository, times(1)).save(inc);
    }
}
