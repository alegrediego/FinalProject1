package binary;

import java.util.ArrayList;

public class Course {

    private ArrayList<Instructor> instructorss;


    private String number = null;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }





    public void setMaxNumbofStudents(int maxNumbofStudents) {
        this.maxNumbofStudents = maxNumbofStudents;
    }

    private String name = null;

    public String getInstructor() {
        return instructor;
    }


    public void setInstructor(ArrayList<Instructor> a) {
        String ret = null;
        for(int i = 0; i<a.size();i++){
            if(i==0){
                ret = a.get(i).getId();
            } else {
                ret = ret + "," +a.get(i).getId();
            }

        }
        this.instructor = ret;
    }

    private String instructor = null;

    private int maxNumbofStudents;

    public Course(String number,String name,ArrayList<Instructor>instructors, int maxNumbofStudents){
        this.number = number;
        this.name = name;
        this.instructorss = instructors;
        this.maxNumbofStudents = maxNumbofStudents;

    }
    public Course(String number, String name, String instructor, Integer maxNumbofStudents){
        this.number = number;
        this.name = name;
        this.instructor = instructor;
        this.maxNumbofStudents = maxNumbofStudents;
    }

    public Course(){

    }


    public String getNumber() {return number;}
    public String getName() {return name;}

    public int getMaxNumbofStudents() {return maxNumbofStudents;}


    public ArrayList<Instructor> getInstructors(){return instructorss;}
    @Override
    public String toString() {
        return "Course{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", instructors=" + instructor +
                ", maxNumbofStudents=" + maxNumbofStudents +
                '}';
    }

    /*private String number = null;
    private String name = null;
    private int maxNumbofStudents;
    private ArrayList<Instructor> instructors;

    public Course(String number, String name, ArrayList<Instructor> instructors, int maxNumbofStudents) {
        this.number = number;
        this.name = name;
        this.instructors = instructors;
        this.maxNumbofStudents = maxNumbofStudents;
    }
    public Course(){}

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxNumbofStudents() {
        return this.maxNumbofStudents;
    }

    public ArrayList<Instructor> getInstructors() {
        return this.instructors;
    }

    public String toString() {
        return this.name;
    }*/
}
