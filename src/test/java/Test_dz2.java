import Lesson_6.DZ.dz_2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
@RunWith(Parameterized.class)

public class Test_dz2 {
    @Parameterized.Parameters
    public static Collection<Object[]> arrays (){
        return Arrays.asList(new Object[][]{
                {new int[]{0,1,5,8,0,2}},
                {new int[]{0,4,5,8,1,2}},
                {new int[]{0,7,5,8,0,2}},
                {new int[]{0,7,5,8,4,1,0,2,1}},
        });
    }

    private dz_2 test_dz2;
    private int [] mass;

    public Test_dz2(int[] mass_) {
        this.mass = mass_;
    }

    @Before
    public void init(){
        this.test_dz2 = new dz_2();
    }


    @Test
    public void Test3 (){
        Assert.assertTrue("В массиве нет 1 или 4",test_dz2.myMethod(mass));
    }
}