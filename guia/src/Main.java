import api.EstudiantesTDA;
import ejercicios.MetodosPila;
import impl.simulacros.EstudiantesDinamico;

public class Main {
    public static void main(String[] args) throws Exception {

        MetodosPila m = new MetodosPila();
        EstudiantesTDA l = new EstudiantesDinamico();

        l.agregarAlumno(2002, 8);
        l.agregarAlumno(2002, 6);
        l.agregarAlumno(2002, 10);

        l.agregarAlumno(1999, 4);
        l.agregarAlumno(1999, 2);        
        
        l.agregarAlumno(2001, 4);
        l.agregarAlumno(2001, 2);

        l.eliminarAlumno(1999);

        System.out.print("notas 2002: ");
        m.imprimirPila(l.notas(2002));

        System.out.print("promedio 2002: ");
        System.out.println(l.promedioNotasAlumno(2002));

        System.out.print("aprobo 2002: ");
        System.out.println(l.aprobo(2002));

        System.out.print("aprobo 2001: ");
        System.out.println(l.aprobo(2001));
        
        l.imprimir();
    }
}

/*
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
 */