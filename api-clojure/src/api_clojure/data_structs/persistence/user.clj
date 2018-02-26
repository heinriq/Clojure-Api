(ns api-clojure.data-structs.persistence.user)

(def Agents-list (atom ()))

(defn Add [agent-array]
    (swap! Agents-list conj agent-array)
  )
