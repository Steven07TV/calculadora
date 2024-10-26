import java.util.Stack;

public class CalculadoraPostFija {

    public static double evaluarPostfija(String expresion) {
        Stack<Double> pila = new Stack<>();

        for (String token : expresion.split(" ")) {
            if (esOperador(token)) {
                double op2 = pila.pop();
                double op1 = pila.pop();

                // Realizar la operación en función del operador
                switch (token) {
                    case "+":
                        pila.push(op1 + op2);
                        break;
                    case "-":
                        pila.push(op1 - op2);
                        break;
                    case "*":
                        pila.push(op1 * op2);
                        break;
                    case "/":
                        pila.push(op1 / op2);
                        break;
                    case "^":
                        pila.push(Math.pow(op1, op2));
                        break;
                }
            } else {
                // Si es un número, lo convertimos a double y lo apilamos
                pila.push(Double.parseDouble(token));
            }
        }
        return pila.pop();
    }

    // Verifica si el token es un operador
    private static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }

    public static void main(String[] args) {
        // Expresión en notación postfija
        String expresionPostfija = "3 4 2 * 1 5 - 2 3 ^ ^ / +";

        System.out.println("Resultado: " + evaluarPostfija(expresionPostfija));
    }
}