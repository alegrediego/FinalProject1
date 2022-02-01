package binary;

import java.util.ArrayList;

public class Department {

    public void setName(String name) {
        this.name = name;
    }


    private String name;
    private ArrayList<Course> courses;
    private String coursess;

        public Department(){

        }
    public Department(String name, String coursess) {
        this.name = name;
        this.coursess = coursess;
    }

    public void setCourses(ArrayList<Course> a) {
        String ret = null;
        for(int i = 0; i<a.size();i++){
            if(i==0){
                ret = a.get(i).getNumber();
            } else {
                ret = ret + "," +a.get(i).getNumber();
            }

        }
        this.coursess = ret;
    }

        public Department(String name, ArrayList<Course> courses) {
            this.name = name;
            this.courses = courses;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Course> getCourses() {
            return courses;
        }

        public String getCoursess(){ return coursess;}
    }
