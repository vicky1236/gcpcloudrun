package com.hashedin.hu22.controllers;

import com.hashedin.hu22.entities.DemoEntity;
import com.hashedin.hu22.repositories.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {

    @Autowired
    DemoRepository demoRepository;

    @GetMapping("test")
    public String getTest() {
        return "Hello HashedIn";
    }

    @GetMapping("demos")
    public List<DemoEntity> getAllEmployees() {
        return demoRepository.findAll();
    }

    @GetMapping("demo/{id}")
    public DemoEntity getEmployee(@PathVariable long id) throws Exception {
        Optional<DemoEntity> employeeOptional = demoRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new Exception("Demo id doesn't exist");
        }
        return employeeOptional.get();
    }

    @PostMapping("demo")
    public DemoEntity getEmployee(@RequestBody DemoEntity demoEntity) {
        return demoRepository.save(demoEntity);
    }
}
