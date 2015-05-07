(ns etl
  (:require [clojure.string :as s]))

(defn- converter [m [weight nouns]]
  (->> nouns
       (map s/lower-case)
       (reduce #(assoc %1 %2 weight) m)))

(defn transform [data]
  (reduce converter (sorted-map) data))
