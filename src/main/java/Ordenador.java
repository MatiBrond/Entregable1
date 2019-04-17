import java.util.ArrayList;
import java.util.Arrays;

public class Ordenador {

    private ArrayList a;

    public Ordenador() {
        super();
    }

    public static <T extends Comparable<T>> T[] order(T a[]) {
        Arrays.sort(a);
        return a;
    }
}
