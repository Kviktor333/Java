public class FiniteAutomaton {
    enum State {
        S0, S1, S2, S3, F
    }

    public State recognize(String input) {
        State currentState = State.S0;
        for (char c : input.toCharArray()) {
            currentState = transition(currentState, c);
        }
        return currentState;
    }

    private State transition(State currentState, char inputChar) {
        switch (currentState) {
            case S0:
                if (inputChar == 'T') return State.S1;
                return State.S0;

            case S1:
                if (inputChar == 'E') return State.S2;
                if (inputChar == 'T') return State.S1;
                return State.S0;

            case S2:
                if (inputChar == 'S') return State.S3;
                if (inputChar == 'T') return State.S1;
                return State.S0;

            case S3:
                if (inputChar == 'T') return State.F;
                return State.S0;

            case F:
                return State.F; // Once in the final state, stay in F
        }
        return State.S0;
    }
}
