/*
 * Łukasz Kapica
 * Tutaj startuje nasza aplikacja.
 * Funkcja main ma za zadanie wywołać główne okno edytora.
 */

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MainWindow());
    }
}
