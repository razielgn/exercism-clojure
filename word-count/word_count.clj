(ns word-count
  (:require [clojure.string :as s]))

(defn- str-words [string]
  "Splits a string into words, returns a vector of them."
  (let [cleaned (s/replace string #"[^a-zA-Z0-9 ]" "")]
    (s/split cleaned #" +")))

(defn word-count [string]
  "Returns a map with occurrences of every word."
  (let [lower-cased (s/lower-case string)
        words (str-words lower-cased)]
    (frequencies words)))
