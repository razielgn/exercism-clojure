(ns grade-school)

(defn grade [db n]
  (get db n []))

(defn add [db student n]
  (let [students (grade db n)
        new-students (conj students student)]
    (assoc db n new-students)))

(defn sorted [db]
  (let [value-sorter (fn [s [k v]]
                       (assoc s k (-> (sort v) vec)))]
    (reduce value-sorter (sorted-map) db)))
