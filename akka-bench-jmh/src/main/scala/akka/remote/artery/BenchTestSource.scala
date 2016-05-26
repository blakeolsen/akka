/**
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package akka.remote.artery

import akka.stream.Attributes
import akka.stream.Outlet
import akka.stream.SourceShape
import akka.stream.stage.GraphStage
import akka.stream.stage.GraphStageLogic
import akka.stream.stage.OutHandler

class BenchTestSource(elements: Int) extends GraphStage[SourceShape[Int]] {

  val out: Outlet[Int] = Outlet("BenchTestSource")
  override val shape: SourceShape[Int] = SourceShape(out)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic =
    new GraphStageLogic(shape) with OutHandler {

      var n = 0

      override def onPull(): Unit = {
        n += 1
        if (n > elements)
          complete(out)
        else
          push(out, n)
      }

      setHandler(out, this)
    }
}

class BenchTestSourceSameElement[T](elements: Int, elem: T) extends GraphStage[SourceShape[T]] {

  val out: Outlet[T] = Outlet("BenchTestSourceSameElement")
  override val shape: SourceShape[T] = SourceShape(out)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic =
    new GraphStageLogic(shape) with OutHandler {

      var n = 0

      override def onPull(): Unit = {
        n += 1
        if (n > elements)
          complete(out)
        else
          push(out, elem)
      }

      setHandler(out, this)
    }
}
