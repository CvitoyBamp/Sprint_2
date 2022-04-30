package com.example;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public String actualSex;
    public boolean expectedSex;

    public LionTest(String actualSex, boolean expectedSex) {
        this.actualSex = actualSex;
        this.expectedSex = expectedSex;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void checkManeOfLineCorrectSex() throws Exception{
        Lion lion = new Lion(actualSex, feline);
        Assert.assertEquals("Ожидается совпадение пола", expectedSex, lion.doesHaveMane());
    }

    //Спасибо! Получилось!
    @Test
    public void checkManeOfLineInCorrectSex(){
        assertThrows(Exception.class, () -> new Lion("Трансгендер", feline));
    }


    @Test
    public void shouldHaveKittens() throws Exception{
        int expectedKitten = 1;
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals("Ждём одну живность",expectedKitten, lion.getKittens());
    }

    @Test
    public void shouldHaveCorrectListOfMeal() throws Exception{
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Получен некорректный список продуктов питания для Хищника", expected, lion.getFood());
    }
}
