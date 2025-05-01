import java.util.PriorityQueue;

public class Sala implements Comparable<Sala> {
    private int id;
    private final int capacidad = 25;
    private int asientosv;
    private int asientosd;
    private PriorityQueue<Integer> asientosDisponibles;


    public Sala(int id) {
        this.id = id;
        this.asientosv = 0;
        this.asientosd = capacidad;
        this.asientosDisponibles = new PriorityQueue<>();
        for (int i = 1; i <= capacidad; i++) {
            asientosDisponibles.add(i);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getAsientosVendidos() {
        return asientosv;
    }

    public void setAsientosVendidos(int asientosv) {
        this.asientosv = asientosv;
    }

    public int getAsientosDisponibles() {
        return asientosd;
    }

    public void setAsientosDisponibles(int asientosd) {
        this.asientosd = asientosd;
    }


    public boolean comprarAsientos(int cantidad) {
        if (cantidad < 1 || cantidad > 4) {
            System.out.println("No se puede comprar más de 4 asientos");
            return false;
        }

        if (asientosDisponibles.size() < cantidad) {
            System.out.println("Insuficiencia de asientos disponibles.");
            return false;
        }

        System.out.print("Asientos asignados: ");
        for (int i = 0; i < cantidad; i++) {
            int asiento = asientosDisponibles.poll();
            System.out.print(asiento + " ");
            asientosv++;
            asientosd--;
        }
        System.out.println();
        return true;
    }


    public void mostrarDisponibilidad() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Sala numero:  " + id + ": " + "Los asientos disponibles son: "+ asientosd + "   :   " + "Los asientos vendidos son: " + asientosv;
    }

    @Override
    public int compareTo(Sala otraSala) {
        return Integer.compare(this.asientosd, otraSala.asientosd);
    }
}

