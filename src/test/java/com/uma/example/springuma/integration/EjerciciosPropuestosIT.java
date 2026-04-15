package com.uma.example.springuma.integration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uma.example.springuma.integration.base.AbstractIntegration;

/**
 * ==========================================================================
 *  EJERCICIOS PROPUESTOS — Pruebas de integración
 * ==========================================================================
 *
 * Este fichero contiene pruebas incompletas que los alumnos deben implementar.
 *
 * Cada método indica con comentarios TODO qué debe comprobarse.
 * Cuando termines un ejercicio, elimina la anotación @Disabled del método.
 *
 * Para ejecutar SOLO este fichero:
 *   ./mvnw verify -Dit.test=EjerciciosPropuestosIT
 *
 * ==========================================================================
 */
class EjerciciosPropuestosIT extends AbstractIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // ================================================================== //
    //  BLOQUE 1 — Persona: casos básicos
    // ================================================================== //

    /**
     * EJERCICIO 1
     *
     * Dado que no existe ninguna persona, al hacer GET /persona/{id}
     * con un ID inexistente la respuesta debe ser 5xx (error de servidor).
     *
     */
    @Test
    @Disabled("Implementa este ejercicio")
    @DisplayName("EJ1: Obtener persona inexistente devuelve 5xx")
    void ejercicio1_personaInexistente_devuelve5xx() throws Exception {
        // TODO: implementa aquí el test
    }

    /**
     * EJERCICIO 2
     *
     * Crear dos personas con el mismo DNI debe devolver un error 5xx
     * en la segunda creación, ya que DNI tiene restricción unique.
     *
     * Pistas:
     *  - Crea la primera persona con POST /persona → espera 201
     *  - Crea la segunda con el mismo DNI  → espera 5xx
     */
    @Test
    @Disabled("Implementa este ejercicio")
    @DisplayName("EJ2: DNI duplicado devuelve error")
    void ejercicio2_dniDuplicado_devuelveError() throws Exception {
        // TODO: implementa aquí el test
    }

    /**
     * EJERCICIO 3
     *
     * Crear una persona, actualizarla y comprobar que el campo 'nombre'
     * ha cambiado correctamente al hacer GET /personas.
     *
     * Pistas:
     *  - Crea la persona con nombre "Antiguo"
     *  - Actualiza con PUT /persona con nombre "Nuevo"
     *  - Verifica jsonPath("$[0].nombre").value("Nuevo")
     */
    @Test
    @Disabled("Implementa este ejercicio")
    @DisplayName("EJ3: Actualizar nombre de persona")
    void ejercicio3_actualizarNombrePersona() throws Exception {
        // TODO: implementa aquí el test
    }

    // ================================================================== //
    //  BLOQUE 2 — Cuenta: CRUD
    // ================================================================== //

    /**
     * EJERCICIO 4
     *
     * Crear una cuenta con un CCC y luego buscarla usando GET /cuenta/{id}.
     * Verificar que el balance devuelto es el mismo que se envió.
     *
     * Pistas:
     *  - Crea la cuenta con POST /cuenta
     *  - Obtén el ID consultando GET /cuentas y leyendo el JSON
     *  - Llama a GET /cuenta/{id} y verifica el campo 'balance'
     */
    @Test
    @Disabled("Implementa este ejercicio")
    @DisplayName("EJ4: Crear cuenta y verificar balance por ID")
    void ejercicio4_crearCuenta_balanceCorrecto() throws Exception {
        // TODO: implementa aquí el test
    }

    /**
     * EJERCICIO 5
     *
     * Intentar crear dos cuentas con el mismo CCC (campo unique).
     * La segunda creación debe devolver un error 5xx.
     */
    @Test
    @Disabled("Implementa este ejercicio")
    @DisplayName("EJ5: CCC duplicado devuelve error")
    void ejercicio5_cccDuplicado_devuelveError() throws Exception {
        // TODO: implementa aquí el test
    }

    /**
     * EJERCICIO 6
     *
     * Crear una cuenta, eliminarla, y verificar que el listado
     * GET /cuentas devuelve un array vacío.
     */
    @Test
    @Disabled("Implementa este ejercicio")
    @DisplayName("EJ6: Eliminar cuenta y verificar lista vacía")
    void ejercicio6_eliminarCuenta_listaVacia() throws Exception {
        // TODO: implementa aquí el test
    }

    // ================================================================== //
    //  BLOQUE 3 — Relación Persona-Cuenta
    // ================================================================== //

    /**
     * EJERCICIO 7
     *
     * Crear una Persona, crear una Cuenta asignando esa persona como titular.
     * A continuación, cambia el titular de la cuenta a otra persona, 
     * y verifica que el nombre del titular en GET /cuenta/{id} es el correcto.
     *
     * Pistas:
     *  - Usa jsonPath("$.titular.nombre").value("NombreEsperado")
     */
    @Test
    @Disabled("Implementa este ejercicio")
    @DisplayName("EJ7: Cambio de titular en cuenta se refleja correctamente")
    void ejercicio7_cambioTitular_nombreCorrecto() throws Exception {
        // TODO: implementa aquí el test
    }

    /**
     * EJERCICIO 8
     *
     * Crear una Persona con dos Cuentas asociadas.
     * Verificar que GET /cuentas devuelve exactamente 2 cuentas.
     */
    @Test
    @Disabled("Implementa este ejercicio")
    @DisplayName("EJ8: Una persona puede tener múltiples cuentas")
    void ejercicio8_personaConDosCuentas_listaContieneDos() throws Exception {
        // TODO: implementa aquí el test
    }

    // ================================================================== //
    //  BLOQUE 4 — Upload de imagen
    // ================================================================== //

    /**
     * EJERCICIO 9 — AVANZADO
     *
     * Crear una persona y subir una imagen a POST /persona/{id}/logo.
     * Verificar que la respuesta contiene el nombre del fichero subido.
     *
     */
    @Test
    @Disabled("Ejercicio avanzado — requiere MockMultipartFile")
    @DisplayName("EJ9 (avanzado): Subir imagen a persona devuelve nombre del fichero")
    void ejercicio9_subirImagen_devuelveNombreFichero() throws Exception {
        // TODO: implementa aquí el test
    }
}
