package org.alex859.milantransit4j;

import org.alex859.milantransit4j.service.RouteImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Component
public class MilanTransit4jCommandLineRunner implements CommandLineRunner
{
   @Autowired
   private RouteImporter routeImporter;

   @Override
   public void run(final String... args) throws Exception
   {
      routeImporter.importRoute();
   }
}
