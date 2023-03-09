package lambdasinaction.chapter8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryMain {
    public static void main(String[] args) {
        Product p1 = ProductFactory.createProduct("loan");
        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();
        Product p3 = ProductFactory.createProduct("loan");
    }

    static private class ProductFactory {

        public static Product createProduct(String name) {
            switch (name) {
                case "load":
                    return new Loan();
                case "stock":
                    return new Stock();
                case "bond":
                    return new Bond();
                default:
                    throw new RuntimeException("No such product" + name);
            }
        }
    }

    static private interface Product {
    }

    static private class Loan implements Product {
    }

    static private class Stock implements Product {
    }

    static private class Bond implements Product {
    }

    final static private Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("load", Loan::new);
        map.put("stock", Loan::new);
        map.put("bond", Loan::new);
    }
}
