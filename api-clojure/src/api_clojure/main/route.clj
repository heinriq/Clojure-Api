(ns api-clojure.main.route
    (:require 
        [io.pedestal.http.body-params :as body-params]
        [io.pedestal.http :as http]
        [api-clojure.rest.port :as port]))

(def common-interceptors [(body-params/body-params) http/html-body])
(def common-interceptors-json [(body-params/body-params) http/json-body])

(def wrap (partial conj common-interceptors))
(def wrap-json (partial conj common-interceptors-json))
;; Tabular routes
(def routes #{["/" :get (wrap #'port/home-page) :route-name :home-page]
              ["/about" :get (wrap #'port/about-page) :route-name :about-page]
              ["/json" :get (wrap-json #'port/get-json) :route-name :get-json]
              ["/json" :post (wrap #'port/post-json) :route-name :post]
              })
