package Lesson_6.DZ;

public class dz_1 {

    public static void main(String[] args) {
        dz_1 abc = new dz_1();
        int[]a = abc.myMetod(new int[]{1,2,4,4,2,3,4,1,7});
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public int[] myMetod (int[] mass) throws RuntimeException {
        int[] newMass = null;
        int j = 0;
        boolean ok = false;
        for (int i = mass.length-1; i >= 0; i--) {
            if (mass[i] == 4) {
                j = i;
                ok = true;
                break;
            }
        }

        if (ok){
            newMass = new int[mass.length - j-1];
            System.arraycopy(mass, j+1, newMass, 0, mass.length-j-1);
        } else {
            throw new RuntimeException("В массиве нет 4");
        }

        return  newMass;
    }



}
