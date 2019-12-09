package com.lab5.vertx.starter

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.Vertx

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>){
    val steps = startDataBase().future().compose(){
      v -> startHttpServer().future();
    }
    steps.setHandler(startPromise.future().completer());
  }

  fun startDataBase():Promise<Void>{
    val promise = Promise.promise<Void>();

    return promise;
  }

  fun startHttpServer():Promise<Void>{
    val promise = Promise.promise<Void>();

    return promise;
  }

}

