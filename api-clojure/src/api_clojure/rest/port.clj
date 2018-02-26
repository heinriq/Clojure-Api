(ns api-clojure.rest.port
    (:require [api-clojure.rest.address :as address])
)

(defn about-page [_]
    (address/about-page _))

(defn home-page [_]
    (address/home-page _))

(defn get-json [_]
    (address/get-json _))

(defn post-json [request]
  (address/post-json (get-in request [:json-params])))