package com.uma.example.springuma.unit.service;

import com.uma.example.springuma.model.Cuenta;
import com.uma.example.springuma.model.Persona;
import com.uma.example.springuma.model.RepositoryCuenta;
import com.uma.example.springuma.model.RepositoryPersona;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas de integración del repositorio de Cuenta.
 *
 * Usa @DataJpaTest: carga únicamente la capa JPA con H2 en memoria,
 * sin arrancar el servidor web.
 */
@DataJpaTest
class CuentaRepositoryIT {

    @Autowired
    private RepositoryCuenta cuentaRepository;

    @Autowired
    private RepositoryPersona personaRepository;

    // ------------------------------------------------------------------ //
    //  Persistencia básica
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("Guardar una cuenta y recuperarla por ID")
    void guardarCuenta_seRecuperaPorId() {
        Cuenta cuenta = new Cuenta();
        cuenta.setCcc(111111);
        cuenta.setBalance(200.0);

        cuentaRepository.save(cuenta);

        Optional<Cuenta> resultado = cuentaRepository.findById(cuenta.getId());
        assertTrue(resultado.isPresent());
        assertEquals(111111, resultado.get().getCcc());
    }

    @Test
    @DisplayName("Buscar cuenta por CCC mediante query method")
    void buscarPorCcc_devuelveCuentaCorrecta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setCcc(999999);
        cuenta.setBalance(100.0);
        cuentaRepository.save(cuenta);

        Cuenta encontrada = cuentaRepository.findByCcc(999999);

        assertNotNull(encontrada);
        assertEquals(100.0, encontrada.getBalance());
    }

    @Test
    @DisplayName("Listar todas las cuentas devuelve el número correcto")
    void guardarVariasCuentas_findAllDevuelveTodas() {
        Cuenta c1 = new Cuenta(); c1.setCcc(11); c1.setBalance(10);
        Cuenta c2 = new Cuenta(); c2.setCcc(22); c2.setBalance(20);
        cuentaRepository.save(c1);
        cuentaRepository.save(c2);

        List<Cuenta> cuentas = cuentaRepository.findAll();
        assertEquals(2, cuentas.size());
    }

    @Test
    @DisplayName("Eliminar una cuenta: ya no se encuentra en el repositorio")
    void eliminarCuenta_noExisteEnRepositorio() {
        Cuenta cuenta = new Cuenta();
        cuenta.setCcc(33333);
        cuentaRepository.save(cuenta);

        cuentaRepository.delete(cuenta);

        Optional<Cuenta> resultado = cuentaRepository.findById(cuenta.getId());
        assertFalse(resultado.isPresent());
    }

    // ------------------------------------------------------------------ //
    //  Relación Cuenta → Persona
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("Asignar titular a una cuenta y persistir la relación")
    void asignarTitular_relacionPersistida() {
        Persona persona = new Persona();
        persona.setNombre("Ana");
        persona.setDni("11223344B");
        persona.setEdad(25);
        personaRepository.save(persona);

        Cuenta cuenta = new Cuenta();
        cuenta.setCcc(55555);
        cuenta.setBalance(300.0);
        cuenta.setTitular(persona);
        cuentaRepository.save(cuenta);

        Cuenta recuperada = cuentaRepository.findById(cuenta.getId()).orElseThrow();
        assertNotNull(recuperada.getTitular());
        assertEquals("Ana", recuperada.getTitular().getNombre());
    }
}
