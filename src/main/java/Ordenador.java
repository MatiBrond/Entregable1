import java.util.ArrayList;

public class Ordenador <E>{


    private ArrayList a ;

    public Ordenador(){
        super();
    }


    public static <T extends Comparable<T>> T ordenar(T a[]){

        T flag = a[0];

        if (a.length > 0) {
            for (int i = 1; i < a.length; i++) {

                if(a[i] == null) continue;
                if (flag.compareTo(a[i]) >= 0) {
                    flag = a[i];
                } else {
                    flag = flag;
                }
            }
        }
        return flag;
    }


}
