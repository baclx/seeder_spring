package com.example.seeder.thread;

import com.example.seeder.model.Product;
import com.example.seeder.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static com.example.seeder.SeederApplication.faker;

@Component
public class ThreadSeed extends Thread{

    @Autowired
    ProductRepo productRepo;

    @Override
    public void run() {
        try {
            commandLineRunnerThread();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    CommandLineRunner commandLineRunnerThread() {
        return args -> {
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

                System.out.println("Thread save");
            }
        };
    }
}
