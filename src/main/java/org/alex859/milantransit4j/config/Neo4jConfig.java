package org.alex859.milantransit4j.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Configuration
public class Neo4jConfig extends Neo4jConfiguration
{
   @Bean
   public GraphDatabaseService graphDatabaseService()
   {
      setBasePackage("org.alex859.milantransit4j.model.graph");
      //return new SpringCypherRestGraphDatabase("http://localhost:7474/db/data/", "neo4j", "altamura");

      return new GraphDatabaseFactory().newEmbeddedDatabase("/home/alex859/DevEnv/ciccio");
   }
}
