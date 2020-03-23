package com.switchfully.funiversity.domain.professor;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProfessorRepository {
    private final ConcurrentHashMap<String, Professor> professorsById;

    public ProfessorRepository() {
        professorsById = new ConcurrentHashMap<>();
        populateDefaultDataAtStartup();
    }

    public Professor save(Professor professor) {
        professorsById.put(professor.getId(), professor);
        return professor;
    }

    public Professor getById(String id) throws IllegalArgumentException {
        Professor foundProfessor = professorsById.get(id);
        if (foundProfessor == null) {
            throw new IllegalArgumentException(String.format("No professor found with id %s", id));
        }
        return foundProfessor;
    }

    public Collection<Professor> getAll() {
        return professorsById.values();
    }

    private void populateDefaultDataAtStartup() {
        Professor professor1 = new Professor("Madeleine", "Albright");
        Professor professor2 = new Professor("Alexander", "Graham");
        Professor professor3 = new Professor("Neil", "Armstrong");
        Professor professor4 = new Professor("Arthur","Danto");
        Professor professor5 = new Professor("George", "Church");
        save(professor1);
        save(professor2);
        save(professor3);
        save(professor4);
        save(professor5);
    }
}
