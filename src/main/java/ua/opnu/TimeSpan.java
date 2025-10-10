package ua.opnu;


public class TimeSpan {

    private int hours; //зберігаємо гожини
    private int minutes; //зберігаємо хвилини

//конструктор
    public TimeSpan(int hours, int minutes) {
        //перевіряємо, щоб години були >0, а хвилини від 0 до 59
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public int getHours() {
        return hours;//тут години без хвилин
    }

    public int getMinutes() {
        return minutes;//тут повертаємо хвилини, але без годин
    }


    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return; // некоректні значення — нічого не робимо
        }
        this.minutes += minutes;
        this.hours += hours + this.minutes / 60; // додаємо години, якщо хвилин більше 60
        this.minutes %= 60; // залишок хвилин
    }

    public void addTimeSpan(TimeSpan timespan) {
        // додаємо інший інтервал часу
        this.add(timespan.getHours(), timespan.getMinutes());
    }

    public double getTotalHours() {
        return hours + minutes / 60.0; // години + дробова частина хвилин
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes; // години переводимо у хвилини
    }

    public void subtract(TimeSpan span) {
        int totalCurrent = getTotalMinutes();
        int totalSubtract = span.getTotalMinutes();

        if (totalSubtract > totalCurrent) {
            // якщо від’ємний результат — не змінюємо (так роблять тести)
            return;
        }

        int resultMinutes = totalCurrent - totalSubtract;
        hours = resultMinutes / 60;
        minutes = resultMinutes % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return; // фактор має бути >0
        }
        int totalMinutes = getTotalMinutes() * factor;
        hours = totalMinutes / 60;
        minutes = totalMinutes % 60;
    }
}