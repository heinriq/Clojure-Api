(ns api-clojure.main.service
  (:require [io.pedestal.http :as http]
            [api-clojure.main.route :as route]))

(def service {:env :prod              
  ::http/routes route/routes
  ;;::http/allowed-origins ["scheme://host:port"] :frame-ancestors "'none'"}}
  ::http/resource-path "/public"
  ::http/type :jetty
  ;;::http/host "localhost"
  ::http/port 8080
  ::http/container-options {:h2c? true
                            :h2? false
                            ;:keystore "test/hp/keystore.jks"
                            ;:key-password "password"
                            ;:ssl-port 8443
                            :ssl? false}})            

