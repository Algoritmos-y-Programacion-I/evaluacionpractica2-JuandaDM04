package model;

public class Pillar {

    private String name;
    private Project[] projects;
    private int projectCount;

    public Pillar(String name) {
        this.name = name;
        projects = new Project[50]; 
        projectCount = 0; 
    }

    /**
     * Descripción: Añade un nuevo Project al arreglo projects
     * pre: El arreglo projects debe estar inicializado
     * pos: El arreglo projects queda modificado con el nuevo Project agregado
     * 
     * @param newProject Project El Project que se va a añadir
     * @return boolean true si se logra añadir el Project, false en caso contrario
     */
    public boolean registerProject(Project newProject) {
        if (projectCount < projects.length) {
            projects[projectCount] = newProject;
            projectCount++; 
            return true;
        }
        return false; 
    }

    /**
     * Descripción: Genera una cadena en formato lista con la información de los
     * Project registrados en el Pilar
     * pre: El arreglo projects debe estar inicializado
     * 
     * @return String Una cadena con la lista de proyectos del Pilar
     */
    public String getProjectList() {
        if (projectCount == 0) {
            return "No hay proyectos registrados en este pilar.";
        }

        StringBuilder list = new StringBuilder("Proyectos en el Pilar " + name + ":\n");

        for (int i = 0; i < projectCount; i++) {
            Project project = projects[i];
            list.append("- Nombre: ").append(project.getName())
                .append(", ID: ").append(project.getId())
                .append(", Estado: ").append(project.isActive() ? "Activo" : "Inactivo")
                .append("\n");
        }

        return list.toString();
    }

}
