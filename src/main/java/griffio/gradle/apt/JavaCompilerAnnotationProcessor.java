package griffio.gradle.apt;

import org.gradle.api.tasks.compile.JavaCompile;

public class JavaCompilerAnnotationProcessor extends JavaCompile {

    public static String TASK_NAME = "javaCompilerAnnotationProcessorTask";

    public JavaCompilerAnnotationProcessor() {
    }
}
