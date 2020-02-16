package Lesson_6.DZ;

public class dz_2 {
    public boolean myMethod(int [] a){
        boolean ok = false;
        int count1 = 0;
        int count4 = 0;

        for (int o:a) {
            if (o == 1){
                count1++;
            } else {
                if (o == 4){
                    count4++;
                }
            }

            if (count1 != 0 && count4 != 0){
                ok = true;
                break;
            }
        }
        return ok;
    }

}
