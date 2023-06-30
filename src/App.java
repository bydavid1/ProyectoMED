import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();

        // Insertar datos de prueba a la lista
        for (int i = 0; i < 10; i++) {
            lista.push(i * 3 + 1);
        }

        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            do {
                System.out.println("1. Agregar al inicio");
                System.out.println("2. Agregar al final");
                System.out.println("3. Eliminar");
                System.out.println("4. Ordenar");
                System.out.println("5. Imprimir");
                System.out.println("6. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                
                System.out.print("\033[H\033[2J");

                switch (opcion) {
                    case 1:
                        System.out.print("Dato: ");
                        int dato = sc.nextInt();
                        lista.unshift(dato);
                        break;
                    case 2:
                        System.out.print("Dato: ");
                        dato = sc.nextInt();
                        lista.push(dato);
                        break;
                    case 3:
                        System.out.print("Dato a eliminar: ");
                        dato = sc.nextInt();
                        lista.deleteFirstWhere(n -> n.dato == dato);
                        break;
                    case 4:
                        lista.sort();
                        lista.print();
                        break;
                    case 5:
                        lista.print();
                        break;
                    case 6:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } while (opcion != 6);
        }
    }
}
