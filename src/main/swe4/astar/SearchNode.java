package swe4.astar;

import java.util.List;

// SearchNode ist eine Hilfsklasse, die zur Implementierung des A*-Algorithmus 
// ben�tigt wird. Damit kann man den Weg von einem SearchNode zum Startknoten
// zur�ckverfolgen, da dieser mit seinem Vorg�ngerknoten verkettet ist. Ein
// SearchNode kennt die Kosten vom Startknoten bis zu ihm selbst. SearchNode 
// kann auch eine Sch�tzung f�r den Weg zum Zielknoten berechnen.
public class SearchNode implements Comparable<SearchNode> {

  // Suchknoten mit dem Zustand state und dem Zielzustand target initialisieren.
  // Es existiert kein Vorg�ngerknoten.
  public SearchNode(State state, State targetState) { throw new UnsupportedOperationException(); }

  // Suchknoten mit dem Zustand state und dem Zielzustand target initialisieren.
  // predecessor ist der Vorg�ngerknoten, von dessen Zustand man mit transition
  // zum Zustand dieses Knotens kommt.
  public SearchNode(State state, State targetState, SearchNode predecessor, Transition transition) { throw new UnsupportedOperationException(); }

  // Gibt den Zustand dieses Knotens zur�ck.
  public State getState() { throw new UnsupportedOperationException(); }

  // Gibt den Vorg�ngerknoten zur�ck.
  public SearchNode getPredecessor() { throw new UnsupportedOperationException(); }

  // Setzt den Vorg�ngerknoten.
  public SearchNode setPredecessor(SearchNode predecessor) {
    throw new UnsupportedOperationException();
  }

  // Gibt Transition zur�ck, die Vorg�ngerknoten in diesen Knoten �berf�hrt.
  public Transition getTransition() {
    throw new UnsupportedOperationException();
  }

  // Setzt Transition, die Vorg�ngerknoten in diesen Knoten �berf�hrt.
  public void setTransition(Transition transition) {
    throw new UnsupportedOperationException();
  }

  // Gibt Kosten vom Startknoten bis zu diesem Knoten zur�ck.
  public double costsFromStart() {
    throw new UnsupportedOperationException();
  }

  // Setzt die Kosten vom Startknoten bis zu diesem Knoten.
  public void setCostsFromStart(double costsFromStart) {
    throw new UnsupportedOperationException();
  }

  // Gibt gesch�tzte Kosten von diesem Knoten bis Zum Zielknoten zur�ck.
  public double estimatedCostsToTarget() {
    throw new UnsupportedOperationException();
  }

  // Gibt Sch�tzung der Kosten vom Startknoten �ber diesen Knoten bis zum
  // Zielknoten zur�ck (= Kosten bis zu diesem Knoten + gesch�tzte Kosten
  // bis zum Zielknoten).
  public double estimatedTotalCosts() {
    throw new UnsupportedOperationException();
  }

  // Gibt zur�ck, ob dieser Knoten und der Knoten other denselben Zustand
  // repr�sentieren.
  // Vorsicht: Enthaltenen Zustand per Wert, vergleichen, nicht die Referenzen.
  // Muss konsistent mit compareTo implementiert werden:
  // a.equals(b) <==> a.comparesTo(b) == 0.
  @Override
  public boolean equals(Object obj) {throw new UnsupportedOperationException();}

  // Notwendig f�r Verwendung in Hash-basierten Beh�ltern. Muss konsistent
  // mit equals implementiert werden: a.equals(b) => a.hashCode() == b.hashCode.
  @Override
  public int hashCode() {
    throw new UnsupportedOperationException();
  }

  // Vergleicht zwei Knoten auf Basis der gesch�tzten Gesamtkosten.
  // <0: Kosten dieses Knotens sind kleiner oder gleich als die Kosten von other.
  //  0: Dieser Knoten und other sind gleich.
  // >0: Kosten dieses Knotens sind h�her als Kosten von other.
  @Override
  public int compareTo(SearchNode other) {throw new UnsupportedOperationException();}

  // Konvertiert die Knotenliste, die bei diesem Knoten ihren Ausgang hat,
  // in eine Liste von Transitionen. Da der Weg in umgekehrter Reihenfolge
  // gespeichert ist, muss die Transitionsliste invertiert werden.
  public List<? extends Transition> getTransitionsFromStart() { throw new UnsupportedOperationException(); }

  @Override
  public String toString() { throw new UnsupportedOperationException(); }
}
