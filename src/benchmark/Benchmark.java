package benchmark;

import escenario1.Hospital;
import escenario2.Plataforma;
import escenario4.Ecommerce;

public class Benchmark {

    static final int[] TAMANOS = {100, 1_000, 10_000, 100_000};
    static final Runtime RT = Runtime.getRuntime();

    // Retorna memoria usada en KB después de forzar GC
    static long memoriaKB() {
        RT.gc();
        return (RT.totalMemory() - RT.freeMemory()) / 1024;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("  FASE 4 — Benchmarks Java Collections   ");
        System.out.println("==========================================\n");

        medirEscenario1();
        medirEscenario2();
        medirEscenario3();
        medirEscenario4();
    }

    // ── Escenario 1: Hospital ─────────────────────────────────────────
    static void medirEscenario1() {
        System.out.println("--- Escenario 1: Registro de Pacientes ---");
        System.out.printf("%-10s | %-14s | %-14s | %-14s | %-14s%n",
                "Tamaño", "Insertar (ms)", "Buscar (ms)", "Recorrer (ms)", "Memoria (KB)");
        System.out.println("-".repeat(75));

        for (int n : TAMANOS) {
            Hospital h = new Hospital();
            long memAntes = memoriaKB();

            long ini = System.nanoTime();
            for (int i = 0; i < n; i++) h.registrarPacientes(i, "Paciente-" + i, null, null);
            long tInsertar = (System.nanoTime() - ini) / 1_000_000;

            ini = System.nanoTime();
            for (int i = 0; i < n; i++) h.buscarPaciente(i);
            long tBuscar = (System.nanoTime() - ini) / 1_000_000;

            ini = System.nanoTime();
            for (escenario1.Paciente p : h.ordenLlegada) { String d = p.toString(); }
            long tRecorrer = (System.nanoTime() - ini) / 1_000_000;

            long memoria = memoriaKB() - memAntes;

            System.out.printf("%-10d | %-14d | %-14d | %-14d | %-14d%n",
                    n, tInsertar, tBuscar, tRecorrer, memoria);
        }
        System.out.println();
    }

    // ── Escenario 2: Ventas Masivas ───────────────────────────────────
    static void medirEscenario2() {
        System.out.println("--- Escenario 2: Plataforma de Ventas Masivas ---");
        System.out.printf("%-10s | %-14s | %-12s | %-16s | %-13s | %-12s%n",
                "Tamaño", "Insertar (ms)", "Buscar (ms)", "Mostrar ord.(ms)", "Filtrar (ms)", "Memoria (KB)");
        System.out.println("-".repeat(90));

        String[] cats = {"consola", "celular", "ropa", "hogar", "deportes"};

        for (int n : TAMANOS) {
            Plataforma plat = new Plataforma();
            long memAntes = memoriaKB();

            long ini = System.nanoTime();
            for (int i = 0; i < n; i++) plat.registrarProducto(i, i * 100.0, "Prod-" + i, cats[i % 5]);
            long tInsertar = (System.nanoTime() - ini) / 1_000_000;

            ini = System.nanoTime();
            for (int i = 0; i < n; i++) plat.buscarProducto(i);
            long tBuscar = (System.nanoTime() - ini) / 1_000_000;

            ini = System.nanoTime();
            for (escenario2.Producto prod : plat.ordenarProductoPrecio) { String d = prod.toString(); }
            long tOrdenado = (System.nanoTime() - ini) / 1_000_000;

            java.io.PrintStream out = System.out;
            System.setOut(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));
            ini = System.nanoTime();
            plat.filtrarCategoria("consola");
            long tFiltrar = (System.nanoTime() - ini) / 1_000_000;
            System.setOut(out);

            long memoria = memoriaKB() - memAntes;

            System.out.printf("%-10d | %-14d | %-12d | %-16d | %-13d | %-12d%n",
                    n, tInsertar, tBuscar, tOrdenado, tFiltrar, memoria);
        }
        System.out.println();
    }

    // ── Escenario 3: Taxis ────────────────────────────────────────────
    static void medirEscenario3() {
        System.out.println("--- Escenario 3: Plataforma de Solicitud de Taxis ---");
        System.out.printf("%-10s | %-15s | %-17s | %-14s | %-12s%n",
                "Tamaño", "Registrar (ms)", "Atender n/2 (ms)", "Cancelar (ms)", "Memoria (KB)");
        System.out.println("-".repeat(78));

        for (int n : TAMANOS) {
            escenario3.Plataforma p = new escenario3.Plataforma();
            long memAntes = memoriaKB();

            long ini = System.nanoTime();
            for (int i = 0; i < n; i++) p.registrarViajes(i, "Usuario-" + i, "Destino-" + i);
            long tRegistrar = (System.nanoTime() - ini) / 1_000_000;

            ini = System.nanoTime();
            for (int i = 0; i < n / 2; i++) p.atenderPrimero();
            long tAtender = (System.nanoTime() - ini) / 1_000_000;

            java.io.PrintStream out = System.out;
            System.setOut(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));
            ini = System.nanoTime();
            p.cancelarSolicitud(n / 2 + n / 4);
            long tCancelar = (System.nanoTime() - ini) / 1_000_000;
            System.setOut(out);

            long memoria = memoriaKB() - memAntes;

            System.out.printf("%-10d | %-15d | %-17d | %-14d | %-12d%n",
                    n, tRegistrar, tAtender, tCancelar, memoria);
        }
        System.out.println();
    }

    // ── Escenario 4: E-commerce ───────────────────────────────────────
    static void medirEscenario4() {
        System.out.println("--- Escenario 4: Catálogo E-commerce ---");
        System.out.printf("%-10s | %-14s | %-12s | %-17s | %-12s%n",
                "Tamaño", "Insertar (ms)", "Buscar (ms)", "Mostrar ord. (ms)", "Memoria (KB)");
        System.out.println("-".repeat(75));

        for (int n : TAMANOS) {
            Ecommerce e = new Ecommerce();
            long memAntes = memoriaKB();

            java.io.PrintStream out = System.out;
            System.setOut(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));
            long ini = System.nanoTime();
            for (int i = 0; i < n; i++) e.registrarProductos(i, i * 500.0, "Producto-" + i);
            long tInsertar = (System.nanoTime() - ini) / 1_000_000;
            System.setOut(out);

            ini = System.nanoTime();
            for (int i = 0; i < n; i++) e.buscarProductos(i);
            long tBuscar = (System.nanoTime() - ini) / 1_000_000;

            ini = System.nanoTime();
            for (escenario4.Producto prod : e.ordenPrecio) { String d = prod.toString(); }
            long tMostrar = (System.nanoTime() - ini) / 1_000_000;

            long memoria = memoriaKB() - memAntes;

            System.out.printf("%-10d | %-14d | %-12d | %-17d | %-12d%n",
                    n, tInsertar, tBuscar, tMostrar, memoria);
        }
        System.out.println();
    }
}