package impl.grafos;

import api.ConjuntoTDA;
import api.GrafoTDA;
import impl.conjunto.ConjuntoDinamico;

public class GrafoEstatico implements GrafoTDA {

  static int n = 100;
  int [][] MAdy;
  int [] Etiqs;
  int cantNodos;

  public void inicializarGrafo() {
    MAdy = new int[n][n];
    Etiqs = new int[n];
    cantNodos = 0;
  }

  public void agregarVertice(int v) {

    Etiqs[cantNodos] = v;

    for (int i = 0; i <= cantNodos; i++) {
      MAdy[cantNodos][i] = 0;
      MAdy[i][cantNodos] = 0;
    }

    cantNodos++;
  }

  public void eliminarVertice(int v) {

    int indice = vert2Indice(v);

    for(int k = 0; k < cantNodos; k++){
      MAdy[k][indice] = MAdy[k][cantNodos - 1];
    }

    for(int k = 0; k < cantNodos; k++){
      MAdy[indice][k] = MAdy[cantNodos - 1][k];
    }

    Etiqs[indice] = Etiqs[cantNodos - 1];
    cantNodos--;
  }

  public ConjuntoTDA vertices() {
    
    ConjuntoTDA vert = new ConjuntoDinamico();
    vert.inicializarConjunto();

    for (int i = 0; i < cantNodos; i++) {
      vert.agregar(Etiqs[i]);
    }

    return vert;
  }

  public void agregarArista(int v1, int v2, int peso) {
    int o = vert2Indice(v1);
    int d = vert2Indice(v2);
    MAdy[o][d] = peso;
  }

  public void eliminarArista(int v1, int v2) {
    int o = vert2Indice(v1);
    int d = vert2Indice(v2);
    MAdy[o][d] = 0;
  }

  public boolean existeArista(int v1, int v2) {
    int o = vert2Indice(v1);
    int d = vert2Indice(v2);
    return MAdy[o][d] != 0;
  }

  public int pesoArista(int v1, int v2) {
    int o = vert2Indice(v1);
    int d = vert2Indice(v2);
    return MAdy[o][d];
  }

  private int vert2Indice(int v) {

    int i = cantNodos-1;

    while (i >= 0 && Etiqs[i] != v) {
      i--;
    }

    return i;
  }

}
