(ns grade-school)

(defn add [db student grade]
  (let [students (get db grade [])
        new-students (conj students student)]
    (assoc db grade new-students)))

(defn grade [db grade]
  (get db grade []))

(defn sorted [db]
  (let [value-sorter (fn [s [k v]]
                       (assoc s k (-> (sort v) vec)))]
    (reduce value-sorter (sorted-map) db)))
