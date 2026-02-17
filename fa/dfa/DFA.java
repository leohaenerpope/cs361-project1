package fa.dfa;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import fa.State;

/**
 * Represents a Definite Finite Automaton, where each DFA state can have a transition pertaining to
 * each letter in the sigma, but no more than one per character.
 * 
 * Uses LinkedHashSet to represent sets, and HashMaps (map<key, map<key, value>>) to represent maps.
 * HashSets are Linked as the toString requires order they were added in to function correctly with DFATest.java
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
        this.alphabet = new LinkedHashSet<>();
        this.states = new LinkedHashSet<>();
        this.initialState = null;
        this.finalStates = new LinkedHashSet<>();
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
        if (initialState == null){
            return false; // Makes sure initial state has been set
        }
        var curState = initialState;
        for (int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if (!alphabet.contains(character)){
                return false; // Makes sure character is inside Sigma
            }

            if (transitions.containsKey(curState) && transitions.get(curState).containsKey(character)){
                curState = transitions.get(curState).get(character); // checks transition map for correct state: character: state
            } else {
                return false;
            }

            if (i == s.length()-1){ // checks if state is final, for last i
                if (isFinal(curState.getName())){
                    return true;
                }
                return false;
            }
        }
        return false; // should never reach here
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
            return false; // if not alphabet character or not state for either, return false
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

    /**
     * Helpful function for printing out the 5-tuple of the DFA
     * 
     * @return string output, matching the DFATest.java tests for toString
     */
    public String toString() {
        String retString = "Q = { "; // states first
        for (State state : states){
            retString += state.toString() + " ";
        }
        retString += "}\nSigma = { "; // now the alphabet
        for (char character : alphabet){
            retString += character + " ";
        }

        retString += "}\ndelta =\n "; // now print transition table
        for (char character : alphabet){
            retString += "\t" + character;
        }
        retString += "\n";
        for (State state : states){
            
            retString += state.toString() + " ";
            for (char character : alphabet){
                retString += "\t";
                if (transitions.get(state).containsKey(character)){
                    retString += transitions.get(state).get(character).toString();
                } else{
                    retString += " ";
                }
            }
            retString += "\n";
        }

        retString += "q0 = " + initialState.toString(); // print initial state
        retString += "\nF = { "; // and lastly, print final states
        for (State state : finalStates){
            retString += state.toString() + " ";
        }
        retString += "}\n";

        return retString;
    }
    
}