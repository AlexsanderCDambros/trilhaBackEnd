package trilha.back.finances.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.finances.dto.ChartDTO;
import trilha.back.finances.dto.EntryRequestDTO;
import trilha.back.finances.entities.Category;
import trilha.back.finances.entities.Entry;
import trilha.back.finances.repositories.CategoryRepository;
import trilha.back.finances.repositories.EntryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntryRepository entryRepository;

    private ModelMapper mapper;

    public EntryService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(entryRepository.findAll());
    }

    public ResponseEntity findById(long id) {
        Optional<Entry> result = entryRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found");
        } else  {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

    public ResponseEntity save(Entry entry) {
        return this.validateCategoryById(entry.getCategoryId()) ?
                ResponseEntity.status(HttpStatus.CREATED).body(entryRepository.save(entry)) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
    }

    public ResponseEntity update(long id, Entry entry) {
        try {
            Entry entryToEdit = entryRepository.findById(id)
                    .orElseThrow();
            entryToEdit.setName(entry.getName());
            entryToEdit.setDescription(entry.getDescription());
            entryToEdit.setCategoryId(entry.getCategoryId());
            entryToEdit.setPaid(entry.isPaid());
            entryToEdit.setDate(entry.getDate());
            entryToEdit.setAmount(entry.getAmount());
            entryToEdit.setType(entry.getType());
            return this.validateCategoryById(entry.getCategoryId()) ?
                    ResponseEntity.status(HttpStatus.OK).body(entryRepository.save(entryToEdit)) :
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found");
        }
    }

    public ResponseEntity delete(long id) {
        entryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("resource deleted successfully");
    }

    public boolean validateCategoryById(long idCategory) {
        return categoryRepository.existsById(idCategory);
    }

    public ResponseEntity generateChartDTO() {
//        List<ChartDTO> dtoList = new ArrayList<ChartDTO>();

        List<Category> categoryList = categoryRepository.findAll();

        List<ChartDTO> dtoList = categoryList.stream()
                .map(category -> {
                    ChartDTO chartDTO = new ChartDTO();
                    chartDTO.setName(category.getName());
                    chartDTO.setType("expense");
                    chartDTO.setTotal(0.00);
                    for (Entry entry: category.getEntries()) {
                        if (entry.getType().equals("expense")) {
                            chartDTO.setTotal(chartDTO.getTotal() + entry.getAmount());
                        }
                    }
                    return chartDTO;
                })
                .filter(dto -> dto.getTotal() > 0.00)
                .collect(Collectors.toList());

//        for (Category category: categoryList) {
//            ChartDTO chartDTO = new ChartDTO();
//            chartDTO.setName(category.getName());
//            chartDTO.setType("expense");
//            chartDTO.setTotal(0.00);
//            for (Entry entry: category.getEntries()) {
//                if (entry.getType().equals("expense")) {
//                    chartDTO.setTotal(chartDTO.getTotal() + entry.getAmount());
//                }
//            }
//            if (chartDTO.getTotal() > 0) {
//                dtoList.add(chartDTO);
//            }
//        }

        for (Category category: categoryList) {
            ChartDTO chartDTO = new ChartDTO();
            chartDTO.setName(category.getName());
            chartDTO.setType("revenue");
            chartDTO.setTotal(0.00);
            for (Entry entry: category.getEntries()) {
                if (entry.getType().equals("revenue")) {
                    chartDTO.setTotal(chartDTO.getTotal() + entry.getAmount());
                }
            }
            if (chartDTO.getTotal() > 0) {
                dtoList.add(chartDTO);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    public Entry dtoToEntry(EntryRequestDTO entryRequestDTO) {
        Entry entry = mapper.map(entryRequestDTO, Entry.class);
        return entry;
    }
}
