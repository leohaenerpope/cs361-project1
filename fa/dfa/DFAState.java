package fa.dfa;

import java.util.Objects;

import fa.State;

/**
 * Extends the State class, uses super() for the constructor.
 * 
 * Contains the equals and hashCode override function for comparison handling
 * between DFAStates, compares names. Unfortunately, since we use HashSets, we cannot
 * change the values of DFAStates after they have been added to any of the maps in DFA.java
 * 
 * Thus, these are the only things that DFAState.java contains, everything else is handled in DFA.java
 * 
 * @author Leo Haener-Pope, Lucas Coltrin
 */
public class DFAState extends State {

    public DFAState(String name){
        super(name);
    }

    /**
     * Overrides for equals to make contains() function nicely work for HashSet
     * 
     * @param obj the DFAState to be compared
     * @return true if string names are same
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false; // make sure obj isn't null and matches class
        if (this == obj) return true; // check memory location real quick

        DFAState dfaState = (DFAState) obj; //turn obj into dfaState object
        return getName().equals(dfaState.getName()); //using getName function from base State in DFAState to compare
    }

    /**
     * Java makes you override hashCode() function too or else equals override with HashSets may not work correctly,
     * this function basically does nothing.
     * 
     * @return hashCode for object in set
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
