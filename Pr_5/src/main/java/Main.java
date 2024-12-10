public class Main {
    public static void main(String[] args) {
        FiniteAutomaton fa = new FiniteAutomaton();

        String[] testStrings = {
                "abcTESTabc",
                "abcTES",
                "TTESTT",
                "TEST",
                "T",
                "TST",
                "TEEST"
        };

        for (String input : testStrings) {
            FiniteAutomaton.State result = fa.recognize(input);
            System.out.println("Input: " + input + " => State: " + result);
        }
    }
}
