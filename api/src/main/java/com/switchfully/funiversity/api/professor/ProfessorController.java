package com.switchfully.funiversity.api.professor;

import com.switchfully.funiversity.service.professor.ProfessorDto;
import com.switchfully.funiversity.service.professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping(produces = "application/json")
    public Collection<ProfessorDto> findAll() {
        return professorService.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ProfessorDto findById(@PathVariable("id") String id) {
        return professorService.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ProfessorDto save(@RequestBody ProfessorDto professorDto) {
        return professorService.save(professorDto);
    }
}
