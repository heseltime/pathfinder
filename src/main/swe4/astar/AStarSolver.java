package swe4.astar;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSolver {

  private PriorityQueue<SearchNode> openList = new PriorityQueue<>();
  private Set<SearchNode> closedList = new HashSet<>(); // cameFrom

  // Berechnet eine kostenoptimale Folge von Transitionen, welche den gegebenen
  // Anfangszustand initialState in den Zielzustand targetState überführt.
  // Wirft NoSolutionException (Checked Exception), falls es keine derartige
  // Folge von Transitionen gibt.
  public List<? extends Transition> solve(State initialState, State targetState) throws NoSolutionException {
    openList.add(new SearchNode(initialState, targetState));
    SearchNode currNode;

    while (!openList.isEmpty()) {
      currNode = openList.poll();

      if (currNode.getState().equals(targetState)) {
        return currNode.getTransitionsFromStart();
      }

      closedList.add(currNode);

      for (Transition transition : currNode.getState().transitions()) {
        State n = currNode.getState().apply(transition);
        SearchNode successor = new SearchNode(n, targetState, currNode, transition);

        if (closedList.contains(successor)) { // if already in closed list: nothing to do
          continue;       // closedList keeps the nodes already checked
        }

        double tentative_g = currNode.costsFromStart(); // g value for new path

        if (tentative_g < successor.costsFromStart()) {
          successor.setPredecessor(currNode); // connect nodes

          if(openList.contains(successor)) { // recalibrate
            openList.remove(successor);
            successor.setCostsFromStart(tentative_g);
          }

          openList.add(successor);
        }

      }
    }

    throw new NoSolutionException();
  }

}
