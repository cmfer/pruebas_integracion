package com.uma.example.springuma.integration;

import com.uma.example.springuma.model.Persona;
import com.uma.example.springuma.model.RepositoryPersona;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
// Esta anotación especifica cómo deben crearse las instancias de prueba. El valor Lifecycle.PER_CLASS garantiza que se cree una instancia de prueba por cada clase de prueba.
@TestInstance(Lifecycle.PER_CLASS)
// Esta anotación limpia el contexto de Spring después de cada método de prueba. Esto garantiza la independencia entre las pruebas.
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PersonaRepositoryIT {

    @Autowired
    private RepositoryPersona personaRepository;

    @Test
    @DisplayName("Check persona is persited in the BBDD when created")
    void givenPersonaEntity_whenSaveUser_thenUserIsPersisted() {
        // arrange
        Persona persona = new Persona();
        persona.setNombre("Alumno"); 
        persona.setDni("122");
        persona.setEdad(16);
        persona.setId(1);

        // act
        Persona saved = personaRepository.save(persona);

        // arrange
        Optional<Persona> retrievedPersona = personaRepository.findById(saved.getId());
        assertTrue(retrievedPersona.isPresent());
        assertEquals("Alumno", retrievedPersona.get().getNombre());
    }
}