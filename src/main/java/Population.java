import java.util.ArrayList;
import java.util.stream.IntStream;

public class Population {
    private ArrayList<Schedule> schedules;

    public Population(int size, data data) {
        this.schedules = new ArrayList(size);
        IntStream.range(0, size).forEach((x) -> {
            this.schedules.add((new Schedule(data)).initialize());
        });
    }

    public ArrayList<Schedule> getSchedules() {
        return this.schedules;
    }

    public Population sortByFitness() {
        this.schedules.sort((schedule1, schedule2) -> {
            int returnValue = 0;
            if (schedule1.getFitness() > schedule2.getFitness()) {
                returnValue = -1;
            } else if (schedule1.getFitness() < schedule2.getFitness()) {
                returnValue = 1;
            }

            return returnValue;
        });
        return this;
    }
}
