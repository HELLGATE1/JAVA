package FX.Object;

import java.util.Locale;

public class Lang {
private String name;
private Locale locale;
private int index;

public Lang(int index, String name, Locale locale) {
    this.name = name;
    this.locale = locale;
    this.index = index;
}

@Override
public String toString() {return name;}

public String getName() {return name;}

public Locale getLocale() {return locale;}

public int getIndex() {return index;}

public void setName(String name) {this.name = name;}

public void setLocale(Locale locale) {this.locale = locale;}

public void setIndex(int index) {this.index = index;}

}
