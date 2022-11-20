package io.arcanesolutions.giraffe

import arrow.core.Option
import arrow.core.toOption
import java.util.stream.Collectors.toMap

class DirectedGraph<T>(
    private val nodes: Set<DirectedGraphNode<T>>
) {

    private val reverseIndex: Map<DirectedGraphNode<T>, Set<DirectedGraphNode<T>>> = reverseIndex()

    private fun reverseIndex(): Map<DirectedGraphNode<T>, Set<DirectedGraphNode<T>>> =
        nodes
            .stream()
            .map { node ->
                node to nodes
                    .filter { possibleParentNode ->
                        possibleParentNode.connections.contains(node)
                    }
                    .toSet()
            }
            .collect(
                toMap(
                    Pair<DirectedGraphNode<T>, Set<DirectedGraphNode<T>>>::first,
                    Pair<DirectedGraphNode<T>, Set<DirectedGraphNode<T>>>::second))

    fun nodes(): Set<DirectedGraphNode<T>> =
        nodes

    fun areConnectedTo(source: DirectedGraphNode<T>): Option<Set<DirectedGraphNode<T>>> =
        reverseIndex[source].toOption()

}
