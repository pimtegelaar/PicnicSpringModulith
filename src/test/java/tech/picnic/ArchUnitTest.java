package tech.picnic;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;

public class ArchUnitTest {
  @Test
  public void architectureTest() {
    JavaClasses classes = new ClassFileImporter().importPackages("tech.picnic");

    ArchRuleDefinition.noClasses()
        .that()
        .resideInAPackage("..picking")
        .should()
        .dependOnClassesThat()
        .resideInAPackage("..shortage")
        .check(classes);
  }
}
