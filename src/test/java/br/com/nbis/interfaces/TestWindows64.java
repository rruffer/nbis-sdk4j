package br.com.nbis.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@Test
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EnabledOnOs(OS.WINDOWS)
@EnabledIfSystemProperty(named="os.arch", matches=".*64.*")
public @interface TestWindows64 {

}
