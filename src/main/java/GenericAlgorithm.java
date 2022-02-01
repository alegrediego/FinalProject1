import binary.Class;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GenericAlgorithm {

    private data data;
    public GenericAlgorithm(data data){this.data = data;}
    public Population evolve(Population population){return mutatePopulation(crossoverPopulation(population));}

    Population crossoverPopulation(Population population){
        Population crossoverPopulation = new Population(population.getSchedules().size(),data);
        IntStream.range(0,Main.NUMB_OF_ELITE_SCHEDULES).forEach(x->crossoverPopulation.getSchedules().set(x,population.getSchedules().get(x)));
        IntStream.range(Main.NUMB_OF_ELITE_SCHEDULES,population.getSchedules().size()).forEach(x->{
            if (Main.CROSSOVER_RATE > Math.random()){
                Schedule schedule1 = selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                Schedule schedule2 = selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                crossoverPopulation.getSchedules().set(x,crossoverSchedule(schedule1,schedule2));
            }else crossoverPopulation.getSchedules().set(x,population.getSchedules().get(x));
        });
        return crossoverPopulation;
    }
    Schedule crossoverSchedule(Schedule schedule1, Schedule schedule2){
        Schedule croosoverSchedule = new Schedule(data).initialize();
        IntStream.range(0, croosoverSchedule.getClasses().size()).forEach(x ->{
            if (Math.random() > 0.5) croosoverSchedule.getClasses().set(x,schedule1.getClasses().get(x));
            else croosoverSchedule.getClasses().set(x,schedule2.getClasses().get(x));
        });
        return croosoverSchedule;
    }
    Population mutatePopulation(Population population){
        Population mutatePopulation = new Population(population.getSchedules().size(),data);
        ArrayList<Schedule> schedules =  mutatePopulation.getSchedules();
        IntStream.range(0,Main.NUMB_OF_ELITE_SCHEDULES).forEach(x-> schedules.set(x, population.getSchedules().get(x)));
        IntStream.range(Main.NUMB_OF_ELITE_SCHEDULES,population.getSchedules().size()).forEach(x->{
            schedules.set(x, mutateSchedule(population.getSchedules().get(x)));
        });
        return mutatePopulation;
    }
    Schedule mutateSchedule(Schedule mutateSchedule){
        Schedule schedule = new Schedule(data).initialize();
        IntStream.range(0,mutateSchedule.getClasses().size()).forEach(x->{
            if (Main.MUTATION_RATE > Math.random()) mutateSchedule.getClasses().set(x,schedule.getClasses().get(x));
        });

        return mutateSchedule;
    }

    Population selectTournamentPopulation(Population population){
        Population tournamentPopulation = new Population(Main.TOURNAMENT_SELECTION_SIZE,data);
        IntStream.range(0,Main.TOURNAMENT_SELECTION_SIZE).forEach(x->{
            tournamentPopulation.getSchedules().set(x,population.getSchedules().get((int) (Math.random() * population.getSchedules().size())));

        });
        return tournamentPopulation;
    }

    /*private data data;

    public GenericAlgorithm (data data) {
        this.data = data;
    }

    public Population evolve(Population population) {
        return this.mutatePopulation(this.crossoverPopulation(population));
    }

    Population crossoverPopulation(Population population) {
        Population crossoverPopulation = new Population(population.getSchedules().size(), this.data);
        IntStream.range(0, 1).forEach((x) -> {
            crossoverPopulation.getSchedules().set(x, (Schedule)population.getSchedules().get(x));
        });
        IntStream.range(1, population.getSchedules().size()).forEach((x) -> {
            if (0.9D > Math.random()) {
                Schedule schedule1 = (Schedule)this.selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                Schedule schedule2 = (Schedule)this.selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                crossoverPopulation.getSchedules().set(x, this.crossoverSchedule(schedule1, schedule2));
            } else {
                crossoverPopulation.getSchedules().set(x, (Schedule)population.getSchedules().get(x));
            }

        });
        return crossoverPopulation;
    }

    Schedule crossoverSchedule(Schedule schedule1, Schedule schedule2) {
        Schedule croosoverSchedule = (new Schedule(this.data)).initialize();
        IntStream.range(0, croosoverSchedule.getClasses().size()).forEach((x) -> {
            if (Math.random() > 0.5D) {
                croosoverSchedule.getClasses().set(x, (Class) schedule1.getClasses().get(x));
            } else {
                croosoverSchedule.getClasses().set(x, (Class)schedule2.getClasses().get(x));
            }

        });
        return croosoverSchedule;
    }

    Population mutatePopulation(Population population) {
        Population mutatePopulation = new Population(population.getSchedules().size(), this.data);
        ArrayList<Schedule> schedules = mutatePopulation.getSchedules();
        IntStream.range(0, 1).forEach((x) -> {
            schedules.set(x, (Schedule)population.getSchedules().get(x));
        });
        IntStream.range(1, population.getSchedules().size()).forEach((x) -> {
            schedules.set(x, this.mutateSchedule((Schedule)population.getSchedules().get(x)));
        });
        return mutatePopulation;
    }

    Schedule mutateSchedule(Schedule mutateSchedule) {
        Schedule schedule = (new Schedule(this.data)).initialize();
        IntStream.range(0, mutateSchedule.getClasses().size()).forEach((x) -> {
            if (0.1D > Math.random()) {
                mutateSchedule.getClasses().set(x, (Class)schedule.getClasses().get(x));
            }

        });
        return mutateSchedule;
    }

    Population selectTournamentPopulation(Population population) {
        Population tournamentPopulation = new Population(3, this.data);
        IntStream.range(0, 3).forEach((x) -> {
            tournamentPopulation.getSchedules().set(x, (Schedule)population.getSchedules().get((int)(Math.random() * (double)population.getSchedules().size())));
        });
        return tournamentPopulation;
    }*/
}
