package swe4.astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// SearchNode ist eine Hilfsklasse, die zur Implementierung des A*-Algorithmus 
// benötigt wird. Damit kann man den Weg von einem SearchNode zum Startknoten
// zurückverfolgen, da dieser mit seinem Vorgängerknoten verkettet ist. Ein
// SearchNode kennt die Kosten vom Startknoten bis zu ihm selbst. SearchNode 
// kann auch eine Schätzung für den Weg zum Zielknoten berechnen.
public class SearchNode implements Comparable<SearchNode> {


  private State state, targetState;
  private SearchNode predecessor;
  private Transition transition;
  private Double costs;


  // Suchknoten mit dem Zustand state und dem Zielzustand target initialisieren.
  // Es existiert kein Vorgängerknoten.
  public SearchNode(State state, State targetState) {
    this.state = state;
    this.targetState = targetState;
    this.costs = 0.0;
  }

  // Suchknoten mit dem Zustand state und dem Zielzustand target initialisieren.
  // predecessor ist der Vorgängerknoten, von dessen Zustand man mit transition
  // zum Zustand dieses Knotens kommt.
  public SearchNode(State state, State targetState, SearchNode predecessor, Transition transition) {
    this.state = state;
    this.targetState = targetState;
    this.predecessor = predecessor;
    this.transition = transition;
    this.costs = predecessor.costsFromStart() + transition.costs();
  }

  // Gibt den Zustand dieses Knotens zurück.
  public State getState() {
    return this.state;
  }

  // Gibt den Vorgängerknoten zurück.
  public SearchNode getPredecessor() {
    return this.predecessor;
  }

  // Setzt den Vorgängerknoten.
  public SearchNode setPredecessor(SearchNode predecessor) {
    this.predecessor = predecessor;
    return this.predecessor;
  }

  // Gibt Transition zurück, die Vorgängerknoten in diesen Knoten überführt.
  public Transition getTransition() {
    return this.transition;
  }

  // Setzt Transition, die Vorgängerknoten in diesen Knoten überführt.
  public void setTransition(Transition transition) {
    this.transition = transition;
  }

  // Gibt Kosten vom Startknoten bis zu diesem Knoten zurück.
  public double costsFromStart() {
    /*double sum = 0;
    if (this.transition != null) {
      // e.g. first SN has no transition
      sum += this.transition.costs();
    }
    SearchNode currentSN = this;
    // go back to first searchNode, summing the costs backwards
    while (currentSN.getPredecessor() != null) {
      currentSN = currentSN.getPredecessor();
      if (currentSN.getTransition() != null) {
        // e.g. first SN has no transition
        sum += currentSN.getTransition().costs();
      }
    }
    return sum;*/
    return this.costs;
  }

  // Setzt die Kosten vom Startknoten bis zu diesem Knoten.
  public void setCostsFromStart(double costsFromStart) {
    /*SearchNode currentSN = this;
    // go back to first searchNode, setting the costs to new value
    while (this.predecessor != null) {
      currentSN = this.predecessor;
      // TODO
    }*/
    this.costs = costsFromStart;
  }

  // Gibt geschätzte Kosten von diesem Knoten bis Zum Zielknoten zurück.
  public double estimatedCostsToTarget() {
    return this.state.estimatedCostsToTarget(this.targetState);
  }

  // Gibt Schätzung der Kosten vom Startknoten über diesen Knoten bis zum
  // Zielknoten zurück (= Kosten bis zu diesem Knoten + geschätzte Kosten
  // bis zum Zielknoten).
  public double estimatedTotalCosts() {
    return this.costsFromStart() + this.estimatedCostsToTarget();
  }

  // Gibt zurück, ob dieser Knoten und der Knoten other denselben Zustand
  // repräsentieren.
  // Vorsicht: Enthaltenen Zustand per Wert, vergleichen, nicht die Referenzen.
  // Muss konsistent mit compareTo implementiert werden:
  // a.equals(b) <==> a.comparesTo(b) == 0.
  @Override
  public boolean equals(Object obj) {
    return this.hashCode() == obj.hashCode();
  }

  // Notwendig für Verwendung in Hash-basierten Behältern. Muss konsistent
  // mit equals implementiert werden: a.equals(b) => a.hashCode() == b.hashCode.
  @Override
  public int hashCode() {
    return this.state.hashCode();
  }

  // Vergleicht zwei Knoten auf Basis der geschätzten Gesamtkosten.
  // <0: Kosten dieses Knotens sind kleiner oder gleich als die Kosten von other.
  //  0: Dieser Knoten und other sind gleich.
  // >0: Kosten dieses Knotens sind höher als Kosten von other.
  @Override
  public int compareTo(SearchNode other) {
    //return (int) (this.transition.costs() - other.getTransition().costs());
    return (int) (this.costs - other.costsFromStart());
  }

  // Konvertiert die Knotenliste, die bei diesem Knoten ihren Ausgang hat,
  // in eine Liste von Transitionen. Da der Weg in umgekehrter Reihenfolge
  // gespeichert ist, muss die Transitionsliste invertiert werden.
  public List<? extends Transition> getTransitionsFromStart() {
    /*List<Transition> list = new ArrayList<>();
    list.add(this.transition); // current
    SearchNode currentSN = this;
    while (currentSN.getPredecessor() != null) { // previous
      currentSN = this.predecessor;
      list.add(currentSN.getTransition());
    }

    Collections.reverse(list);
    return list;*/

    // with recursion
    List<Transition> list = new ArrayList<>();
    if(predecessor != null) {
      for(Transition edge : predecessor.getTransitionsFromStart()) {
        list.add(edge);
      }
    }
    if(transition != null) {
      list.add(transition);
    }
    return list;
  }

  @Override
  public String toString() {
    System.out.println("..");
    return null;
  }
}
