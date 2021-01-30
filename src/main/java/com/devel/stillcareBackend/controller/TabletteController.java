package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.respository.TabletteRepository;
import com.devel.stillcareBackend.services.TabletteService;
import exception.TabletteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
    TabletteEntity newEmployee(@RequestBody TabletteEntity newTablette) {
        return repository.save(newTablette);
    }

    // Single item

    @GetMapping("/tablettes/{id}")
    TabletteEntity one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new TabletteNotFoundException(id));
    }

    @PutMapping("/tablettes/{id}")
    TabletteEntity replaceEmployee(@RequestBody TabletteEntity newTablette, @PathVariable Integer id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setEtat(newTablette.getEtat());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newTablette.setNtablette(id);
                    return repository.save(newTablette);
                });
    }

    @DeleteMapping("/tablettes/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(Integer.parseInt(id));
    }

}
