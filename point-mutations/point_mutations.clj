(ns point-mutations)

(defn hamming-distance
  "Computes the Hamming distance between to DNA strands."
  [xs ys]
  (if (= (count xs) (count ys))
    (->> (map vector xs ys)
         (filter (fn [[x y]] (not= x y)))
         count)))
