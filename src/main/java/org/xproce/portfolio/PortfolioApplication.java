package org.xproce.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xproce.portfolio.dao.entities.Technology;
import org.xproce.portfolio.metier.ProjectManager;
import org.xproce.portfolio.metier.TechnologyManager;

import java.util.Date;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {

    @Autowired
    ProjectManager projectManager;
    @Autowired
    TechnologyManager technologyManager;

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Project Project0 = new Project(null, "msi","msi i9 17",new Date(),new Date());
//        Project Project1 = new Project(null, "hp","hp vpro 14",new Date(),new Date());
//        Project Project2 = new Project(null, "macbook pro","mac book pro m2 16gb 512",new Date(),new Date());
//        Project Project3 = new Project(null, "macbook air","mac book air m2 8gb 51",new Date(),new Date());
//        Project Project4 = new Project(null, "macbook m3","mac book pro m3 max  18gb 51",new Date(),new Date());
//        Project Project5 = new Project(null, "macbook m3","mac book pro m3 max  18gb 51",new Date(),new Date());
//        Project Project6 = new Project(null, "macbook m3","mac book pro m3 max  18gb 51",new Date(),new Date());
//        Project Project7 = new Project(null, "macbook m3","mac book pro m3 max  18gb 51",new Date(),new Date());
//        Project Project8 = new Project(null, "macbook m3","mac book pro m3 max  18gb 51",new Date(),new Date());
//        projectManager.addProject(Project0);
//        projectManager.addProject(Project1);
//        projectManager.addProject(Project2);
//        projectManager.addProject(Project3);
//        projectManager.addProject(Project4);
//        projectManager.addProject(Project5);
//        projectManager.addProject(Project6);
//        projectManager.addProject(Project7);
//        projectManager.addProject(Project8);
        Technology Project0 = new Technology(null, "Javascript",new Date(),new Date());
        technologyManager.addTechnology(Project0);
    }
}
