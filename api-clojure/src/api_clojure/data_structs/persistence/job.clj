(ns api-clojure.data-structs.persistence.job)

(def Job-List (atom ()))

(defn Sorted-Queue [job-list]
  (let [urgent-itens (filter #(:urgent (:new_job %)) job-list)
        not-urgent-itens (remove #(:urgent (:new_job %)) job-list)]
    (reset! Job-List (concat urgent-itens not-urgent-itens))))

(defn Add [job-list]
  (doseq [x job-list] (swap! Job-List conj x))
  (Sorted-Queue @Job-List)
  )




