package gajda.szymon;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface IgnoreEquals {

}

public class Klasa {
    private int pole1;
    private double pole2;
    private String pole3;
    private boolean pole4;

    public int getPole1() {
        return pole1;
    }

    public void setPole1(int pole1) {
        this.pole1 = pole1;
    }

    public double getPole2() {
        return pole2;
    }

    public void setPole2(double pole2) {
        this.pole2 = pole2;
    }

    @IgnoreEquals
    public String getPole3() {
        return pole3;
    }

    public void setPole3(String pole3) {
        this.pole3 = pole3;
    }

    public boolean isPole4() {
        return pole4;
    }

    public void setPole4(boolean pole4) {
        this.pole4 = pole4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klasa klasa = (Klasa) o;

        if (pole1 != klasa.pole1) return false;
        if (Double.compare(klasa.pole2, pole2) != 0) return false;
        return pole4 == klasa.pole4;
    }

    public boolean reflectionEquals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Klasa rhs = (Klasa) obj;e
    }
    }
}
