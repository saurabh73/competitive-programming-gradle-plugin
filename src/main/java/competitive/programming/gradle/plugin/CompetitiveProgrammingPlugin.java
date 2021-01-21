/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package competitive.programming.gradle.plugin;

import competitive.programming.tasks.ProblemBuildTask;
import competitive.programming.tasks.ProblemFileCreatorTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Saurabh Dutta <saurabh73>
 */
public class CompetitiveProgrammingPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getExtensions().create("competitiveProgramming", CompetitiveProgrammingExtension.class);
        project.getTasks().register("initProblem", ProblemFileCreatorTask.class);
        project.getTasks().register("buildSolution", ProblemBuildTask.class);
    }
}
