import java.util.function.Predicate;

public class Lista {
  private Nodo inicio;

  public Lista() {
    inicio = null;
  }

  public void unshift(int dato) {
    Nodo nuevo = new Nodo(dato);
    if (inicio == null) {
      inicio = nuevo;
    } else {
      nuevo.siguiente = inicio;
      inicio = nuevo;
    }
  }

  public void push(int dato) {
    Nodo nuevo = new Nodo(dato);
    if (inicio == null) {
      inicio = nuevo;
    } else {
      Nodo actual = inicio;
      while (actual.siguiente != null) {
        actual = actual.siguiente;        
      }
      actual.siguiente = nuevo;
    }
  }

  public void print() {
    Nodo actual = inicio;
    while (actual != null) {
      System.out.print("---> ");
      System.out.print(actual.dato + " \n");
      actual = actual.siguiente;
    }
    System.out.println();
  }

  public void deleteFirstWhere(Predicate<Nodo> condicion) {
    if (inicio == null) {
      return;
    }
    
    if (condicion.test(inicio)) {
      inicio = inicio.siguiente;
      return;
    }

    Nodo actual = inicio;
    Nodo anterior = null;

    while (actual != null && !condicion.test(actual)) {
      anterior = actual;
      actual = actual.siguiente;      
    }

    if (actual != null) {
      anterior.siguiente = actual.siguiente;
    }
  }

  public void sort() {
    if (inicio == null) {
      return;
    }

    Nodo actual = inicio;
    Nodo siguiente = actual.siguiente;

    while (actual != null) {
      while (siguiente != null) {
        if (actual.dato > siguiente.dato) {
          int aux = actual.dato;
          actual.dato = siguiente.dato;
          siguiente.dato = aux;
        }
        siguiente = siguiente.siguiente;
      }
      actual = actual.siguiente;
      if (actual != null) {
        siguiente = actual.siguiente;
      }
    }
  }
}
