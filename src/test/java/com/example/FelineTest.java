package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Enclosed.class)
public class FelineTest {

    @RunWith(Parameterized.class)
    public static class FelineTestParameterized {

        private final int actualKittens;
        private final int expectedKittens;

        public FelineTestParameterized(int actualKittens, int expectedKittens) {
            this.actualKittens = actualKittens;
            this.expectedKittens = expectedKittens;
        }

        @Parameterized.Parameters
        public static Object[][] getKittenData() {
            return new Object[][]{
                    {1, 1},
                    {2, 2},
            };
        }

        @Test
        public void getCorrectNumberKittens() {
            Feline feline = new Feline();
            Assert.assertEquals("Ожидается совпадение количества котят", expectedKittens, feline.getKittens(actualKittens));
        }
    }

    public static class FelineTestSingle {

        @Test
        public void getOneKitten() {
            Feline feline = new Feline();
            int expectedOneKitten = 1;
            Assert.assertEquals("Ожидается совпадение количества котят", expectedOneKitten, feline.getKittens());
        }

        @Test
        public void getCorrectFamily(){
            Feline feline = new Feline();
            String actualFamily = feline.getFamily();
            String expectedFamily = "Кошачьи";
            Assert.assertEquals("Ожидается совпадение семейства", expectedFamily, actualFamily);
        }

        @Test
        public void eatMeatTest() throws Exception {
            Feline feline = new Feline();
            List<String> actual = feline.eatMeat();
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Assert.assertEquals(expected, actual);
        }
    }
}
