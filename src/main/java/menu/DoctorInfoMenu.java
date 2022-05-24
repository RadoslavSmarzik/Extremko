package menu;

import models.Person;
import queries.Query;

import java.sql.SQLException;

public class DoctorInfoMenu extends Menu{
    int doctorId;

    public DoctorInfoMenu(Query query, Person loggedUser, int doctorId) {
        super(query, loggedUser);
        this.doctorId = doctorId;
    }

    @Override
    public void print() throws SQLException {
        System.out.println("*******************************");
        System.out.println("* 1. Zobraz voľné termíny");
        System.out.println("* 2. Informácie o doktorovi");
        System.out.println("* 0. Späť");
        System.out.println("*******************************");
    }

    @Override
    public void handle(String option) throws SQLException {
        if(loggedUser == null){
            System.out.println("NOBODY IS LOGGED");
            return;
        }
        if(Integer.parseInt(option) == 1){
            AppointmentsMenu menu = new AppointmentsMenu(query, loggedUser, doctorId);
            menu.run();
            return;
        }
        if(Integer.parseInt(option) == 2){
            Person doctor = query.getPersonById(doctorId);
            System.out.println(doctor.getFullName());
            System.out.println(doctor.getAddress());
            System.out.println(doctor.getCity());
            System.out.println(doctor.getInformation());
            return;
        }
        if(Integer.parseInt(option) == 0){
            exit();
            return;
        }

        System.out.println("INCORRECT COMMAND");
    }
}
