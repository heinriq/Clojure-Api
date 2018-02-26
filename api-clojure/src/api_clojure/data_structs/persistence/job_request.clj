(ns api-clojure.data-structs.persistence.job-request)

(def Job-Request-List (atom ()))

(defn Add [job-req-list]

  (swap! Job-Request-List conj job-req-list))
