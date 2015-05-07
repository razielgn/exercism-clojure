(ns leap)

(defn- div-by? [m n]
  (zero? (mod m n)))

(defn leap-year? [y]
  (cond (div-by? y 400) true
        (div-by? y 100) false
        (div-by? y 4) true
        :else false))
