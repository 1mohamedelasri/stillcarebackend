package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.repositories.TabletteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TabletteController {

    private final TabletteRepository repository;

    TabletteController(TabletteRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/tablettes")
    List<TabletteEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/tablettes")
    TabletteEntity newTablette(@RequestBody TabletteEntity newTablette) {
        return repository.save(newTablette);
    }

    // Single item

    @GetMapping("/tablettes/{id}")
    TabletteEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tablette with" + id));
    }

    @PutMapping("/tablettes/{id}")
    TabletteEntity replaceTablette(@RequestBody TabletteEntity newTablette, @PathVariable Long id) {

        return repository.findById(id)
                .map(Tablette -> {
                    Tablette.setEtat(newTablette.getEtat());
                    return repository.save(Tablette);
                })
                .orElseGet(() -> {
                    newTablette.setNtablette(id);
                    return repository.save(newTablette);
                });
    }

    @DeleteMapping("/tablettes/{id}")
    void deleteTablette(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
