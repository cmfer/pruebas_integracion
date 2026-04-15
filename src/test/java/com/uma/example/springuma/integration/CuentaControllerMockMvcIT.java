package com.uma.example.springuma.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uma.example.springuma.integration.base.AbstractIntegration;
import com.uma.example.springuma.model.Cuenta;
import com.uma.example.springuma.model.Persona;

/**
 * Pruebas de integración para CuentaController usando MockMvc.
 *
 * Cubre los flujos principales del CRUD de cuentas y la relación Cuenta → Persona.
 */
class CuentaControllerMockMvcIT extends AbstractIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Persona persona;
    private Cuenta cuenta;

    @BeforeEach
    void setUp() throws Exception {
        // Crear una persona titular para las cuentas
        persona = new Persona();
        persona.setNombre("Titular");
        persona.setDni("99887766A");
        persona.setEdad(30);

        mockMvc.perform(post("/persona")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isCreated());

        // Cuenta base para cada test
        cuenta = new Cuenta();
        cuenta.setId(1);
        cuenta.setCcc(100001);
        cuenta.setBalance(500.0);
    }

    // ------------------------------------------------------------------ //
    //  GET /cuentas
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("La lista de cuentas está vacía al inicio")
    void getCuentas_inicialmenteVacia() throws Exception {
    // TODO: implementa aquí el test
}

    // ------------------------------------------------------------------ //
    //  POST /cuenta  →  GET /cuenta/{id}
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("Crear una cuenta y recuperarla por ID")
    void crearCuenta_seRecuperaPorId() throws Exception {
        // TODO: implementa aquí el test
    }

    @Test
    @DisplayName("Crear dos cuentas distintas: el listado contiene ambas")
    void crearDosCuentas_listaContieneDos() throws Exception {
        // TODO: implementa aquí el test
    }

    // ------------------------------------------------------------------ //
    //  DELETE /cuenta
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("Crear y eliminar una cuenta: el listado queda vacío")
    void crearYEliminarCuenta_listaQuedaVacia() throws Exception {
        // TODO: implementa aquí el test
    }
}
