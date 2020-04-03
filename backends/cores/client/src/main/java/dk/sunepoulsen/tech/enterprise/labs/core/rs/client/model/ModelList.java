package dk.sunepoulsen.tech.enterprise.labs.core.rs.client.model;

import java.util.List;
import java.util.Objects;

/**
 * Object with a list of results
 *
 * @param <T> Type of each item in the list of results.
 */
public class ModelList<T> implements BaseModel {
    /**
     * List of results
     */
    private List<T> results;

    public ModelList() {
    }

    public ModelList( List<T> results ) {
        this.results = results;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults( List<T> results ) {
        this.results = results;
    }

    @Override
    public boolean equals( Object o ) {
        if( this == o ) {
            return true;
        }
        if( !( o instanceof ModelList ) ) {
            return false;
        }
        ModelList<?> modelList = ( ModelList<?> ) o;
        return Objects.equals( results, modelList.results );
    }

    @Override
    public int hashCode() {
        return Objects.hash( results );
    }

    @Override
    public String toString() {
        return "ModelList{" +
            "results=" + results +
            '}';
    }
}
