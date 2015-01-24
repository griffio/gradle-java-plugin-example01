package griffio.gradle.apt;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JavaCompilerAnnotationProcessorPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks().create(JavaCompilerAnnotationProcessor.TASK_NAME, JavaCompilerAnnotationProcessor.class);
    }
}
