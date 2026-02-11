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

    private Set<Character> alphabet;
    private Set<State> states; // stores DFAStates
    private State initialState;
    // Final states are stored in individual DFAStates as a boolean value isFinalState
    // Transitions are specified in individual DFAStates

    public DFA() {
        this.alphabet = new HashSet<>();
        this.states = new HashSet<>();
        this.initialState = null;
    }

    @Override
    public boolean addState(String name) {
        for (State state: states){
            if (state.getName().equals(name)) {
                return false;
            }
        }
        states.add(new DFAState(name));
        return true;
    }

    @Override
    public boolean setFinal(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFinal'");
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