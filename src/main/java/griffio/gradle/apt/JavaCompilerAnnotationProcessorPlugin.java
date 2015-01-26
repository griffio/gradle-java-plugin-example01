package griffio.gradle.apt;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.ResolvableDependencies;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.compile.JavaCompile;

import java.util.List;

public class JavaCompilerAnnotationProcessorPlugin implements Plugin<Project> {

    private Project project;

    @Override
    public void apply(Project project) {
        this.project = project;
        applyJavaPlugin();
        createAptConfiguration();
        createAnnotationProcessorTask();
        configureApt();
    }

    private void createAnnotationProcessorTask() {
        this.project.getExtensions().create("annotationProcessor", JavaCompilerAnnotationProcessorExtension.class);
        project.getTasks().create(JavaCompilerAnnotationProcessor.TASK_NAME, JavaCompilerAnnotationProcessor.class);
    }

    private void applyJavaPlugin() {
        if (!this.project.getPlugins().hasPlugin(JavaPlugin.class)) {
            this.project.getPlugins().apply(JavaPlugin.class);
            this.project.getLogger().info("applied java plugin");
        }
    }

    private void createAptConfiguration() {
        final Configuration configuration = this.project.getConfigurations()
                .create("annotationProcessorProvided")
                .setDescription("annotation processor provided to compilation")
                .setVisible(false)
                .setTransitive(true);

        final Dependency querydslDependency = this.project.getDependencies().create("com.mysema.querydsl:querydsl-apt:3.6.0");

        configuration.getIncoming().beforeResolve(new Action<ResolvableDependencies>() {
            @Override
            public void execute(ResolvableDependencies resolvableDependencies) {
                if (configuration.getDependencies().isEmpty()) {
                    configuration.getDependencies().add(querydslDependency);
                }
            }
        });

    }

    private void configureApt() {
          JavaPluginConvention javaConvention = project.getConvention().getPlugin(JavaPluginConvention.class);
          Configuration aptConfiguration = project.getConfigurations().getByName("annotationProcessorProvided");
          JavaCompile javaCompile = (JavaCompile) project.getTasks().getByName(JavaPlugin.COMPILE_JAVA_TASK_NAME);
          javaCompile.setClasspath(aptConfiguration.getAsFileTree());
          List<String> compilerArgs = javaCompile.getOptions().getCompilerArgs();
//        compilerArgs.add("-processorpath");
//        compilerArgs.add(aptConfiguration.getAsPath());
          compilerArgs.add("-processor");
          compilerArgs.add("com.mysema.query.apt.QuerydslAnnotationProcessor");
          compilerArgs.add("-s");
          compilerArgs.add(javaConvention.getSourceSets().getByName("main").getJava().getSrcDirs().iterator().next().getAbsolutePath());
    }

}