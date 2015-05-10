(ns prime-factors)

(defn- div-by? [n m]
  (zero? (mod n m)))

(defn of [n]
  (loop [n n
         m 2
         factors []]
    (cond
      (= n 1)       factors
      (div-by? n m) (recur (/ n m)
                           m
                           (conj factors m))
      :else         (recur n
                           (inc m)
                           factors))))
