package griffio.gradle.apt;

import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.PublishArtifact;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.file.FileCollection;
import org.gradle.api.plugins.JavaPlugin;

public class JavaCompilerAnnotationProcessorConfiguration {

    public static final String COMPILE_CONFIGURATION = "apt";


    public JavaCompilerAnnotationProcessorConfiguration(ConfigurationContainer configurations, DependencyHandler dependencyHandler) {
    }



}