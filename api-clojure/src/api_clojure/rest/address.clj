(ns api-clojure.rest.address
  (:require
    [clojure.data.json :as json]
    [ring.util.response :as ring-resp]
    [io.pedestal.http.route :as route]
    [io.pedestal.http :as http]
    [api-clojure.data-structs.persistence.user :as user]
    [api-clojure.data-structs.persistence.job :as job]
    [api-clojure.data-structs.persistence.job-request :as job-req]))

(defn about-page
[request]
(ring-resp/response (format "Clojure %s - served from %s"
                            (clojure-version)
                            (route/url-for ::about-page))))

(defn home-page
[request]
(ring-resp/response "Hello World!"))


(let [map {:foo "foo" :list [1 2 3 4 5 6 7 8 9 0]}]
  (defn get-json
    [request]
    (ring-resp/response "{foo:\"foo\"}")))

(defn post-json [json-params]
  (user/Add (filter #(:new_agent %) json-params))
  (job/Add (filter #(:new_job %) json-params))
  (job-req/Add (filter #(:job_request %) json-params))
  (http/json-response {:users @user/Agents-list :jobs @job/Job-List :jobs_requests @job-req/Job-Request-List}))
