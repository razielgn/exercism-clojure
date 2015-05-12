(ns raindrops
  (:require [prime-factors :as pf]))

(defn- translator [factor]
  (case factor
    3 "Pling"
    5 "Plang"
    7 "Plong"
    ""))

(defn convert [n]
  (let [factors (into (sorted-set)
                      (pf/of n))]
    (if (some #{3 5 7} factors)
      (->> (map translator factors)
           (reduce str))
      (str n))))
