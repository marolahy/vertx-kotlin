package com.lab5.vertx.starter

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.Vertx

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {
    vertx
      .createHttpServer()
      .requestHandler { req ->
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!")
      }
      .listen(8888) { http ->
        if (http.succeeded()) {
          startPromise.complete()
          println("HTTP server started on port 8888")
        } else {
          startPromise.fail(http.cause());
        }
      }
  }

}

fun main(args: Array<String>){
  println("Hello world")
  var vertx:Vertx = Vertx.vertx();
  var verticle:MainVerticle = MainVerticle();
  vertx.deployVerticle(verticle)
  println("Hello world")
}
