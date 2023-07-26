package ru.starkov;

public class Main {



    public static void main(String[] args) throws NoSuchFieldException {
        Car car = new Car("Toyota", "Corolla");
        System.out.println(query(car));
    }

    public static String query(Car car) throws NoSuchFieldException {
        Class<? extends Car> aClass = car.getClass();

        String schema = car.getClass().getAnnotation(Table.class).schema();
        String table = car.getClass().getAnnotation(Table.class).table();
        String columnBrand = car.getClass().getDeclaredField("brand").getAnnotation(Column.class).column();
        String columnModel = car.getClass().getDeclaredField("model").getAnnotation(Column.class).column();
        String brand = car.getBrand();
        String model = car.getModel();

        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ")
                .append(schema)
                .append(".")
                .append(table)
                .append(" ")
                .append(String.format("(%s, %s)", columnBrand, columnModel))
                .append(" ")
                .append("VALUES")
                .append(" ")
                .append(String.format("('%s', '%s')", brand, model))
                .append(";");
        return query.toString();
    }
}
