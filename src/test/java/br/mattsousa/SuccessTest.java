package br.mattsousa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessTest {

    @Test
    public void test_AlwaysTrue() {
        assertTrue(true, "Esse teste deve retornar sucesso para garantir o funcionamento do JUnit");
    }
}
