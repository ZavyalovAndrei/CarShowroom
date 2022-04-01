public class Car {
    private final String COLOR;
    private final String MODEL;
    private final int ENGINE_POWER;

    public Car(String color, String model, int enginePower) {
        this.COLOR = color;
        this.MODEL = model;
        this.ENGINE_POWER = enginePower;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n\t");
        sb.append("Модель: Ford ").append(MODEL).append(", цвет: ").append(COLOR).append(", мощность двигателя: ").
                append(ENGINE_POWER).append(" л.с.");
        return sb.toString();
    }
}