package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Used to dynamically load the avaje-ebeanorm-agent.
 * 
 * Alternatives: 
 * - Use IntelliJ or Eclipse plugins, 
 * - Rely on maven/ant enhancement (pain in dev, test cycle)
 * - Specify the java agent on the command line
 *
 */
public class ExampleBaseTestCase {

  protected static Logger logger = LoggerFactory.getLogger(ExampleBaseTestCase.class);
}
