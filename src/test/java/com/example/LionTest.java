package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(Enclosed.class)
public class LionTest {

    @RunWith(Parameterized.class)
    public static class LionTestParameterized {

        @Mock
        private static Feline feline;

        private String actualSex;
        private boolean expectedSex;

        public LionTestParameterized(String actualSex, boolean expectedSex) {
            this.actualSex = actualSex;
            this.expectedSex = expectedSex;
        }

        @Parameterized.Parameters
        public static Object[][] getSexData() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
            };
        }

        @Test
        public void checkManeOfLineCorrectSex() throws Exception {
            Lion lion = new Lion(actualSex, feline);
            Assert.assertEquals("Ожидается совпадение пола", expectedSex, lion.doesHaveMane());
        }
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class LionTestSingle {

        @Mock
        private Feline feline;

        //Спасибо! Получилось!
        @Test
        public void checkManeOfLineInCorrectSex() {
            assertThrows(Exception.class, () -> new Lion("Трансгендер", feline));
        }


        @Test
        public void shouldHaveKittens() throws Exception {
            int expectedKitten = 1;
            Lion lion = new Lion("Самка", feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            Assert.assertEquals("Ждём одну живность", expectedKitten, lion.getKittens());
        }

        @Test
        public void shouldHaveCorrectListOfMeal() throws Exception {
            Lion lion = new Lion("Самец", feline);
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals("Получен некорректный список продуктов питания для Хищника", expected, lion.getFood());
        }
    }
}