package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;


    @Test
    public void shouldDoSound() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        Assert.assertEquals("Ожидается совпадение звуков", expectedSound, actualSound);
    }

    @Test
    public void shouldReturnCorrectMeal() throws Exception{
        Cat cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualMeal = cat.getFood();
        List<String> expectedMeal = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Ожидается совпадение типа животного", expectedMeal, actualMeal);
    }

}
