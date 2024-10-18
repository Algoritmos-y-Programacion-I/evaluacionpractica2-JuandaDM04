package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {
        control = new Controller();
        reader = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Executable exe = new Executable();
        exe.menu();
    }
    
    /** 
     * Descripción: Despliega el menú principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {
            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pilar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. ¡Adiós!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente");
                    break;
            }

        } while (flag);
    }

    /** 
     * Descripción: Solicita al usuario la información necesaria para registrar un Project 
     * en un Pilar en el sistema
    */
    public void registerProject() {
        reader.nextLine();

        System.out.println("Ingrese el nombre del proyecto:");
        String name = reader.nextLine();

        System.out.println("Ingrese el ID del proyecto:");
        String id = reader.nextLine();

        System.out.println("Ingrese la descripción del proyecto:");
        String description = reader.nextLine();

        System.out.println("El proyecto está activo? (true/false):");
        boolean status = reader.nextBoolean();

        System.out.println("Seleccione el Pilar (0: Biodiversidad, 1: Agua, 2: Tratamiento de Basuras, 3: Energía):");
        int pillar = reader.nextInt();

        boolean success = control.registerProjectInPillar(pillar, status, name, id, description);
        if (success) {
            System.out.println("Proyecto registrado exitosamente.");
        } else {
            System.out.println("No se pudo registrar el proyecto. Verifique que haya espacio en el pilar.");
        }
    }

    /** 
     * Descripción: Muestra al usuario los Projects registrados en un Pilar 
    */
    public void showProjectsByPillar() {
        System.out.println("Seleccione el Pilar (0: Biodiversidad, 1: Agua, 2: Tratamiento de Basuras, 3: Energía):");
        int pillar = reader.nextInt();
        reader.nextLine();

        String result = control.queryProjectsByPillar(pillar);
        System.out.println(result);
    }
}
