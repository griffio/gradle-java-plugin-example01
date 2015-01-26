package griffio.gradle.apt;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JavaCompilerAnnotationProcessorPluginTest {

    private Project project;

    @Before
    public void setupProject() {
        project = ProjectBuilder.builder().build();
    }

    @Test
    public void applyPlugin() {
        JavaCompilerAnnotationProcessorPlugin plugin = project.getPlugins().apply(JavaCompilerAnnotationProcessorPlugin.class);
        Assert.assertNotNull(plugin);
    }

    @Test
    public void applyInitTask() throws Exception {
        JavaCompilerAnnotationProcessor task = project.getTasks().create(JavaCompilerAnnotationProcessor.TASK_NAME, JavaCompilerAnnotationProcessor.class);
        Assert.assertNotNull(task);
    }

    @Test
    public void isAptSourceSetConfigured() throws Exception {
        JavaCompilerAnnotationProcessor task = project.getTasks().create(JavaCompilerAnnotationProcessor.TASK_NAME, JavaCompilerAnnotationProcessor.class);
    }
}