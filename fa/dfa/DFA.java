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
        return states.add(newState);
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
        alphabet.add(symbol);
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
        var state = new DFAState(name);
        if (states.contains(state)){
            return state;
        }
        return null;
    }

    @Override
    public boolean isFinal(String name) {
        return finalStates.contains(new DFAState(name));
    }

    @Override
    public boolean isStart(String name) {
        return initialState.equals(new DFAState(name));
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        var fromDFAState = new DFAState(fromState);
        var toDFAState = new DFAState(toState);
        if (!alphabet.contains(onSymb) || !states.contains(fromDFAState) || !states.contains(toDFAState)){
            return false;
        }
        
        if (!transitions.containsKey(fromDFAState)){
            transitions.put(fromDFAState, new HashMap<>());
        }
        transitions.get(fromDFAState).put(onSymb, toDFAState);
        return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }
    
}