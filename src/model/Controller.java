package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {
        // Inicializamos los 4 pilares con sus respectivos nombres
        pillars = new Pillar[4];
        pillars[0] = new Pillar("Biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Tratamiento de Basuras");
        pillars[3] = new Pillar("Energía");
    }

    /**
     * Descripción: Permite crear y añadir un Project en un Pilar en el sistema
     * 
     * @param pillarType  El número del Pilar (0: Biodiversidad, 1: Agua, 2: Tratamiento de Basuras, 3: Energía)
     * @param id          ID del proyecto
     * @param name        Nombre del proyecto
     * @param description Descripción del proyecto
     * @param status      Estado del proyecto (activo o inactivo)
     * @return boolean true si se logra añadir el Project en el Pilar, false en caso contrario
     */
    public boolean registerProjectInPillar(int pillarType, boolean status, String name, String id, String description) {
        if (pillarType >= 0 && pillarType < 4) {
            Project project = new Project(id, name, description, status);
            return pillars[pillarType].registerProject(project);
        }
        return false;
    }

    /**
     * Descripción: Retorna la información de los Projects registrados en un Pilar
     * @param pillarType El número del Pilar (0: Biodiversidad, 1: Agua, 2: Tratamiento de Basuras, 3: Energía)
     * @return String Cadena con el listado de proyectos del pilar seleccionado
     */
    public String queryProjectsByPillar(int pillarType) {
        if (pillarType >= 0 && pillarType < 4) {
            return pillars[pillarType].getProjectList();
        }
        return "Pilar no válido."; // Si el tipo de pilar es inválido, devolvemos un mensaje de error
    }
}
