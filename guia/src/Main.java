import api.EstudiantesTDA;
import ejercicios.MetodosCola;
import ejercicios.MetodosConjunto;
import ejercicios.MetodosDiccionario;
import ejercicios.MetodosPila;
import impl.simulacros.EstudiantesDinamico;
import parcial.GestorDeReservas;
import parcial.GestorDeReservasTDA;

public class Main {
    public static void main(String[] args) throws Exception {

        GestorDeReservasTDA gestor = new GestorDeReservas();
        MetodosDiccionario dm = new MetodosDiccionario();
        MetodosConjunto conjunto = new MetodosConjunto();
        MetodosCola cola = new MetodosCola();
        MetodosPila pila = new MetodosPila();

        gestor.Inicializar();

        // se valida su creacion en los prints de los metodos
        gestor.agregarReserva(1, 99, 333, 4444);
        gestor.agregarReserva(2, 99, 777, 5555);
        gestor.agregarReserva(3, 99, 333, 4444);

        // al no encontrar al pasjero con id 3 en listarPorFecha() se valida que fue borrado
        gestor.eliminarReserva(3);

        gestor.actualizarAsiento(1, 111);

        gestor.actualizarVuelo(1, 88);

        gestor.actualizarFecha(1, 2222);

        // devuelve el puntero de su respectiva reserva
        System.out.println("obtener reserva: ");
        System.out.println(gestor.obtenerReserva(1));

        // parece que devuelve un vector pero solo es decoracion que uso en el metodo que cree.
        System.out.println("reservas por fecha:");
        conjunto.imprimir(gestor.reservasPorFecha(5555));

        System.out.println("listar por vuelo: ");
        dm.imprimir(gestor.listarPorVuelo());

        System.out.println("listar por fecha: ");
        dm.imprimir(gestor.listarPorVuelo());
    }
}

/*
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
 */