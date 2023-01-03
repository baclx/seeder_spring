package com.example.seeder;

import com.example.seeder.model.Product;
import com.example.seeder.model.Project;
import com.example.seeder.model.User;
import com.example.seeder.repo.ProductRepo;
import com.example.seeder.repo.ProjectRepo;
import com.example.seeder.repo.UserRepo;
import com.example.seeder.thread.ThreadSeed;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class SeederApplication {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ProductRepo productRepo;

    public static void main(String[] args) {
        SpringApplication.run(SeederApplication.class, args);

        ThreadSeed threadSeed = new ThreadSeed();
        threadSeed.start();
    }

    public static Faker faker = new Faker(new Locale("en-US"));

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            int min = 0, max = 10;

            HashMap<Integer, User> mapUsers = new HashMap<>();
            HashMap<Long, Project> mapProjects = new HashMap<>();

//            List<User> userList = new ArrayList<>();
//            List<Project> projectList = new ArrayList<>();
            User user = new User();
            Project project = new Project();

//            for (long i = 0; i < 10; i++) {
////                mapUsers.put(i, new User(faker.name().firstName(), faker.name().lastName()));
////                mapProjects.put(i, new Project(faker.app().name(), faker.app().author()));
//
////                User user = new User(faker.name().firstName(), faker.name().lastName());
////                user = new User(faker.name().firstName(), faker.name().lastName());
////                userList.add(user);
//
////                Project project = new Project(faker.app().author(), faker.name().name(), faker.number().randomDouble(0, 0, 100));
//                project = new Project(faker.app().author(), faker.name().name(), faker.number().randomDouble(0, 0, 100));
////                projectList.add(project);
//
////                mapUsers.put(i, user);
//                mapProjects.put(i, project);
//
//                projectRepo.save(project);
////                userRepo.save(user);
//            }
//
//            for (int j = 0; j < 10; j++) {
//                user = new User(faker.name().firstName(), faker.name().lastName());
//                mapUsers.put(j, user);
//
//                userRepo.save(user);
//            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            Date date = new Date();
            HashMap<Long, Product> mapProducts = new HashMap<>();
            for (long i = 1; i <= 100; i++) {
                Product product = new Product(
                        faker.name().name(),
                        faker.name().username(),
                        (long)(faker.number().numberBetween(1, 500)),
                        faker.date().birthday(),
                        faker.date().birthday()
                );
                mapProducts.put(i, product);

                productRepo.save(product);
            }

            System.out.println("----------------");

//            for (long i = 1; i <= 1000; i++) {
//                Product product = new Product(
//                        faker.name().name(),
//                        faker.name().username(),
//                        (long)(faker.number().numberBetween(1, 500)),
//                        faker.date().birthday(),
//                        faker.date().birthday()
//                );
//                mapProducts.put(i, product);
//
//                productRepo.save(product);
//            }
            System.out.println(dateFormat.format(date) + " app " + new Date());
        };
    }
}
