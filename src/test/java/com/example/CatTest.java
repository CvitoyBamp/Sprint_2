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

    //Переделал, убрал Мокито.
    @Test
    public void shouldReturnCorrectMeal() throws Exception{
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        List<String> actualEatMeat = cat.getFood();
        Assert.assertEquals(expectedEatMeat, actualEatMeat);
    }
}
