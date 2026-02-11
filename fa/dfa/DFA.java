package fa.dfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fa.State;

/**
 * Uses HashSet to represent sets, and HashMaps to represent maps, using 
 * 
 * @author Leo Haener-Pope, Lucas Coltrin
 */
public class DFA implements DFAInterface{

    // All of the 5-tuple is stored in the DFA Object as we use HashSets (immutable) for storing states
    // Meaning the states can't have their own different values changed.
    private Set<Character> alphabet;
    private Set<State> states; // stores DFAStates
    private State initialState;
    private Set<State> finalStates;
    private Map<State, Map<Character, State>> transitions;

    public DFA() {
        this.alphabet = new HashSet<>();
        this.states = new HashSet<>();
        this.initialState = null;
        this.finalStates = new HashSet<>();
        this.transitions = new HashMap<>();
    }

    @Override
    public boolean addState(String name) {
        State newState = new DFAState(name);
        if (!states.contains(newState)) {
            states.add(newState);
            return true;
        }
        return false;
    }

    @Override
    public boolean setFinal(String name) {
        State state = new DFAState(name);
        if (states.contains(state)){
            finalStates.add(state);
            return true;
        }
        return false;
    }

    @Override
    public boolean setStart(String name) {
        State newInitialState = new DFAState(name);
        if (states.contains(newInitialState)) {
            initialState = newInitialState;
            return true;
        }
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSigma'");
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    @Override
    public Set<Character> getSigma() {
        return alphabet;
    }

    @Override
    public State getState(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }

    @Override
    public boolean isFinal(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFinal'");
    }

    @Override
    public boolean isStart(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isStart'");
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }
    
}