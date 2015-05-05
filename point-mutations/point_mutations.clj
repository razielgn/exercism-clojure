(ns point-mutations)

(defn hamming-distance
  "Computes the Hamming distance between to DNA strands."
  [xs ys]
  (if (= (count xs) (count ys))
    (->> (map not= xs ys)
         (filter identity)
         count)))
