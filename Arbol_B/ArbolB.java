package Arbol_B;

public class ArbolB {
    NodoArbolB root;
    int t;

    // Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
    }

    public int buscarClaveMayor() {
        int claveMaxima = getClaveMayor(this.root);

        return claveMaxima;
    }

    private int getClaveMayor(NodoArbolB current) {
        if (current == null) {
            return 0;// Si es cero no existe
        }

        // Mientras no sea una hoja
        while (!current.leaf) {
            // Se accede al hijo mas a la derecha
            current = current.child[current.n];
        }

        return claveMayorPorNodo(current);
    }

    private int claveMayorPorNodo(NodoArbolB current) {
        // Devuelve el valor mayor, el que esta mas a la derecha
        return current.key[current.n - 1];
    }

    public void mostrarClavesNodoMinimo() {
        NodoArbolB temp = buscarNodoMinimo(root);

        if (temp == null) {
            System.out.println("Sin minimo");
        } else {
            temp.imprimir();
        }
    }

    public NodoArbolB buscarNodoMinimo(NodoArbolB nodoActual) {
        if (root == null) {
            return null;
        }

        NodoArbolB aux = root;

        // Mientras no sea una hoja
        while (!aux.leaf) {
            // Se accede al primer hijo
            aux = aux.child[0];
        }

        // Devuelve el nodo menor, el que esta mas a la izquierda
        return aux;
    }

    // Busca el valor ingresado y muestra el contenido del nodo que contiene el
    // valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0;// se empieza a buscar siempre en la primera posicion

        // Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        // Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        // Si llegamos hasta aqui, entonces hay que buscar los hijos
        // Se revisa primero si tiene hijos
        if (actual.leaf) {
            return null;
        } else {
            // Si tiene hijos, hace una llamada recursiva
            return search(actual.child[i], key);
        }
    }

    public void insertar(int key) {
        NodoArbolB r = root;

        // Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }

    private void split(NodoArbolB x, int i, NodoArbolB y) {
        // Nodo temporal que sera el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(t);
        z.leaf = y.leaf;
        z.n = (t - 1);

        // Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z // z =
        // |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        // Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }

        // nuevo tamanio de y
        y.n = (t - 1);
        for (int j = x.n; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }

        x.child[(i + 1)] = z;

        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        x.key[i] = y.key[(t - 1)];
        x.n++;
    }

    private void nonFullInsert(NodoArbolB x, int key) {
        // Si es una hoja
        if (x.leaf) {
            int i = x.n; // cantidad de valores del nodo
            // busca la posicion i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1];// Desplaza los valores mayores a key
                i--;
            }

            x.key[i] = key;// asigna el valor al nodo
            x.n++; // aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            // Busca la posicion del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            // Si el nodo hijo esta lleno lo separa
            if (x.child[j].n == (2 * t - 1)) {
                split(x, j, x.child[j]);

                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.child[j], key);
        }
    }

    public void showBTree() {
        print(root);
    }

    // Print en preorder
    private void print(NodoArbolB n) {
        n.imprimir();

        // Si no es hoja
        if (!n.leaf) {
            // recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }

    public void eliminar(int key) {
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
    
        // Llama a un método auxiliar para realizar la eliminación
        eliminarClave(root, key);
    
        // Si la raíz se queda sin claves, asigna el primer hijo como nueva raíz
        if (root.n == 0 && !root.leaf) {
            root = root.child[0];
        }
    }
    
    private void eliminarClave(NodoArbolB actual, int key) {
        int index = actual.find(key); // Busca la clave en el nodo actual
    
        if (index != -1) { // La clave está presente en este nodo
            if (actual.leaf) {
                eliminarDeHoja(actual, index); // Elimina la clave si el nodo es una hoja
            } else {
                eliminarDeNoHoja(actual, index); // Elimina la clave si el nodo no es una hoja
            }
        } else {
            // Si no se encontró la clave en este nodo, busca en los nodos hijos
            int i = 0;
            while (i < actual.n && key > actual.key[i]) {
                i++;
            }
    
            if (i < actual.n) {
                // El nodo hijo donde podría estar la clave a eliminar
                NodoArbolB hijo = actual.child[i];
                if (hijo.n >= t) {
                    eliminarClave(hijo, key); // Si el hijo tiene suficientes claves, realiza la eliminación
                } else {
                    fusionarHijos(actual, i); // Fusiona el hijo con su hermano si no tiene suficientes claves
                    eliminarClave(actual.child[i], key); // Llama recursivamente para eliminar la clave después de la fusión
                }
            } else {
                // Si la clave podría estar en el último hijo, busca en él
                NodoArbolB ultimoHijo = actual.child[i - 1];
                if (ultimoHijo.n >= t) {
                    eliminarClave(ultimoHijo, key); // Si tiene suficientes claves, realiza la eliminación
                } else {
                    fusionarHijos(actual, i - 1); // Fusiona el hijo con su hermano si no tiene suficientes claves
                    eliminarClave(actual.child[i - 1], key); // Llama recursivamente para eliminar la clave después de la fusión
                }
            }
        }
    }
    
    private void eliminarDeHoja(NodoArbolB nodo, int index) {
        // Desplaza las claves para eliminar la clave específica
        for (int i = index; i < nodo.n - 1; i++) {
            nodo.key[i] = nodo.key[i + 1];
        }
        nodo.n--; // Disminuye el número de claves en el nodo
    }
    
    private void eliminarDeNoHoja(NodoArbolB nodo, int index) {
        int k = nodo.key[index];
    
        // Si el hijo izquierdo del nodo tiene al menos t claves
        if (nodo.child[index].n >= t) {
            int predecesor = obtenerPredecesor(nodo, index);
            nodo.key[index] = predecesor;
            eliminarClave(nodo.child[index], predecesor);
        } else if (nodo.child[index + 1].n >= t) {
            // Si el hijo derecho del nodo tiene al menos t claves
            int sucesor = obtenerSucesor(nodo, index);
            nodo.key[index] = sucesor;
            eliminarClave(nodo.child[index + 1], sucesor);
        } else {
            // Si ambos hijos tienen menos de t claves, fusiona el hijo con su hermano
            fusionarHijos(nodo, index);
            eliminarClave(nodo.child[index], k); // Elimina la clave del nodo padre después de la fusión
        }
    }
    
    
    private int obtenerPredecesor(NodoArbolB nodo, int index) {
        NodoArbolB actual = nodo.child[index];
        while (!actual.leaf) {
            actual = actual.child[actual.n];
        }
        return actual.key[actual.n - 1];
    }
    
    private int obtenerSucesor(NodoArbolB nodo, int index) {
        NodoArbolB actual = nodo.child[index + 1];
        while (!actual.leaf) {
            actual = actual.child[0];
        }
        return actual.key[0];
    }
    
    private void fusionarHijos(NodoArbolB nodo, int index) {
        NodoArbolB hijo = nodo.child[index];
        NodoArbolB hermano = nodo.child[index + 1];
    
        // Mueve la clave del nodo al hijo
        hijo.key[t - 1] = nodo.key[index];
    
        // Copia las claves del hermano a hijo
        for (int i = 0; i < hermano.n; i++) {
            hijo.key[i + t] = hermano.key[i];
        }
    
        // Si no es hoja, también copia los hijos del hermano a hijo
        if (!hijo.leaf) {
            for (int i = 0; i <= hermano.n; i++) {
                hijo.child[i + t] = hermano.child[i];
            }
        }
    
        // Mueve las claves y los hijos en el nodo para llenar el espacio del eliminado
        for (int i = index + 1; i < nodo.n; i++) {
            nodo.key[i - 1] = nodo.key[i];
        }
        for (int i = index + 2; i <= nodo.n; i++) {
            nodo.child[i - 1] = nodo.child[i];
        }
    
        // Actualiza el número de claves en el hijo
        hijo.n += hermano.n + 1;
    
        // Disminuye el número de claves en el nodo
        nodo.n--;
    
        // Actualiza la referencia al hijo fusionado
        nodo.child[index] = hijo;
    }
    
    
    
        
}
