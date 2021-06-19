package com.deepak.springreactivecassandraexample.bdd;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@AllArgsConstructor
@DirtiesContext
@ContextConfiguration
@CucumberContextConfiguration
@Testcontainers(disabledWithoutDocker = true)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GenericSteps {

   public static DockerImageName cassandraImage = DockerImageName.parse("cassandra:3.11.10").asCompatibleSubstituteFor("cassandra");


   @Container
   public static CassandraContainer cassandra = new CassandraContainer<>(cassandraImage)
           .withInitScript("database/Init.sql") // inside src/test/resources
           .withExposedPorts(9042);

    @DynamicPropertySource
    public static void setDynamicProps(DynamicPropertyRegistry registry) throws Exception {
        System.out.println("************************************setUP***************************");
        System.out.println("cassadnra getMappedPort = "+ cassandra.getMappedPort(9042));
        //registry.add("spring.data.cassandra.contact-points", () -> "local");
        registry.add("spring.data.cassandra.port", () -> cassandra.getMappedPort(9042));
        //registry.add("spring.data.cassandra.keyspace-name", () -> "");


        System.out.println("%%%%%%%%%%%%$$$$$$$$$$");
        System.out.println("cassadnra cluster metadata= "+ cassandra.getCluster().getMetadata());
    }

    static
    {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        cassandra.addEnv("CASSANDRA_DC", "local");
        cassandra.start();

    }


}
