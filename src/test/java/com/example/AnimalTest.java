package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest{

    public String animalKind;
    public List<String> mealList;

    public AnimalTest(String animalKind, List<String> mealList) {
        this.animalKind = animalKind;
        this.mealList = mealList;
    }

    @Parameterized.Parameters
    public static Object[][] getMealData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void checkAnimalCorrectMeal() throws Exception{
        Animal animal = new Animal();
        Assert.assertEquals("Ожидается совпадение блюд на покушать", mealList, animal.getFood(animalKind));
    }

    @Test(expected = Exception.class)
    public void checkAnimalInCorrectMeal() throws Exception{
        Animal animal = new Animal();
        Assert.assertEquals(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"), animal.getFood("Человек-редиска"));
    }

    @Test
    public void shouldReturnListOfFamilies() {
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expectedFamily, animal.getFamily());
    }

}
