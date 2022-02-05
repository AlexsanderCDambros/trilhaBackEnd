package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import trilha.back.finances.entities.Entry;
import trilha.back.finances.repositories.EntryRepository;
import trilha.back.finances.services.EntryService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TrilhaBackTestes {

    @InjectMocks
    private EntryService entryService;

    @Mock
    private EntryRepository entryRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private Entry entry1 = new Entry(1, "name", "description", "expense",
            20.00, "30/01/2022", true, 1);
    private Entry entry2 = new Entry(2, "name2", "description2", "revenue",
            22.00, "01/01/2022", true, 1);

    @Before
    public void setUp(){

        List<Entry> lista = new ArrayList<>();

        lista.add(entry1);
        lista.add(entry2);

        when(entryRepository.findAll()).thenReturn(lista);
    }

    @Test
    public void getLancamentosDependentesWorks () {
        List<Entry> lista = new ArrayList<>();
        lista.add(entry2);


        ResponseEntity listaTest;

        listaTest = entryService.getLancamentosDependentes(
                "01/01/2022",
                "22.00",
                true);

        Assert.assertEquals(ResponseEntity.status(HttpStatus.OK).body(lista), listaTest);
    }
}
