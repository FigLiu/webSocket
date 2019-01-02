package cn.okuribito;

import cn.okuribito.model.model0;
import cn.okuribito.model.model1;
import cn.okuribito.model.model2;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends model2
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        model0[] models = new model0[3];
        models[0] = new model0();
        models[1] = new model1();
        models[2] = new model2();
        for (int a = 0; a < models.length; a++){
            models[a].returnNew();
            //            System.out.println(model.getClass().getSimpleName());
        }
    }


    @Test
    public void appTest(){
        System.out.println(Integer.toHexString(96));
        int a = -8 >> 4;
        String c = Integer.toBinaryString(-8);
        String d = Integer.toBinaryString(8);
        int b = 0b00001000;

               // (1-15)%12;
        System.out.println(a);
        System.out.println(b>>4);
        System.out.println(c);
        System.out.println(d);
    }
}

