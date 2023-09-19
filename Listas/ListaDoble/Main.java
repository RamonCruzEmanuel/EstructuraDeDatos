package ListaDoble;

public class Main {

    public static void main(String[] args) {

        System.out.println("Lista doble");
        ListaDoblementeEnlazada lista2 = new ListaDoblementeEnlazada();

        lista2.insertar(5);
        lista2.insertar(59);
        lista2.insertar(91);
        lista2.insertar(-17);
        lista2.insertar(73);
        lista2.insertar(34);
        lista2.insertar(40);

        lista2.eliminar(2);
        lista2.eliminar(3);

        System.out.printf("Indice 3: %d\n", lista2.obtener(3));
    }

}
