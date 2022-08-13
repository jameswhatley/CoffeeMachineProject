
class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (minutes < 59) {
            this.minutes++;
        } else if (minutes == 59 && hours == 12) {
            this.hours = 1;
            this.minutes = 0;
        } else if (minutes == 59 && hours < 12) {
            this.minutes = 0;
            this.hours++;
        }
    }
}