package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(Enclosed.class)
public class AnimalTest{

    @RunWith(Parameterized.class)
    public static class AnimalTestParameterized {

        private String animalKind;
        private List<String> mealList;

        public AnimalTestParameterized(String animalKind, List<String> mealList) {
            this.animalKind = animalKind;
            this.mealList = mealList;
        }

        @Parameterized.Parameters
        public static Object[][] getMealData() {
            return new Object[][]{
                    {"Травоядное", List.of("Трава", "Различные растения")},
                    {"Хищник", List.of("Животные", "Птицы", "Рыба")},
            };
        }

        @Test
        public void checkAnimalCorrectMeal() throws Exception {
            Animal animal = new Animal();
            Assert.assertEquals("Ожидается совпадение блюд на покушать", mealList, animal.getFood(animalKind));
        }
    }

    public static class AnimalTestSingle{

        @Test
        public void checkAnimalInCorrectMeal() throws Exception{
            Animal animal = new Animal();
            assertThrows(Exception.class, () -> animal.getFood("Человек-редиска"));
        }

        @Test
        public void shouldReturnListOfFamilies() {
            Animal animal = new Animal();
            String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
            Assert.assertEquals(expectedFamily, animal.getFamily());
        }
    }
}

