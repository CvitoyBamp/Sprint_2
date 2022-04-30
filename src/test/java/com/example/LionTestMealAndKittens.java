package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTestMealAndKittens {
    @Mock
    Feline feline;

    @Test
    public void shouldHaveCorrectListOfMeal() throws Exception{
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Получен некорректный список продуктов питания для Хищника", expected, lion.getFood());
    }

    //Дубль теста с котятами
    @Test
    public void shouldHaveKittens() throws Exception{
        int expectedKitten = 1;
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals("Ждём одну живность",expectedKitten, lion.getKittens());
    }
}
