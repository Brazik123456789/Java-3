import Lesson_6.DZ.dz_1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestMass {

    @Parameterized.Parameters
    public static Collection<Object[]> arrays() {
        return Arrays.asList(new Object[][] {
                {new int[]{5,9,4,0,2,1,8,5,7}, new int[]{3,8}},
                {new int[]{5,9,4,0,2,1,3,5,7}, new int[]{1,9,5}},
                {new int[]{5,9,3,0,2,1,5,5,7}, new int[]{0,8,2}},
                {new int[]{5,9,4,0,2,1,0,5,7}, new int[]{0,2,1,0,5,7}},
        });
    }

    private dz_1 test_dz_1;
    private int [] in;
    private int [] out;

    public TestMass(int [] in_, int[] out_) {
        this.in = in_;
        this.out = out_;
    }

    @Before
    public void init (){
        test_dz_1 = new dz_1();
    }


    @Test
    public void Test_dz1 (){
        Assert.assertTrue("Массивы не равны", Arrays.equals(out, test_dz_1.myMetod(in)));

    }


}