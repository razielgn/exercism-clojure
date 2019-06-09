(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn armstrong? [n]
  (let [digits (->> (str n)
                    (map #(Character/getNumericValue %)))]
    (->> digits
         (map #(math/expt % (count digits)))
         (reduce +)
         (= n))))
