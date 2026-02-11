package fa.dfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import fa.State;

/**
 * @author Leo Haener-Pope, Lucas Coltrin
 */
public class DFAState extends State {

    public DFAState(String name){
        super(name);
    }

    // Overrides for equals to make contains() function nicely work for HashSet
    // Java makes you override hashCode() function too or else equals override may not work correctly

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false; // make sure obj isn't null and matches class
        if (this == obj) return true; // check memory location real quick

        DFAState dfaState = (DFAState) obj; //turn obj into dfaState object
        return getName().equals(dfaState.getName()); //using getName function from base State in DFAState to compare
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
