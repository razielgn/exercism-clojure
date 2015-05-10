(ns prime-factors)

(defn- first-factor-of [n]
  (first (drop-while #(pos? (mod n %))
                     (range 2 (inc n)))))

(defn of [n]
  (loop [n n
         factors []]
    (if (= n 1)
      factors
      (let [factor (first-factor-of n)]
        (recur (/ n factor)
               (conj factors factor))))))
