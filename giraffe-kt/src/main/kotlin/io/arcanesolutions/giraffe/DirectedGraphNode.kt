package io.arcanesolutions.giraffe

import java.util.UUID


data class DirectedGraphNode<T>(
    val id: UUID = UUID.randomUUID(),
    val value: T,
    val connections: Set<DirectedGraphNode<T>>
)
