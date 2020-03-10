package com.desafiolatam.desafio_06_01_password_strength_mvp.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VerifierTest {

    Verifier testVerifier;
    String pass;

    @BeforeAll
    public void setup(){
        testVerifier = new Verifier();
    }

    @Nested
    @DisplayName("Tests for checkPassLength(String pass)")
    class CheckPassLengthTests {

        @DisplayName("Left Edge - Shorter Password")
        @Test
        public void passShorterThanMinimumTest() {
            pass = "aaaa";

            assertFalse(testVerifier.checkPassLength(pass));
        }

        @DisplayName("Right Edge - Equal or Longer Password")
        @Test
        public void passEqualOrLongerThanMinimumTest() {
            pass = "aaaaa";

            assertTrue(testVerifier.checkPassLength(pass));
        }

    }

    @Nested
    @DisplayName("Tests for checkPassHasUppercase(String pass)")
    class CheckPassHasUppercaseTests {

        @DisplayName("Doesn't have Uppercase Letters")
        @Test
        public void passDoesNotHaveUppercaseTest(){
            pass = "aaaaa";

            assertFalse(testVerifier.checkPassHasUppercase(pass));
        }

        @DisplayName("Has Uppercase Letters")
        @Test
        public void passHasUppercaseTest(){
            pass = "aaaAa";

            assertTrue(testVerifier.checkPassHasUppercase(pass));
        }

    }

    @Nested
    @DisplayName("Tests for checkPassHasDigit(String pass)")
    class CheckPassHasDigitTests {

        @DisplayName("Doesn't have a Digit")
        @Test
        public void passDoesNotHaveDigitTest(){
            pass = "aaaaa";

            assertFalse(testVerifier.checkPassHasDigit(pass));
        }

        @DisplayName("Has a Digit")
        @Test
        public void passHasDigitTest(){
            pass = "a2aaa";

            assertTrue(testVerifier.checkPassHasDigit(pass));
        }
    }

    @Nested
    @DisplayName("Tests for checkPassStrength(String pass)")
    class CheckPassStrengthTests{

        @DisplayName("is Weak")
        @Test
        public void passIsWeakTest(){
            pass = "Aa3a";

            assertEquals(0, testVerifier.checkPassStrength(pass));
        }

        @DisplayName("is Medium")
        @Test
        public void passIsMediumTest(){
            pass = "aaaaa";

            assertEquals(1, testVerifier.checkPassStrength(pass));
        }

        @DisplayName("is Strong")
        @Test
        public void passIsStrongTest(){
            pass = "aaAaa";

            assertEquals(2, testVerifier.checkPassStrength(pass));
        }

        @DisplayName("is Very Strong")
        @Test
        public void passIsVeryStrongTest(){
            pass = "aAAa3";

            assertEquals(3, testVerifier.checkPassStrength(pass));
        }
    }
}