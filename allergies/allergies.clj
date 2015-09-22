(ns allergies)

(def ^:private allergies
  ["eggs"
   "peanuts"
   "shellfish"
   "strawberries"
   "tomatoes"
   "chocolate"
   "pollen"
   "cats"])

(defn list [n]
  (->> (map-indexed vector allergies)
       (filter #(bit-test n (first %)))
       (map second)))

(defn allergic-to? [n s]
  (some #{s} (list n)))
