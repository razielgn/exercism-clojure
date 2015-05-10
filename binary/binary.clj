(ns binary)

(defn to-decimal [s]
  (loop [n 0
         s s
         i (dec (count s))]
    (case (first s)
      \1 (recur (+ n (int (Math/pow 2 i)))
                (rest s)
                (dec i))
      \0 (recur n
                (rest s)
                (dec i))
      nil n
      0)))
