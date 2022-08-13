
class Car {

    int yearModel;
    String make;
    int speed;
    int number = 5;

    public void accelerate() {
        speed += number;
    }

    public void brake() {
        if (speed < number) {
            speed -= speed;
        } else {
            speed -= number;
        }
    }
}