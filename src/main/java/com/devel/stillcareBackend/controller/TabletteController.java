package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.services.TabletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TabletteController {

    @Autowired
    TabletteService tabletteService;

    @GetMapping("/tablettes")
    public List<TabletteEntity> greeting() {
        return tabletteService.listAll();
    }

}
