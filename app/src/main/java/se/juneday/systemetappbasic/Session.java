package se.juneday.systemetappbasic;

import java.util.ArrayList;
import java.util.List;

import se.juneday.systemetappbasic.domain.Product;

public class Session {

    // TODO: fix later, not public :(
    public  List<Product> favorites;

    private static Session instance;
    private Session() {
        favorites = new ArrayList<>();
    };

    public static Session getInstance() {
        if (instance==null) {
            instance = new Session();
        }
        return instance;
    }

}
