package com.hashedin.hu22;

import com.hashedin.hu22.entities.DemoEntity;
import com.hashedin.hu22.repositories.DemoRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Hu22Application.class}, loader = AnnotationConfigContextLoader.class)
//@Transactional
class Hu22ApplicationTests {

    @Autowired
    private DemoRepository demoRepository;

    @Before
    void initialize() {
    }

    @Test
    void insertDemoEntry() {
        DemoEntity demoEntity = new DemoEntity(1, "Linker");
        demoRepository.save(demoEntity);

        Optional<DemoEntity> byId = demoRepository.findById(1L);
        Assertions.assertTrue(byId.isPresent(), "Entity is not saved");

        DemoEntity demoEntityFromRepo = byId.get();
        Assertions.assertEquals(demoEntity.getName(), demoEntityFromRepo.getName(), "Entity's name is different");
    }
}
