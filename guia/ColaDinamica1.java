package impl.colas;

import api.ColaTDA;
import impl.nodos.Nodo;

public class ColaDinamica1 implements ColaTDA {
    /* estrategia 1 de cola dinámica DEFAULT, los Nodos apuntan para atrás, siendo el último el que apunta a null */
    // atributes
    Nodo primero;
    Nodo ultimo;
    // methods
    public void inicializarCola() {
        primero = null;
        ultimo = null;
    }
    public void acolar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        if (primero==null) {
            primero = aux;
            ultimo = aux;
        } else {
            ultimo.sig = aux;
            ultimo = aux;
        }
    }
    public void desacolar() {
        if (primero != null) {
            primero = primero.sig;
            if (primero == null) {
                ultimo = null;
            }
        }
    }
    public int primero() {
        return (primero.info);
    }
    public boolean colaVacia() {
        return (primero==null);
    }
    public String printCola() {
        Nodo actual = primero;
        String txt="";
        while (actual != null) {
            txt+=actual.info + " ";
            actual = actual.sig;
        }
        return txt;
    }
                //menor a mayor
    public void ordenarBurbujeo() {
        if (primero == null || primero.sig == null) {
            return;
        }

        Nodo end = null;
        while (end != primero) {
            Nodo actual = primero;
            Nodo anterior = null;

            while (actual.sig != end) {
                Nodo siguiente = actual.sig;

                if (actual.info > siguiente.info) {

                    if (anterior != null) {
                        Nodo temp = siguiente.sig;
                        anterior.sig = siguiente;
                        siguiente.sig = actual;
                        actual.sig = temp;
                    } else {
                        Nodo temp = siguiente.sig;
                        primero = siguiente;
                        siguiente.sig = actual;
                        actual.sig = temp;
                    }


                    anterior = siguiente;
                } else {

                    anterior = actual;
                    actual = siguiente;
                }
            }
            end = actual;
        }
    }
}